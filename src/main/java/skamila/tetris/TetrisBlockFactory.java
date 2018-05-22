package skamila.tetris;

import skamila.tetris.states.*;

import java.util.ArrayList;

public class TetrisBlockFactory {

    public static TetrisBlock L() {

        ArrayList<TetrisBlockState> tetrisBlockStates = new ArrayList<>();

        tetrisBlockStates.add(new L1());
        tetrisBlockStates.add(new L2());
        tetrisBlockStates.add(new L3());
        tetrisBlockStates.add(new L4());

        TetrisBlock block = new TetrisBlockImp(tetrisBlockStates);
        block.randomizeActiveState();

        return block;
    }

    public static TetrisBlock O() {

        ArrayList<TetrisBlockState> tetrisBlockStates = new ArrayList<>();

        tetrisBlockStates.add(new O());

        TetrisBlock block = new TetrisBlockImp(tetrisBlockStates);
        block.randomizeActiveState();

        return block;
    }
}
