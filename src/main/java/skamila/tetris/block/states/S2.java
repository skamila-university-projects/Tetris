package skamila.tetris.block.states;

import skamila.tetris.block.BlockState;

public class S2 implements BlockState {

    Point[] state;

    S2() {

        // state = new int[][] { { 1, 0, 0 }, { 1, 1, 0 }, { 0, 1, 0 }, };
    }

    @Override
    public Point[] getPositionValues() {

        return state;
    }
}
