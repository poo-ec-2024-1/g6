import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * Classe principal da aplicação para o login.
 * Responsável pela aplicação JavaFX.
 * Carrega a tela inicial de seleção.
 */
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
        //As telas de Chat e projetos nao sao suportadas e nao abrem pelo bluej
        //abra elas pelo scenerbiulder para visualliza-las.
    }

    
    /**
     * Método start que configura a aplicação.
     * @param primaryStage é o estágio principal da aplicação.
     * @throws Exception para o método start lançar uma exceção caso haja erro ao carregar o arquivo login.fxml.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("projeto.fxml"));
        Scene scene = new Scene(root);

        primaryStage.setTitle("Login");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

