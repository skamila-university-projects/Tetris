package skamila.tetris.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class GameController {

    @FXML
    private Text exit;

    public void onClickExit() throws IOException {
        Stage stage = (Stage) exit.getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("/view/menu.fxml"));
        Scene scene = new Scene(root);

        stage.setScene(scene);
    }

}
