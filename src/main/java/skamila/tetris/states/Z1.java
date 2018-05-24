package skamila.tetris.states;

import skamila.tetris.TetrisBlockState;

public class Z1 implements TetrisBlockState {

    Point[] state;

    Z1() {

        // state = new int[][] { { 1, 1, 0 }, { 0, 1, 1 }, { 0, 0, 0 }, };
    }

    @Override
    public Point[] getPositionValues() {

        return state;
    }
}
