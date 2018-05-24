package skamila.tetris.states;

import skamila.tetris.TetrisBlockState;

public class S2 implements TetrisBlockState {

    Point[] state;

    S2() {

        // state = new int[][] { { 1, 0, 0 }, { 1, 1, 0 }, { 0, 1, 0 }, };
    }

    @Override
    public Point[] getPositionValues() {

        return state;
    }
}
