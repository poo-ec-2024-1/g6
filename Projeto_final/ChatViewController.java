import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Controlador da tela de chat.
 * Resposável por exibir as mensagens carregadas do banco de dados.
 * Além de posssibiltar o envio de novas mensagens.
 */
public class ChatViewController {
    //Área de chat
    @FXML
    private TextArea chatArea;

    //Mensagem do chat
    @FXML
    private TextField messageField;

    //Botão de envio de mensagem 
    @FXML
    private Button sendButton;

    private String grupo;
    
    @FXML
    private Button voltarButton;

    public void setGrupo(String grupo) {
        this.grupo = grupo;
        carregarMensagens();
    }

    
    /**
     * O carregamento das mensagens do grupo é feito pelo banco de dados e mostrado no chat.
     */
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

    
    /**
     * O usuário após digitar a mensagem pressiona o botão de enviar e o sistema a apresenta no chat.
     */
    @FXML
    private void handleSendMessage() {
        String mensagem = messageField.getText();
        if (!mensagem.isEmpty()) {
            inserirMensagemNoBanco(mensagem);
            chatArea.appendText(mensagem + "\n");
            messageField.clear();
        }
    }

    
    /**
     * A nova mensagem inserida também é guardada no banco de dados.
     */
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
