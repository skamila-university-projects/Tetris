package skamila.tetris.block.states;

import skamila.tetris.block.BlockState;

public class L2 implements BlockState {

    Point[] state;

    public L2() {

        // state = new int[][] { { 0, 0, 0 }, { 1, 1, 1 }, { 1, 0, 0 }, };
    }

    @Override
    public Point[] getPositionValues() {

        return state;
    }
}
