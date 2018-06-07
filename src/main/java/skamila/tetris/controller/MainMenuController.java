package skamila.tetris.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenuController {

    @FXML
    private Label start;

    @FXML
    private Label settings;

    @FXML
    private Label scores;

    @FXML
    private Label exit;

    private String currentLabel;

    @FXML
    public void onClickExit() {

        Stage stage = (Stage) exit.getScene().getWindow();

        stage.close();
    }

    @FXML
    public void onClickStart() throws IOException {

        Stage stage = (Stage) exit.getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("/view/game.fxml"));
        Scene scene = new Scene(root);

        stage.setScene(scene);
    }

    @FXML
    public void onClickLeaderboards() throws IOException {

        Stage stage = (Stage) exit.getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("/view/leaderboard.fxml"));
        Scene scene = new Scene(root);

        stage.setScene(scene);
    }

    @FXML
    public void onClickSettings() throws IOException {

        Stage stage = (Stage) exit.getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("/view/settings.fxml"));
        Scene scene = new Scene(root);

        stage.setScene(scene);
    }

    @FXML
    public void onMouseEnterStart() {

        currentLabel = start.getText();
        start.setText("> " + currentLabel + " <");
    }

    @FXML
    public void onMouseExitStart() {

        start.setText(currentLabel);
    }

    @FXML
    public void onMouseEnterSettings() {

        currentLabel = settings.getText();
        settings.setText("> " + currentLabel + " <");
    }

    @FXML
    public void onMouseExitSettings() {

        settings.setText(currentLabel);
    }

    @FXML
    public void onMouseEnterScores() {

        currentLabel = scores.getText();
        scores.setText("> " + currentLabel + " <");
    }

    @FXML
    public void onMouseExitScores() {

        scores.setText(currentLabel);
    }

    @FXML
    public void onMouseEnterExit() {

        currentLabel = exit.getText();
        exit.setText("> " + currentLabel + " <");
    }

    @FXML
    public void onMouseExitExit() {

        exit.setText(currentLabel);
    }
}
