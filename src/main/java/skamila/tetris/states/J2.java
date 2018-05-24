package skamila.tetris.states;

import skamila.tetris.TetrisBlockState;

public class J2 implements TetrisBlockState {

    Point[] state;

    J2() {

        // state = new int[][] { { 1, 0, 0 }, { 1, 1, 1 }, { 0, 0, 0 }, };
    }

    @Override
    public Point[] getPositionValues() {

        return state;
    }
}
