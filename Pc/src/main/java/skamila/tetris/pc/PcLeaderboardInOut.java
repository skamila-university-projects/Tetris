package skamila.tetris.pc;

import skamila.tetris.api.leaderboard.LeaderboardInOut;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

public class PcLeaderboardInOut implements LeaderboardInOut {

	private String[] names;

	private int[] scores;

	private String filePath;

	public PcLeaderboardInOut(String filePath) throws IllegalArgumentException {

		this(filePath, 10);
	}

	public PcLeaderboardInOut(String filePath, int leaderboardLength) throws IllegalArgumentException {

		this.names = new String[leaderboardLength];
		this.scores = new int[leaderboardLength];
		this.filePath = filePath;
		load();
	}

	@Override
	public void load() {

		Path path = Paths.get(filePath);
		BufferedReader reader = null;

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

	@Override
	public void update() {

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

	@Override
	public String[] getNames() {

		return names;
	}

	@Override
	public int[] getScores() {

		return scores;
	}

	private String[] getEntry(String line) {

		return line.split("\\|");
	}

}
