package skamila.tetris.block.states;

import skamila.tetris.block.BlockState;

public class S1 implements BlockState {

    Point[] state;

    S1() {

        // state = new int[][] { { 0, 1, 1 }, { 1, 1, 0 }, { 0, 0, 0 }, };
    }

    @Override
    public Point[] getPositionValues() {

        return state;
    }
}
