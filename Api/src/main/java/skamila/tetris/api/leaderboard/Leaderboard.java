package skamila.tetris.api.leaderboard;

public class Leaderboard {

	private String[] names;

	private int[] scores;

	public Leaderboard(String[] names, int[] scores) {
		this.names = names;
		this.scores = scores;
	}

	public void addNewScore(String name, int score) {

		if (isTheBestScore(score)) {

			int position = positionOnLeaderboard(score);

			moveResults(position);
			names[position] = name;
			scores[position] = score;
		}

	}

	public boolean isTheBestScore(int score) {

		for (int s : scores) {
			if (score > s)
				return true;
		}

		return false;

	}

	public int positionOnLeaderboard(int score) throws IllegalArgumentException {

		for (int i = 0; i < scores.length; i++) {
			if (score > scores[i]) {
				return i;
			}
		}
		throw new IllegalArgumentException();
	}

	public String getName(int position) {
		return names[position];
	}

	public int getScore(int position) {
		return scores[position];
	}

	public String[] getNames() {
		return names;
	}

	public int[] getScores() {
		return scores;
	}

	public int length() {
		return scores.length;
	}

	void moveResults(int newPosition) {

		int newScores[] = new int[scores.length];
		String newNames[] = new String[names.length];

		for (int i = 0; i < newPosition; i++) {
			newScores[i] = scores[i];
			newNames[i] = names[i];
		}

		for (int i = newPosition; i < scores.length - 1; i++) {
			newScores[i + 1] = scores[i];
			newNames[i + 1] = names[i];
		}

		scores = newScores;
		names = newNames;

	}

}
