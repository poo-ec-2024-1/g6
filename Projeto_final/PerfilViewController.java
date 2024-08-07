import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.control.Button;
import java.io.IOException;


/**
 * Controlador para a visão do perfil do usuário.
 * Responsável por apresentar os dados do perfil do usuário.
 * Responsável pelo funcionamento dos botões no perfil.
 */
public class PerfilViewController {
    //Label para a descrição
    @FXML
    private Label descricaoLabel;
    
    //Label para o curso
    @FXML
    private Label cursoLabel;
    
     //Label para o nome
    @FXML
    private Label nomeLabel;
    
    //Label para o email
    @FXML
    private Label emailLabel;
    
    //Botão para iniciar o quiz
    @FXML
    private Button quizButton; 
    
    //Botão para acessar os grupos de estudo
    @FXML
    private Button gruposButton;

    //Botão de voltar
    @FXML
    private Button voltarButton;
    
    //Email do usuário logado
    private String currentUserEmail;

    //Botão do projeto
    @FXML
    private Button projetoButton;
        /**
     * Método iniciado com a inicialização do fxml.
     * Carrega o email e os dados do perfil
     */
    @FXML
    private void initialize() {
         currentUserEmail= UserSession.getInstance().getEmail();
        carregarDadosDoUsuario();
    }
    
    /**
     * Carrega os dados do usuário pelo banco de dados.
     * Apresenta os dados nos labels.
     */
    private void carregarDadosDoUsuario() {
        String nome = buscarNomeDoUsuario(currentUserEmail);
        String curso = buscarCursoDoUsuario(currentUserEmail);
        String descricao = buscarDescricaoDoUsuario(currentUserEmail);

        nomeLabel.setText(nome);
        cursoLabel.setText(curso);
        descricaoLabel.setText(descricao);
        emailLabel.setText(currentUserEmail);
    }

    /**
     * Busca o nome do usuário no banco de dados.
     * Se encontra @return o nome do usuário. 
     * Se não encontra @return uma mensagem de erro.
     */
    private String buscarNomeDoUsuario(String email) {
        String sql = "SELECT nome FROM Usuarios WHERE email = ?";
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:Usuarios.db");
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, email);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getString("nome");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Usuário não encontrado";
    }

    /**
     * Busca o curso do usuário no banco de dados.
     * Se encontra @return o curso do usuário.
     * Se não encontra @return uma mensagem de erro.
     */
    private String buscarCursoDoUsuario(String email) {
        String sql = "SELECT curso FROM Usuarios WHERE email = ?";
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:Usuarios.db");
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, email);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getString("curso");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Curso não encontrado";
    }

    /**
     * Busca a descrição do usuário no banco de dados.
     * Se encontra @return a descrição do usuário.
     * Se não encontra @return uma mensagem de erro.
     */
    private String buscarDescricaoDoUsuario(String email) {
        String sql = "SELECT descricao FROM Usuarios WHERE email = ?";
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:Usuarios.db");
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, email);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getString("descricao");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Descrição não encontrada";
    }
    
    /**
     * Controla o botão de seleção de quiz.
     * Carrega a tela de seleção de quiz.
     */
    @FXML
    private void handleSelecaoButtonAction() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("selecao.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) quizButton.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Controla o botão de grupos de estudo.
     * Carrega a tela de grupos de estudo.
     */
    @FXML
    private void handleGruposButtonAction() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("grupo_estudo.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) gruposButton.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    /**
     * Controla o botão de voltar.
     * Carrega anterior novamente.
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


    /**
     * Controla o botão de grupos de estudo.
     * Carrega a tela de grupos de estudo.
     */
    @FXML
    private void handleProjetoButtonAction() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("projeto.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) projetoButton.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
