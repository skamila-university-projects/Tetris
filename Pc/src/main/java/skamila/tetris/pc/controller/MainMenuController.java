package skamila.tetris.pc.controller;

import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import skamila.tetris.api.Tetris;
import skamila.tetris.api.leaderboard.Leaderboard;
import skamila.tetris.pc.LeaderboardManager;
import skamila.tetris.pc.TetrisGame;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainMenuController implements Initializable {

	@FXML
	private Label start;

	@FXML
	private Label settings;

	@FXML
	private Label scores;

	@FXML
	private Label exit;

	@FXML
	private VBox mainMenuContainer;

	private String currentLabel;

	private Label activeMenuItem;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		currentLabel = start.getText();
		start.setText("> " + currentLabel + " <");

		activeMenuItem = start;
	}

	public void onMouseEnterMenuItem(Event event) {

		setActiveLabel((Label) event.getSource());
	}

	public void onKeyPress(KeyEvent event) throws IOException {

		KeyCode keyCode = event.getCode();
		VBox menuContainer = (VBox) event.getSource();

		VBox menuItemsContainer = (VBox) menuContainer.lookup("#menuItems");

		ObservableList<Node> menuItems = menuItemsContainer.getChildren();

		if (keyCode == KeyCode.DOWN) {
			int activeItemIndex = menuItems.indexOf(activeMenuItem) + 1;
			if (activeItemIndex > 3) {
				activeItemIndex = 0;
			}

			setActiveLabel((Label) menuItems.get(activeItemIndex));
		}

		if (keyCode == KeyCode.UP) {
			int activeItemIndex = menuItems.indexOf(activeMenuItem) - 1;
			if (activeItemIndex < 0) {
				activeItemIndex = 3;
			}

			setActiveLabel((Label) menuItems.get(activeItemIndex));
		}

		if (keyCode == KeyCode.ENTER) {
			activeMenuItem.fireEvent(new Event(MouseEvent.MOUSE_CLICKED));
		}
	}

	public void onClickLabelStart() throws IOException {

		Stage stage = (Stage) exit.getScene().getWindow();

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/game.fxml"));
		loader.setControllerFactory(param -> new GameController(new TetrisGame()));

		Parent root = loader.load();

		Scene scene = new Scene(root);

		stage.setScene(scene);
		stage.show();

		root.lookup("#game").requestFocus();
	}

	public void onClickLabelLeaderboards() throws IOException {

		Stage stage = (Stage) exit.getScene().getWindow();

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/leaderboard.fxml"));

		LeaderboardManager leaderboardManager = new LeaderboardManager("leaderboard.txt");
		leaderboardManager.loadFromFile();

		loader.setControllerFactory(param -> new LeaderboardController(
				new Leaderboard(leaderboardManager.getNames(), leaderboardManager.getScores())));

		Scene scene = new Scene(loader.load());
		stage.setScene(scene);
	}

	public void onClickLabelSettings() throws IOException {

		Stage stage = (Stage) exit.getScene().getWindow();

		LeaderboardManager leaderboardManager = new LeaderboardManager("leaderboard.txt");
		leaderboardManager.loadFromFile();
		Tetris tetris = Tetris.create(new Leaderboard(leaderboardManager.getNames(), leaderboardManager.getScores()));

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/settings.fxml"));
		loader.setControllerFactory(param -> new SettingsController(tetris));

		Scene scene = new Scene(loader.load());

		stage.setScene(scene);
	}

	public void onClickLabelExit() {

		Stage stage = (Stage) exit.getScene().getWindow();

		stage.close();
	}

	private void setActiveLabel(Label newLabel) {

		activeMenuItem.setText(currentLabel);

		currentLabel = newLabel.getText();
		newLabel.setText("> " + currentLabel + " <");

		activeMenuItem = newLabel;
	}
}
