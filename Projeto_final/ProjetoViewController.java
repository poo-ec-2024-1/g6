import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;

/**
 * Controlador para a tela de visão do projeto.
 */
public class ProjetoViewController {
    //Nome do projeto
    @FXML
    private TextField nomeField;

    //Descrição do projeto
    @FXML
    private TextArea descricaoField;

    //Data de inicio do projeto
    @FXML
    private DatePicker dataInicioPicker;

    //Data de fim do projeto
    @FXML
    private DatePicker dataFimPicker;

    //Botão para cadastrar o projeto
    @FXML
    private Button cadastrarButton;

    //Botão para abrir a tela principal
    @FXML
    private Button abrirTelaPrincipalButton;

    //Botão para voltar
    @FXML
    private Button voltarButton;

    
    /**
     * Método para quando o botão de cadastrar é pressionado.
     * Cadastra um novo projeto no banco de dados.
     */
    @FXML
    private void handleCadastrar() {
        String nome = nomeField.getText();
        String descricao = descricaoField.getText();
        LocalDate dataInicio = dataInicioPicker.getValue();
        LocalDate dataFim = dataFimPicker.getValue();

        if (nome.isEmpty() || descricao.isEmpty() || dataInicio == null || dataFim == null) {
            System.out.println("Preencha todos os campos!");
            return;
        }

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:projetos.db")) {
            String sql = "INSERT INTO Projetos (nome, descricao, data_inicio, data_fim) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nome);
            preparedStatement.setString(2, descricao);
            preparedStatement.setString(3, dataInicio.format(DateTimeFormatter.ISO_DATE));
            preparedStatement.setString(4, dataFim.format(DateTimeFormatter.ISO_DATE));
            preparedStatement.executeUpdate();
            System.out.println("Projeto cadastrado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    /**
     * Método para abrir a tela principal.
     * Carrega a tela principal e fecha a atual.
     */
    @FXML
    private void abrirTelaPrincipal() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/projeto.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Tela Principal");
            stage.setScene(scene);
            stage.show();

            // Fechar a janela atual
            Stage currentStage = (Stage) abrirTelaPrincipalButton.getScene().getWindow();
            currentStage.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    /**
     * Controla o botão de voltar.
     * Carrega a tela anterior novamente.
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
