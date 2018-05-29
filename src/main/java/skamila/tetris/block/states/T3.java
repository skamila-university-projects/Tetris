package skamila.tetris.block.states;

import skamila.tetris.block.BlockState;

public class T3 implements BlockState {

    Point[] state;

    T3() {

        // state = new int[][] { { 0, 1, 0 }, { 1, 1, 0 }, { 0, 1, 0 }, };
    }

    @Override
    public Point[] getPositionValues() {

        return state;
    }
}
