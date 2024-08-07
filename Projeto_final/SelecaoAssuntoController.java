import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


/**
 * Controlador para a seleção de assuntos para o quiz.
 */
public class SelecaoAssuntoController {
    //ComboBox para exibir os assuntos
    @FXML
    private ComboBox<String> assuntoComboBox;

    //Botão para confirmar a seleção do assunto
    @FXML
    private Button confirmarButton;

    //Botão de voltar
    @FXML
    private Button voltarButton;

    /**
     * Método após a inicialização do arquivo fxml.
     * Carrega os assuntos do ComboBox.
     */
    @FXML
    public void initialize() {
        carregarAssuntos();
    }
    
    /**
     * Confirma se foi selecionado algum assunto.
     * Caso tenha sido inicia o quiz com o assunto escolhido.
     * Caso não tenha sido apresenta uma mensagem de erro.
     */
    @FXML
    private void handleConfirmar() {
        String assuntoSelecionado = assuntoComboBox.getSelectionModel().getSelectedItem();
        if (assuntoSelecionado != null) {
            // Lógica para iniciar o quiz com o assunto selecionado
            System.out.println("Assunto selecionado: " + assuntoSelecionado);

            // Carregar a nova cena do quiz
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/quiz.fxml"));
                Parent root = loader.load();

                // Passar o assunto selecionado para o controller do quiz
                QuizViewController quizController = loader.getController();
                quizController.inicializarComAssunto(assuntoSelecionado);

                Stage stage = (Stage) confirmarButton.getScene().getWindow();
                stage.setScene(new Scene(root));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Nenhum assunto selecionado.");
        }
    }

    
    /**
     * Carrega a lista com os assuntos disponíveis no banco de dados.
     * Adiciona o assunto ao ComboBox.
     */
    private void carregarAssuntos() {
        ArrayList<String> assuntos = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:quiz.db")) {
            String sql = "SELECT nome FROM Assuntos";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                assuntos.add(rs.getString("nome"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        assuntoComboBox.getItems().addAll(assuntos);
    }

    
    /**
     * Controla o botão de voltar.
     * Carrega anterior novamente.
     */
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



