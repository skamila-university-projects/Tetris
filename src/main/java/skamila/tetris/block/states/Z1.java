package skamila.tetris.block.states;

import skamila.tetris.block.BlockState;

public class Z1 implements BlockState {

    Point[] state;

    Z1() {

        // state = new int[][] { { 1, 1, 0 }, { 0, 1, 1 }, { 0, 0, 0 }, };
    }

    @Override
    public Point[] getPositionValues() {

        return state;
    }
}
