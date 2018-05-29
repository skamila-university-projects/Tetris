package skamila.tetris.block.states;

import skamila.tetris.block.BlockState;

public class L1 implements BlockState {

    Point[] state;

    public L1() {

        // state = new int[][] { { 0, 1, 0 }, { 0, 1, 0 }, { 0, 1, 1 }, };
    }

    @Override
    public Point[] getPositionValues() {

        return state;
    }
}
