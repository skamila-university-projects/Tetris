package skamila.tetris.states;

import skamila.tetris.TetrisBlockState;

public class L2 implements TetrisBlockState {

    Point[] state;

    public L2() {

        // state = new int[][] { { 0, 0, 0 }, { 1, 1, 1 }, { 1, 0, 0 }, };
    }

    @Override
    public Point[] getPositionValues() {

        return state;
    }
}
