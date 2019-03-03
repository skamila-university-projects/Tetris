package skamila.tetris.pc;

import skamila.tetris.api.leaderboard.Leaderboard;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

public class LeaderboardManager {

	private String[] names;
	private int[] scores;
	private String filePath;

	public LeaderboardManager(String filePath) throws IllegalArgumentException {
		this(filePath, 10);
	}

	public LeaderboardManager(String filePath, int leaderboardLength) throws IllegalArgumentException {

		this.names = new String[leaderboardLength];
		this.scores = new int[leaderboardLength];
		this.filePath = filePath;
		loadFromFile();
	}

	public void loadFromFile() {

		Path path = Paths.get(filePath);
		BufferedReader reader;

		try {
			if (Files.notExists(path)) {
				Files.newOutputStream(path, CREATE, APPEND);
				return;
			}

			reader = Files.newBufferedReader(path, Charset.forName("UTF-8"));

			int i = 0;
			String[] tmpEntry;
			String currentLine;

			while ((currentLine = reader.readLine()) != null && i < names.length) {
				tmpEntry = getEntry(currentLine);
				names[i] = tmpEntry[0];
				scores[i] = Integer.parseInt(tmpEntry[1]);
				i++;
			}

			reader.close();

		} catch (IOException e) {
			System.out.print(e.getMessage());
		}

	}

	public void saveDataToFile(Leaderboard leaderboard) {

		names = leaderboard.getNames();
		scores = leaderboard.getScores();

		File file = new File(filePath);
		PrintWriter write = null;

		try {
			write = new PrintWriter(filePath);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}

		for (int i = 0; i < names.length; i++) {
			write.print(names[i] + "|" + scores[i] + "\n");
		}

		write.close();
	}

	public String[] getNames() {

		return names;
	}

	public int[] getScores() {

		return scores;
	}

	private String[] getEntry(String line) {

		return line.split("\\|");
	}

}
