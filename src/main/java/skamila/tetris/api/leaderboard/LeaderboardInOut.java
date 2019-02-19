package skamila.tetris.api.leaderboard;

public interface LeaderboardInOut {

    void load();

    void update();

    String[] getNames();

    int[] getScores();
}
