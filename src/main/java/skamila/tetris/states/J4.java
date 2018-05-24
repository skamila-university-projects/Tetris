package skamila.tetris.states;

import skamila.tetris.TetrisBlockState;

public class J4 implements TetrisBlockState {

    Point[] state;

    J4() {

        // state = new int[][] { { 0, 0, 0 }, { 1, 1, 1 }, { 0, 0, 1 }, };
    }

    @Override
    public Point[] getPositionValues() {

        return state;
    }
}
