package skamila.tetris.pc.controller;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import skamila.tetris.api.leaderboard.Leaderboard;
import skamila.tetris.pc.LeaderboardManager;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GameOverController implements Initializable {

	@FXML
	private Text congratulationScores;

	@FXML
	private Text congratulationPlace;

	@FXML
	private Text congratulationUserName;

	@FXML
	private Text congratulationSave;

	@FXML
	private Text gameOverExit;

	private String optionText;

	private Leaderboard leaderboard;

	private String userName;

	private int score;

	public GameOverController(int score, Leaderboard leaderboard) {

		this.leaderboard = leaderboard;
		this.score = score;
		this.userName = "";
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		congratulationScores.setText("Zdobyles " + score + " punktow.");

		if (leaderboard.isTheBestScore(score)) {
			congratulationPlace.setText("Zajales " + (leaderboard.positionOnLeaderboard(score) + 1) + " miejsce.");
		}

	}

	public void onClickSave(Event event) throws IOException {

		leaderboard.addNewScore(userName, score);
		LeaderboardManager leaderboardManager = new LeaderboardManager("leaderboard.txt");
		leaderboardManager.saveDataToFile(leaderboard);

		Stage stage = (Stage) congratulationSave.getScene().getWindow();

		Parent root = FXMLLoader.load(getClass().getResource("/view/main-menu.fxml"));
		Scene scene = new Scene(root);

		stage.setScene(scene);

		root.lookup("#main-menu").requestFocus();
	}

	public void onClickExit(Event event) throws IOException {

		Stage stage = (Stage) gameOverExit.getScene().getWindow();

		Parent root = FXMLLoader.load(getClass().getResource("/view/main-menu.fxml"));
		Scene scene = new Scene(root);

		stage.setScene(scene);

		root.lookup("#main-menu").requestFocus();
	}

	public void onPressKeyEnterName(KeyEvent event) {

		KeyCode code = event.getCode();
		String currentChar = event.getCode().toString();

		switch (code) {
			case BACK_SPACE : {
				if (userName.length() != 0) {
					userName = userName.substring(0, userName.length() - 1);
				}

				break;
			}

			default : {
				if (code.isLetterKey() && userName.length() <= 10) {
					userName += currentChar;
				}
				break;
			}
		}

		congratulationUserName.setText(userName);

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

}
