package skamila.tetris.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import skamila.tetris.Tetris;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable {

    @FXML
    private Text exit;

    @FXML
    private Text pause;

    @FXML
    private Text yes;

    @FXML
    private Text no;

    @FXML
    private Canvas canvasGame;

    @FXML
    private Canvas canvasNextBlock;

    private Tetris tetris;

    private Thread thread;

    public GameController(Tetris tetris) {

        this.tetris = tetris;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        tetris.setGameCanvas(canvasGame);
        tetris.setNextBlockCanvas(canvasNextBlock);
        tetris.getGameLoop().start();
        thread = new Thread(tetris);
        thread.start();
    }

    public void onClickPause() {

        if (tetris.getGameLoop().isPaused()) {
            tetris.getGameLoop().unpouse();
        } else {
            tetris.getGameLoop().pause();
        }

        System.out.println("Is poused: " + tetris.getGameLoop().isPaused());
    }

    public void onClickExit() throws IOException {

        tetris.getGameLoop().pause();

        Stage stage = (Stage) exit.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/confirmation.fxml"));
        loader.setControllerFactory(param -> new GameController(Tetris.create()));

        Parent root = loader.load();

        Scene scene = new Scene(root);

        stage.setScene(scene);
        root.lookup("#confirmation").requestFocus();
    }

    public void onClickConfirmExit() throws IOException {

        tetris.getGameLoop().stop();

        Stage stage = (Stage) yes.getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("/view/main-menu.fxml"));
        Scene scene = new Scene(root);

        stage.setScene(scene);
        root.lookup("#main-menu").requestFocus();
    }

    public void onClickCancelExit() throws IOException {

        tetris.getGameLoop().unpouse();

        Stage stage = (Stage) no.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/game.fxml"));
        loader.setControllerFactory(param -> new GameController(Tetris.create()));

        Parent root = loader.load();

        Scene scene = new Scene(root);

        stage.setScene(scene);
        root.lookup("#game").requestFocus();
    }

    public void onKeyPress(KeyEvent event) throws IOException {

        if (event.getCode() == KeyCode.ESCAPE) {
            onClickExit();
        }

        if (event.getCode() == KeyCode.P) {
            onClickPause();
        }

        if (event.getCode() == KeyCode.Y) {

            if (yes != null) {
                onClickConfirmExit();
            }
        }

        if (event.getCode() == KeyCode.N) {

            if (no != null) {
                onClickCancelExit();
            }
        }
    }
}
