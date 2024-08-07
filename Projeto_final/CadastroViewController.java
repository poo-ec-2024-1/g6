import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.io.IOException;

/**
 * Controlador para a tela de cadastro de usuários.
 */
public class CadastroViewController {
    @FXML
    private TextField nomeField;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField senhaField;

    @FXML
    private PasswordField confirmarSenhaField;

    @FXML
    private Button cadastrarButton;
    
    @FXML
    private Button voltarButton;

    @FXML
    private Label situacaoLabel;

    /**
     * Método após pressionar o botão cadastro.
     * Recebe os dados digitados pelo usuário.
     * Confere se as senhas coincidem.
     * Caso coincidam apresenta uma mensagem de confirmação 
     * Caso não coincidam apresenta uma mensagem de erro.
     */
    @FXML
    private void handleCadastrar() {
        String nome = nomeField.getText();
        String email = emailField.getText();
        String senha = senhaField.getText();
        String confirmarSenha = confirmarSenhaField.getText();

        if (senha.equals(confirmarSenha)) {
            if (inserirDadosNoBanco(nome, email, senha)) {
                situacaoLabel.setText("Usuário cadastrado com sucesso!");
            } else {
                situacaoLabel.setText("Erro ao cadastrar usuário. Tente novamente.");
            }
        } else {
            situacaoLabel.setText("As senhas não coincidem. Tente novamente.");
        }
    }

    
    /**
     * Insere os dados no banco de dados.
     * Caso seja inserido dados válidos @return true
     * Caso seja inserido dados inválidos @return false
     */
    private boolean inserirDadosNoBanco(String nome, String email, String senha) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:usuarios.db");
            String sql = "INSERT INTO usuarios (nome, email, senha) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nome);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, senha);
            int rowsAffected = preparedStatement.executeUpdate();

            connection.close();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    
    /**
     * Botão para voltar para a tela anterior.
     */
    @FXML
    private void handleVoltarButtonAction() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) voltarButton.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
