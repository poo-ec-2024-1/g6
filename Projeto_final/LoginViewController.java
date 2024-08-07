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


/**
 * Controlador da Tela de Login.
 * Responsável pelo funcionamento correto da tela de login junto com o banco de dados fornecido permitindo a navegação pelas tela seguintes.
 */
public class LoginViewController {
    //Email do usuário
    @FXML
    private TextField emailField;

    //Senha do usuário
    @FXML
    private PasswordField senhaField;

    //Botão de login
    @FXML
    private Button loginButton;

     //Botão para ir para o cadastro
    @FXML
    private Button cadastrarButton;


    // Outros métodos e lógicas de login aqui
    /**
     * O usuário insere os dados e pressiona o botão de login.
     * Assim o sistema recebe as informações do usuário verificando se são válidas segundo o banco de dados.
     * Caso as informações sejam aceitas, abre a tela de perfil do usuário.
     * Enquanto se forem negadas apresenta uma mensagem de erro.  
     */
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

    
    /**
     * Quando o usuário pressiona o botão de cadastro é aberto uma nova janela.
     * Tela criada para o usuário realizar o cadastro.
     * Há a opção de fechar a janela de login.
     */
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


    /**
     * Verifica se as informações (email e senha) fornecidas existem no banco de dados.
     * @return true caso sejam válidas.
     * @return false caso sejam inválidas.
     */
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

    
    /**
     * Se o login for aceito abre o arquivo FXML da tela de perfil.
     * Fecha a tela de login opcionalmente.
     */
    public void abrirTelaPerfil() {
        try {
            // Carrega o arquivo FXML da tela de perfil
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
