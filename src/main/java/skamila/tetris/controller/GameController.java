package skamila.tetris.controller;

import javafx.application.Platform;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import skamila.tetris.Tetris;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable {

    @FXML
    private VBox game;

    @FXML
    private Text exit;

    @FXML
    private VBox confirmation;

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

    @FXML
    private Text pointsText;

    @FXML
    private Text levelText;

    boolean showGameOver;

    boolean showCongratulations;

    private String optionText;

    private Tetris tetris;

    private Thread thread;

    public GameController(Tetris tetris) {

        this.tetris = tetris;
        tetris.applyCurrentLevel();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        if (confirmation != null)
            return;

        tetris.setGameCanvas(canvasGame);
        tetris.setNextBlockCanvas(canvasNextBlock);
        tetris.getGameLoop().start();

        tetris.setPointTextHolder(pointsText);
        tetris.setLevelTextHolder(levelText);
        tetris.setController(this);

        thread = new Thread(tetris);
        tetris.setThread(thread);
        thread.start();

    }

    public void onClickPause() {

        if (tetris.getGameLoop().isPaused()) {
            tetris.getGameLoop().unpause();
        } else {
            tetris.getGameLoop().pause();
        }
    }

    public void onClickExit() throws IOException {

        tetris.getGameLoop().pause();

        Stage stage = (Stage) exit.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/confirmation.fxml"));
        loader.setController(this);

        Scene confirmationScene = new Scene(loader.load());
        stage.setScene(confirmationScene);
    }

    public void onClickConfirmExit() throws IOException {

        tetris.getGameLoop().stop();
        tetris.getGameLoop().unpause();
        tetris.getThread().interrupt();

        Stage stage = (Stage) yes.getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("/view/main-menu.fxml"));
        Scene scene = new Scene(root);

        stage.setScene(scene);
        root.lookup("#main-menu").requestFocus();
    }

    public void onClickCancelExit() throws IOException {

        Stage stage = (Stage) confirmation.getScene().getWindow();

        stage.setScene(game.getScene());

        // tetris.getGameLoop().unpause();
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

        if (event.getCode() == KeyCode.RIGHT) {

            tetris.getCurrentBlock().moveRight(tetris.getBoard());
        }

        if (event.getCode() == KeyCode.LEFT) {

            tetris.getCurrentBlock().moveLeft(tetris.getBoard());
        }

        if (event.getCode() == KeyCode.UP) {

            tetris.getCurrentBlock().rotate(tetris.getBoard());
        }

        if (event.getCode() == KeyCode.DOWN) {

            tetris.getCurrentBlock().moveDown(tetris.getBoard());
        }

        if (event.getCode() == KeyCode.N) {

            if (no != null) {
                onClickCancelExit();
            }
        }

        if (event.getCode() == KeyCode.T) {
            if (yes != null) {
                onClickConfirmExit();
            }
        }

        if (event.getCode() == KeyCode.N) {
            if (yes != null) {
                onClickCancelExit();
            }
        }
    }

    public void onMouseEnterOption(Event event) {

        Text text = (Text) event.getSource();
        optionText = text.getText();
        text.setText("> " + optionText + " <");

    }

    public void onMouseExitOption(Event event) {

        Text text = (Text) event.getSource();
        text.setText(optionText);

    }

    public void showGameOver() throws IOException {

        Stage stage = (Stage) exit.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/game-over.fxml"));
        loader.setControllerFactory(
            param -> new GameOverController(tetris.getPoints(), tetris.getLeaderboard())
        );

        Parent root = loader.load();

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();

        root.lookup("#game-over").requestFocus();
    }

    public void showCongratulation() throws IOException {

        Stage stage = (Stage) exit.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/congratulation.fxml"));
        loader.setControllerFactory(
            param -> new GameOverController(tetris.getPoints(), tetris.getLeaderboard())
        );

        Parent root = loader.load();

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();

        root.lookup("#congratulation").requestFocus();
    }

    public void gameOver() {

        Platform.runLater(() -> {
            try {
                showGameOver();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        );
    }

    public void congratulation() {

        Platform.runLater(() -> {
            try {
                showCongratulation();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        );
    }
}
