package skamila.tetris;

import skamila.tetris.board.Board;
import skamila.tetris.states.*;

import java.util.ArrayList;

public class TetrisBlockFactory {

    Board board;

    public static TetrisBlock I(Board board) {

        TetrisBlockState[] tetrisBlockStates = new TetrisBlockState[2];

        tetrisBlockStates[0] = new I1();
        tetrisBlockStates[1] = new I2();

        TetrisBlock block = new TetrisBlockImp(tetrisBlockStates);
        block.randomizeActiveState();
        block.countInitialShift(board);

        return block;
    }

    public static TetrisBlock O(Board board) {

        TetrisBlockState[] tetrisBlockStates = new TetrisBlockState[1];

        tetrisBlockStates[0] = new O();

        TetrisBlock block = new TetrisBlockImp(tetrisBlockStates);
        block.randomizeActiveState();
        block.countInitialShift(board);

        return block;
    }
}
