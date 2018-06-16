package skamila.tetris.block;

import skamila.tetris.board.Board;

public interface Block {

    BlockState getActiveState();

    void rotate(Board board);

    void randomizeActiveState();

    void moveLeft(Board board);

    void moveRight(Board board);

    void moveDown(Board board);

    void countInitialShift(Board board);

    boolean isMergable(Board board);

    BlockState getShiftedActiveState();

    String getColor();
}
