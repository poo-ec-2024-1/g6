import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginViewController {
    @FXML
    private TextField emailField;

    @FXML
    private PasswordField senhaField;

    @FXML
    private Button loginButton;

    @FXML
    private Button cadastrarButton;

    // Outros métodos e lógica da tela de login aqui

    @FXML
    private void handleLogin() {
        String email = emailField.getText();
        String senha = senhaField.getText();

        if (verificarUsuarioNoBanco(email, senha)) {
            UserSession.getInstance().setEmail(email);
            abrirTelaPerfil();
        } else {
            // Exibir mensagem de erro (usuário não encontrado)
            System.out.println("Usuário não encontrado. Verifique o email e senha.");
        }
    }
    
    @FXML
    private void handleCadastro() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("cadastro.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Tela de Cadastro");
            stage.setScene(scene);
            stage.show();

            // Opcional: Fechar a tela de login
            Stage loginStage = (Stage) cadastrarButton.getScene().getWindow();
            loginStage.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private boolean verificarUsuarioNoBanco(String email, String senha) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:usuarios.db");
            String sql = "SELECT * FROM Usuarios WHERE email = ? AND senha = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, senha);
            ResultSet resultSet = preparedStatement.executeQuery();

            // Se houver um resultado, o usuário existe no banco de dados
            return resultSet.next();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void abrirTelaPerfil() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("perfil.fxml"));
            Parent root = loader.load();

            // Cria uma nova cena com a tela de perfil
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Tela de Perfil");
            stage.setScene(scene);
            stage.show();

            // Fecha a tela de login (opcional)
            Stage loginStage = (Stage) loginButton.getScene().getWindow();
            loginStage.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
