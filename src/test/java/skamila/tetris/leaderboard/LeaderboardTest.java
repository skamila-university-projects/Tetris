package skamila.tetris.leaderboard;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LeaderboardTest {

    @Test
    void addNewScore() throws IllegalArgumentException {

        Leaderboard leaderboard = new Leaderboard("test-files/leaderboard.txt");
        leaderboard.clean();

        leaderboard.addNewScore("Lukasz", 4000);
        leaderboard.addNewScore("Przemek", 1000);
        leaderboard.addNewScore("Kamila", 5000);
        leaderboard.addNewScore("Zosia", 2000);
        leaderboard.addNewScore("Krysia", 3000);

        assertEquals(leaderboard.getName(0), "Kamila");
        assertEquals(leaderboard.getScore(0), 5000);
        assertEquals(leaderboard.getName(1), "Lukasz");
        assertEquals(leaderboard.getScore(1), 4000);
        assertEquals(leaderboard.getName(2), "Krysia");
        assertEquals(leaderboard.getScore(2), 3000);
        assertEquals(leaderboard.getName(3), "Zosia");
        assertEquals(leaderboard.getScore(3), 2000);
        assertEquals(leaderboard.getName(4), "Przemek");
        assertEquals(leaderboard.getScore(4), 1000);
    }



    @Test
    void isTheBestScore() {
        Leaderboard leaderboard = new Leaderboard("test-files/leaderboardABC.txt");
        assertEquals(true, leaderboard.isTheBestScore(200));
        assertEquals(true, leaderboard.isTheBestScore(100));
        assertEquals(true, leaderboard.isTheBestScore(80));
        assertEquals(true, leaderboard.isTheBestScore(1));
        assertEquals(false, leaderboard.isTheBestScore(0));
    }

    @Test
    void positionOnLeaderboard() throws IllegalArgumentException {
        Leaderboard leaderboard = new Leaderboard("test-files/leaderboardABC.txt");
        assertEquals(0, leaderboard.positionOnLeaderboard(200));
        assertEquals(1, leaderboard.positionOnLeaderboard(100));
        assertEquals(1, leaderboard.positionOnLeaderboard(80));
        assertEquals(9, leaderboard.positionOnLeaderboard(1));
    }

    @Test
    void moveResults1() throws IllegalArgumentException {
        Leaderboard leaderboard = new Leaderboard("test-files/leaderboardABC.txt");
        leaderboard.moveResults(0);

        assertEquals("a", leaderboard.getName(1));
        assertEquals(100, leaderboard.getScore(1));
        assertEquals("b", leaderboard.getName(2));
        assertEquals(50, leaderboard.getScore(2));
        assertEquals("c", leaderboard.getName(3));
        assertEquals(40, leaderboard.getScore(3));
        assertEquals("d", leaderboard.getName(4));
        assertEquals(30, leaderboard.getScore(4));

    }

    @Test
    void moveResults2() throws IllegalArgumentException {
        Leaderboard leaderboard = new Leaderboard("test-files/leaderboardABC.txt");
        leaderboard.moveResults(1);

        assertEquals("a", leaderboard.getName(0));
        assertEquals(100, leaderboard.getScore(0));
        assertEquals("b", leaderboard.getName(2));
        assertEquals(50, leaderboard.getScore(2));
        assertEquals("c", leaderboard.getName(3));
        assertEquals(40, leaderboard.getScore(3));
        assertEquals("d", leaderboard.getName(4));
        assertEquals(30, leaderboard.getScore(4));

    }
}
