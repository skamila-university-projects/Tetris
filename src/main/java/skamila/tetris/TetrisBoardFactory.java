package skamila.tetris;

import skamila.tetris.board.Board;

public abstract class TetrisBoardFactory {

    public static Board create() {

        TetrisBoardField fields[][] = new TetrisBoardField[20][10];

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 10; j++) {
                fields[i][j] = new TetrisBoardFieldImp();
            }
        }

        return new Board(fields);
    }
}
