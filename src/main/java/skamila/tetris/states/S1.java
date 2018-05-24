package skamila.tetris.states;

import skamila.tetris.TetrisBlockState;

public class S1 implements TetrisBlockState {

    Point[] state;

    S1() {

        // state = new int[][] { { 0, 1, 1 }, { 1, 1, 0 }, { 0, 0, 0 }, };
    }

    @Override
    public Point[] getPositionValues() {

        return state;
    }
}
