package skamila.tetris.states;

import skamila.tetris.TetrisBlockState;

public class T3 implements TetrisBlockState {

    Point[] state;

    T3() {

        // state = new int[][] { { 0, 1, 0 }, { 1, 1, 0 }, { 0, 1, 0 }, };
    }

    @Override
    public Point[] getPositionValues() {

        return state;
    }
}
