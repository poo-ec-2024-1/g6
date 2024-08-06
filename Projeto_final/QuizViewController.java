import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.Parent;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class QuizViewController {

    @FXML
    private Label questionLabel;

    @FXML
    private RadioButton option1;

    @FXML
    private RadioButton option2;

    @FXML
    private RadioButton option3;

    @FXML
    private RadioButton option4;

    private ToggleGroup optionsGroup;
    
    @FXML
    private Button voltarButton;

    private String assuntoSelecionado;
    private int currentQuestionIndex = 0;
    private int correctAnswersCount = 0;
    private List<Question> questions = new ArrayList<>();

    @FXML
    public void initialize() {
        optionsGroup = new ToggleGroup();
        option1.setToggleGroup(optionsGroup);
        option2.setToggleGroup(optionsGroup);
        option3.setToggleGroup(optionsGroup);
        option4.setToggleGroup(optionsGroup);
    }

    public void inicializarComAssunto(String assunto) {
        this.assuntoSelecionado = assunto;
        carregarPerguntas();
        exibirPergunta(currentQuestionIndex);
    }

    private void carregarPerguntas() {
        String url = "jdbc:sqlite:quiz.db";
        String sql = "SELECT p.id, p.texto, o.texto, o.correta FROM Perguntas p " +
                     "JOIN Opcoes o ON p.id = o.pergunta_id " +
                     "JOIN Assuntos a ON p.assunto_id = a.id " +
                     "WHERE a.nome = ?";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, assuntoSelecionado);
            ResultSet rs = pstmt.executeQuery();

            Question currentQuestion = null;
            while (rs.next()) {
                int perguntaId = rs.getInt(1);
                String perguntaTexto = rs.getString(2);
                String opcaoTexto = rs.getString(3);
                boolean correta = rs.getBoolean(4);

                if (currentQuestion == null || currentQuestion.getId() != perguntaId) {
                    currentQuestion = new Question(perguntaId, perguntaTexto);
                    questions.add(currentQuestion);
                }

                currentQuestion.addOption(new Option(opcaoTexto, correta));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void exibirPergunta(int index) {
        if (index < questions.size()) {
            Question question = questions.get(index);
            questionLabel.setText(question.getTexto());
            List<Option> options = question.getOptions();

            option1.setText(options.get(0).getTexto());
            option2.setText(options.get(1).getTexto());
            option3.setText(options.get(2).getTexto());
            option4.setText(options.get(3).getTexto());
            optionsGroup.selectToggle(null); // Deseleciona qualquer opção anterior
        }
    }

    @FXML
    private void handleNext() {
        if (optionsGroup.getSelectedToggle() != null) {
            RadioButton selectedOption = (RadioButton) optionsGroup.getSelectedToggle();
            Question currentQuestion = questions.get(currentQuestionIndex);
            Option selected = currentQuestion.getOptions().stream()
                    .filter(option -> option.getTexto().equals(selectedOption.getText()))
                    .findFirst()
                    .orElse(null);

            if (selected != null && selected.isCorreta()) {
                correctAnswersCount++;
            }
        }

        currentQuestionIndex++;
        if (currentQuestionIndex < questions.size()) {
            exibirPergunta(currentQuestionIndex);
        } else {
            mostrarResultado();
        }
    }

    private void mostrarResultado() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Resultado do Quiz");
        alert.setHeaderText(null);
        alert.setContentText("Você acertou " + correctAnswersCount + " de " + questions.size() + " perguntas.");
        alert.showAndWait();
    }

    // Classes auxiliares para representar perguntas e opções
    private static class Question {
        private final int id;
        private final String texto;
        private final List<Option> options = new ArrayList<>();

        public Question(int id, String texto) {
            this.id = id;
            this.texto = texto;
        }

        public int getId() {
            return id;
        }

        public String getTexto() {
            return texto;
        }

        public List<Option> getOptions() {
            return options;
        }

        public void addOption(Option option) {
            options.add(option);
        }
    }

    private static class Option {
        private final String texto;
        private final boolean correta;

        public Option(String texto, boolean correta) {
            this.texto = texto;
            this.correta = correta;
        }

        public String getTexto() {
            return texto;
        }

        public boolean isCorreta() {
            return correta;
        }
    }
    
            @FXML
    private void handleVoltarButtonAction() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("perfil.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) voltarButton.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
