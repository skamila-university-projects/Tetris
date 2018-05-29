package skamila.tetris.block.states;

import skamila.tetris.block.BlockState;

public class L3 implements BlockState {

    Point[] state;

    public L3() {

        // state = new int[][] { { 1, 1, 0 }, { 0, 1, 0 }, { 0, 1, 0 }, };
    }

    @Override
    public Point[] getPositionValues() {

        return state;
    }
}
