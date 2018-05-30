package skamila.tetris.block;

import skamila.tetris.board.Board;

public interface Block {

    BlockState getActiveState();

    void rotate();

    void randomizeActiveState();

    void moveLeft(Board board);

    void moveRight(Board board);

    void moveDown(Board board);

    void countInitialShift(Board board);

    BlockState getShiftedActiveState();
}
