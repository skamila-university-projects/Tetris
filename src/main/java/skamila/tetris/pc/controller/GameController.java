package skamila.tetris.pc.controller;

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
import skamila.tetris.pc.TetrisGame;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable {

    @FXML
    private VBox game, confirmation;

    @FXML
    private Text exit, pause, yes, no, pointsText, levelText;

    @FXML
    private Canvas canvasGame, canvasNextBlock;

    boolean showGameOver, showCongratulations;

    private String optionText;

    private TetrisGame tetrisGame;

    private Thread thread;

    public GameController(TetrisGame tetrisGame) {

        this.tetrisGame = tetrisGame;
        tetrisGame.getTetris().applyCurrentLevel();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        if (confirmation != null)
            return;

        tetrisGame.setGameCanvas(canvasGame);
        tetrisGame.setNextBlockCanvas(canvasNextBlock);
        tetrisGame.start();

        tetrisGame.setPointTextHolder(pointsText);
        tetrisGame.setLevelTextHolder(levelText);
        tetrisGame.setController(this);

        thread = new Thread(tetrisGame);
        tetrisGame.getTetris().setThread(thread);
        thread.start();

    }

    public void onClickPause() {

        if (tetrisGame.getTetris().isPaused()) {
            tetrisGame.getTetris().unpause();
        } else {
            tetrisGame.getTetris().pause();
        }
    }

    public void onClickExit() throws IOException {

        tetrisGame.getTetris().pause();

        Stage stage = (Stage) exit.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/confirmation.fxml"));
        loader.setController(this);

        Scene confirmationScene = new Scene(loader.load());
        stage.setScene(confirmationScene);
    }

    public void onClickConfirmExit() throws IOException {

        tetrisGame.stop();
        tetrisGame.getTetris().unpause();
        tetrisGame.getTetris().getThread().interrupt();

        Stage stage = (Stage) yes.getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("/view/main-menu.fxml"));
        Scene scene = new Scene(root);

        stage.setScene(scene);
        root.lookup("#main-menu").requestFocus();
    }

    public void onClickCancelExit() throws IOException {

        Stage stage = (Stage) confirmation.getScene().getWindow();

        stage.setScene(game.getScene());

        // tetrisGame.getGameLoop().unpause();
    }

    public void onKeyPress(KeyEvent event) throws IOException {

        if (!tetrisGame.getTetris().isPaused()) {

            if (event.getCode() == KeyCode.RIGHT || event.getCode() == KeyCode.D) {

                tetrisGame.getTetris().getCurrentBlock().moveRight(tetrisGame.getTetris().getBoard());

            } else if (event.getCode() == KeyCode.LEFT || event.getCode() == KeyCode.A) {

                tetrisGame.getTetris().getCurrentBlock().moveLeft(tetrisGame.getTetris().getBoard());

            } else if (event.getCode() == KeyCode.UP || event.getCode() == KeyCode.W) {

                tetrisGame.getTetris().getCurrentBlock().rotate(tetrisGame.getTetris().getBoard());

            } else if (event.getCode() == KeyCode.DOWN || event.getCode() == KeyCode.S) {

                tetrisGame.getTetris().getCurrentBlock().moveDown(tetrisGame.getTetris().getBoard());
            }
        }

        if (event.getCode() == KeyCode.ESCAPE) {

            onClickExit();

        } else if (event.getCode() == KeyCode.P) {

            onClickPause();

        } else if (event.getCode() == KeyCode.Y || event.getCode() == KeyCode.T) {

            if (yes != null) {
                onClickConfirmExit();
            }

        } else if (event.getCode() == KeyCode.N) {

            if (no != null) {
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
                param -> new GameOverController(tetrisGame.getTetris().getPoints(), tetrisGame.getTetris().getLeaderboard())
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
                param -> new GameOverController(tetrisGame.getTetris().getPoints(), tetrisGame.getTetris().getLeaderboard())
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
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        );
    }

    public void congratulation() {

        Platform.runLater(() -> {
                    try {
                        showCongratulation();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        );
    }
}
