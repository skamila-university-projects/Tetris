package skamila.tetris.states;

import skamila.tetris.TetrisBlockState;

public class T2 implements TetrisBlockState {

    Point[] state;

    T2() {

        // state = new int[][] { { 0, 0, 0 }, { 1, 1, 1 }, { 0, 1, 0 }, };
    }

    @Override
    public Point[] getPositionValues() {

        return state;
    }
}
