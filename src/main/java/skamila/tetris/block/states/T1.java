package skamila.tetris.block.states;

import skamila.tetris.block.BlockState;

public class T1 implements BlockState {

    Point[] state;

    T1() {

        // state = new int[][] { { 0, 1, 0 }, { 0, 1, 1 }, { 0, 1, 0 }, };
    }

    @Override
    public Point[] getPositionValues() {

        return state;
    }
}
