package skamila.tetris.block.states;

import skamila.tetris.block.BlockState;

public class J1 implements BlockState {

    Point[] state;

    J1() {

        // state = new int[][] { { 0, 1, 0 }, { 0, 1, 0 }, { 1, 1, 0 }, };
    }

    @Override
    public Point[] getPositionValues() {

        return state;
    }
}
