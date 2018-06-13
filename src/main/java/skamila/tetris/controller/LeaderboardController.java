package skamila.tetris.controller;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class LeaderboardController {

    @FXML
    private Text exit;

    public void onClickExit() throws IOException {

        Stage stage = (Stage) exit.getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("/view/main-menu.fxml"));
        Scene scene = new Scene(root);

        stage.setScene(scene);

        root.lookup("#main-menu").requestFocus();
    }

    public void onMouseEnter() {

        exit.setText("> Powrot <");
    }

    public void onMouseExit() {

        exit.setText("Powrot");
    }
}
