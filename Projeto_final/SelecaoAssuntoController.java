import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class SelecaoAssuntoController {

    @FXML
    private ComboBox<String> assuntoComboBox;

    @FXML
    private Button confirmarButton;
    
    @FXML
    private Button voltarButton;

    @FXML
    public void initialize() {
        carregarAssuntos();
    }

    @FXML
    private void handleConfirmar() {
        String assuntoSelecionado = assuntoComboBox.getSelectionModel().getSelectedItem();
        if (assuntoSelecionado != null) {
            // Lógica para iniciar o quiz com o assunto selecionado
            System.out.println("Assunto selecionado: " + assuntoSelecionado);

            // Carregar a nova cena do quiz
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/quiz.fxml"));
                Parent root = loader.load();

                // Passar o assunto selecionado para o controller do quiz
                QuizViewController quizController = loader.getController();
                quizController.inicializarComAssunto(assuntoSelecionado);

                Stage stage = (Stage) confirmarButton.getScene().getWindow();
                stage.setScene(new Scene(root));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Nenhum assunto selecionado.");
        }
    }

    private void carregarAssuntos() {
        ArrayList<String> assuntos = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:quiz.db")) {
            String sql = "SELECT nome FROM Assuntos";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                assuntos.add(rs.getString("nome"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        assuntoComboBox.getItems().addAll(assuntos);
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



