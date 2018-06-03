package skamila.tetris.board;

public abstract class BoardFactory {

    public static Board create() {

        BoardField fields[][] = new BoardField[20][10];

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 10; j++) {
                fields[i][j] = new BoardField();
            }
        }

        return new Board(fields);
    }
}
