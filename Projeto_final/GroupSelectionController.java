import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * Controlador para a seleção de grupos.
 * Responsável pelo processamento dos grupos pelo banco de dados do SQLite.
 * O usuário consegue acessar um grupo com a tela de chat do selecionado.
 */
public class GroupSelectionController {
    //ComboBox para exibir os grupos
    @FXML
    private ComboBox<String> groupComboBox;

    //Botão para entrada em gupo
    @FXML
    private Button enterGroupButton;

    //Botão para voltar
    @FXML
    private Button voltarButton;

    
    /**
     * Método de inicialização do controlador.
     * Carrega os grupos do banco de dados na tela pelo arquivo fxml.
    */
    @FXML
    private void initialize() {
        carregarGrupos();
    }

     /**
     * Carrega os grupos do banco de dados do SQLite.
     * Adiciona no ComboBox.
     */
    private void carregarGrupos() {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:grupo.db")) {
            String sql = "SELECT nome FROM Grupos";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                groupComboBox.getItems().add(resultSet.getString("nome"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    /**
     * O usuário seleciona um grupo e pressiona no botão para entrar.
     * O sistema confirma se um grupo foi selecionado para entrar.
     */
    @FXML
    private void handleEnterGroup() {
        String selectedGroup = groupComboBox.getValue();
        if (selectedGroup != null) {
            abrirTelaChat(selectedGroup);
        } else {
            System.out.println("Selecione um grupo.");
        }
    }

    
    /**
     * A tela do chat do grupo é aberta de acordo com o grupo selecionado.
     * Caso não tenha sido selecionado um grupo é apresentado uma mensagem de erro.
     */
    private void abrirTelaChat(String group) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ChatView.fxml")); // Verifique o caminho aqui
            Parent root = loader.load();

            ChatViewController controller = loader.getController();
            controller.setGrupo(group); // Verifique se este método existe

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Chat do Grupo");
            stage.setScene(scene);
            stage.show();

            // Fechar a janela atual de seleção de grupo
            Stage currentStage = (Stage) enterGroupButton.getScene().getWindow();
            currentStage.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao abrir a tela de chat: " + e.getMessage());
        }
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

