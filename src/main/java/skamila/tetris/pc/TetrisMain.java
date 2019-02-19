package skamila.tetris.pc;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;

public class TetrisMain extends Application {

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/view/main-menu.fxml"));

        Scene scene = new Scene(root);

        primaryStage.setTitle("Tetris");
        primaryStage.setScene(scene);
        primaryStage.show();

        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {

            @Override
            public void handle(WindowEvent t) {

                Tetris tetris = Tetris.create();
                tetris.getGameLoop().stop();

                Platform.exit();
                System.exit(0);
            }
        });

        root.lookup("#main-menu").requestFocus();
    }
}
