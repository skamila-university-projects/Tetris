package skamila.tetris;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TetrisMain extends Application {

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/view/layout.fxml"));

        Scene scene = new Scene(root);

        primaryStage.setTitle("Tetris");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
