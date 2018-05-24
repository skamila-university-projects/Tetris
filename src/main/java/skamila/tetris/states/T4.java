package skamila.tetris.states;

import skamila.tetris.TetrisBlockState;

public class T4 implements TetrisBlockState {

    Point[] state;

    T4() {

        // state = new int[][] { { 0, 1, 0 }, { 1, 1, 1 }, { 0, 0, 0 }, };
    }

    @Override
    public Point[] getPositionValues() {

        return state;
    }
}
