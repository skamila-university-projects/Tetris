package skamila.tetris.pc.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import skamila.tetris.pc.Tetris;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SettingsController implements Initializable {

    @FXML
    private Text exit;

    @FXML
    private Text difficultyLvlText;

    private int difficultyLvl = 1;

    private Tetris tetris;

    public SettingsController(Tetris tetris) {

        this.tetris = tetris;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        difficultyLvlText.setText(tetris.getBeginLevel());
        difficultyLvl = new Integer(tetris.getBeginLevel()).intValue();
    }

    public void onClickExit() throws IOException {

        Stage stage = (Stage) exit.getScene().getWindow();

        Parent root = FXMLLoader.load(getClass().getResource("/view/main-menu.fxml"));
        Scene scene = new Scene(root);

        stage.setScene(scene);
    }

    public void onClickIncreaseDifficulty() {

        if (difficultyLvl < 9) {
            difficultyLvl++;
        } else {
            difficultyLvl = 1;
        }

        tetris.setLevel(difficultyLvl);
        difficultyLvlText.setText(Integer.toString(difficultyLvl));
    }

    public void onClickDecreaseDifficulty() {

        if (difficultyLvl > 1) {
            difficultyLvl--;
        } else {
            difficultyLvl = 9;
        }

        tetris.setLevel(difficultyLvl);
        difficultyLvlText.setText(Integer.toString(difficultyLvl));
    }

    public void onMouseEnter() {

        exit.setText("> Powrot <");
    }

    public void onMouseExit() {

        exit.setText("Powrot");
    }
}
