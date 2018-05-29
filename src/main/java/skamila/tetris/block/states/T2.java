package skamila.tetris.block.states;

import skamila.tetris.block.BlockState;

public class T2 implements BlockState {

    Point[] state;

    T2() {

        // state = new int[][] { { 0, 0, 0 }, { 1, 1, 1 }, { 0, 1, 0 }, };
    }

    @Override
    public Point[] getPositionValues() {

        return state;
    }
}
