import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("view/loging.fxml"));
        primaryStage.setTitle("CHAT APP");
        primaryStage.setScene(new Scene(root , 455,455));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
