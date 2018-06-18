package skamila.tetris.leaderboard;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

public class Leaderboard {

    private String[] names;

    private int[] scores;

    private String filePath;

    public Leaderboard(String filePath) throws IllegalArgumentException {

        this.names = new String[10];
        this.scores = new int[10];
        this.filePath = filePath;
        load();
    }

    public Leaderboard(String filePath, int leaderboardLength) throws IllegalArgumentException {

        this.names = new String[leaderboardLength];
        this.scores = new int[leaderboardLength];
        this.filePath = filePath;
        load();
    }

    public void addNewScore(String name, int score) {

        if (isTheBestScore(score)) {

            int position = positionOnLeaderboard(score);

            moveResults(position);
            names[position] = name;
            scores[position] = score;

            update();
        }

    }

    public void clean() {

        this.names = new String[names.length];
        this.scores = new int[scores.length];
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

    private void load() {

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

        }
        catch (IOException e) {
            System.out.print(e.getMessage());
        }

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

    public int length() {

        return scores.length;
    }

    private String[] getEntry(String line) {

        return line.split("\\|");
    }

    private void update() {

        File file = new File(filePath);
        PrintWriter write = null;

        try {
            write = new PrintWriter(filePath);
        }
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        for (int i = 0; i < names.length; i++) {
            write.print(names[i] + "|" + scores[i] + "\n");
        }

        write.close();
    }
}
