package skamila.tetris.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import skamila.tetris.leaderboard.Leaderboard;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LeaderboardController implements Initializable {

    @FXML
    private Text exit;

    @FXML
    private GridPane leadearboardTab;

    Leaderboard leaderboard;

    public LeaderboardController(Leaderboard leaderboard) {

        this.leaderboard = leaderboard;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        for (int i = 0; i < leaderboard.length(); i++) {
            Text name = new Text();
            Text score = new Text();
            name.setText(leaderboard.getName(i));
            score.setText(Integer.toString(leaderboard.getScore(i)));
            name.setFill(Color.WHITE);
            score.setFill(Color.WHITE);
            if (leaderboard.getScore(i) == 0) {
                break;
            }
            leadearboardTab.add(name, 1, i + 1);
            leadearboardTab.add(score, 2, i + 1);
        }

    }

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
