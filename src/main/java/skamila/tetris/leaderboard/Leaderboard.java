package skamila.tetris.leaderboard;

import java.util.HashMap;

public class Leaderboard {

    private String[] names;

    private int[] scores;

    public Leaderboard() {

        names = new String[10];
        scores = new int[10];

        for (int s : scores) {
            s = 0;
        }
    }

    public Leaderboard(int leaderboardLength) {

        names = new String[leaderboardLength];
        scores = new int[leaderboardLength];

        for (int s : scores) {
            s = 0;
        }

    }

    public void addNewScore(String name, int score) throws Exception {

        int position = positionOnLeaderboard(score);

        moveResults(position);
        names[position] = name;
        scores[position] = score;

    }

    public boolean isTheBestScore(int score) {

        for (int s : scores) {
            if (score > s)
                return true;
        }

        return false;

    }

    public int positionOnLeaderboard(int score) throws Exception {

        for (int i = 0; i < scores.length; i++) {
            if (score > scores[i])
                return i;
        }
        throw new Exception(); // dodac swoj wyjatek
    }

    public String getName(int position) {

        return names[position];
    }

    public int getScore(int position) {

        return scores[position];
    }

    private void moveResults(int newPosition) {

        for (int i = newPosition; i < scores.length - 1; i++) {
            scores[i + 1] = scores[i];
        }
    }
}
