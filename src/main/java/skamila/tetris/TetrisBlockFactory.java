package skamila.tetris;

import skamila.tetris.states.*;

import java.util.ArrayList;

public class TetrisBlockFactory {

    public static TetrisBlock I() {

        TetrisBlockState[] tetrisBlockStates = new TetrisBlockState[2];

        tetrisBlockStates[0] = new I1();
        tetrisBlockStates[1] = new I2();

        TetrisBlock block = new TetrisBlockImp(tetrisBlockStates);
        block.randomizeActiveState();

        return block;
    }

    public static TetrisBlock O() {

        TetrisBlockState[] tetrisBlockStates = new TetrisBlockState[1];

        tetrisBlockStates[0] = new O();

        TetrisBlock block = new TetrisBlockImp(tetrisBlockStates);
        block.randomizeActiveState();

        return block;
    }
}
