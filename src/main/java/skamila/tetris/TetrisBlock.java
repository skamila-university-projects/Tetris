package skamila.tetris;

import skamila.tetris.board.Board;

public interface TetrisBlock {

    TetrisBlockState getActiveState();

    void rotate();

    void randomizeActiveState();

    void moveLeft(Board board);

    void moveRight(Board board);

    void moveDown(Board board);
}
