package skamila.tetris.block.states;

import skamila.tetris.block.BlockState;

public class J2 implements BlockState {

    Point[] state;

    J2() {

        // state = new int[][] { { 1, 0, 0 }, { 1, 1, 1 }, { 0, 0, 0 }, };
    }

    @Override
    public Point[] getPositionValues() {

        return state;
    }
}
