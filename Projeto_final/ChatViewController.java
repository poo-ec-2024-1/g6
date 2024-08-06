import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ChatViewController {
    @FXML
    private TextArea chatArea;

    @FXML
    private TextField messageField;

    @FXML
    private Button sendButton;

    private String grupo;
    
    @FXML
    private Button voltarButton;

    public void setGrupo(String grupo) {
        this.grupo = grupo;
        carregarMensagens();
    }

    private void carregarMensagens() {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:grupo.db")) {
            String sql = "SELECT mensagem FROM Mensagens WHERE grupo = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, grupo);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                chatArea.appendText(resultSet.getString("mensagem") + "\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleSendMessage() {
        String mensagem = messageField.getText();
        if (!mensagem.isEmpty()) {
            inserirMensagemNoBanco(mensagem);
            chatArea.appendText(mensagem + "\n");
            messageField.clear();
        }
    }

    private void inserirMensagemNoBanco(String mensagem) {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:grupo.db")) {
            String sql = "INSERT INTO Mensagens (grupo, mensagem) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, grupo);
            preparedStatement.setString(2, mensagem);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
}
