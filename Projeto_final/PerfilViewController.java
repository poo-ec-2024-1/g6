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

public class PerfilViewController {
    @FXML
    private Label descricaoLabel; // Label para a descrição
    @FXML
    private Label cursoLabel; // Label para o curso
    @FXML
    private Label nomeLabel; // Label para o nome
    @FXML
    private Label emailLabel;
    @FXML
    private Button quizButton;
    @FXML
    private Button gruposButton;
    @FXML
    private Button voltarButton;
    
    private String currentUserEmail;
    
    @FXML
    private Button projetoButton;
    
    @FXML
    private void initialize() {
         currentUserEmail= UserSession.getInstance().getEmail();
        carregarDadosDoUsuario();
    }

    private void carregarDadosDoUsuario() {
        String nome = buscarNomeDoUsuario(currentUserEmail);
        String curso = buscarCursoDoUsuario(currentUserEmail);
        String descricao = buscarDescricaoDoUsuario(currentUserEmail);

        nomeLabel.setText(nome);
        cursoLabel.setText(curso);
        descricaoLabel.setText(descricao);
        emailLabel.setText(currentUserEmail);
    }

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
