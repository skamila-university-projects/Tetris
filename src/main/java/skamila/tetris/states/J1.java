package skamila.tetris.states;

import skamila.tetris.TetrisBlockState;

public class J1 implements TetrisBlockState {

    Point[] state;

    J1() {

        // state = new int[][] { { 0, 1, 0 }, { 0, 1, 0 }, { 1, 1, 0 }, };
    }

    @Override
    public Point[] getPositionValues() {

        return state;
    }
}
