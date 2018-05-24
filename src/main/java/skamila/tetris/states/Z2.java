package skamila.tetris.states;

import skamila.tetris.TetrisBlockState;

public class Z2 implements TetrisBlockState {

    Point[] state;

    Z2() {

        // state = new int[][] { { 0, 1, 0 }, { 1, 1, 0 }, { 1, 0, 0 }, };
    }

    @Override
    public Point[] getPositionValues() {

        return state;
    }
}
