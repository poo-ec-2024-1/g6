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

public class GroupSelectionController {
    @FXML
    private ComboBox<String> groupComboBox;

    @FXML
    private Button enterGroupButton;
    
    @FXML
    private Button voltarButton;

    @FXML
    private void initialize() {
        carregarGrupos();
    }

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

    @FXML
    private void handleEnterGroup() {
        String selectedGroup = groupComboBox.getValue();
        if (selectedGroup != null) {
            abrirTelaChat(selectedGroup);
        } else {
            System.out.println("Selecione um grupo.");
        }
    }

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

