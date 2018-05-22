package skamila.tetris.states;

import skamila.tetris.TetrisBlockState;

public class Z2 implements TetrisBlockState {

    int[][] state;

    Z2() {

        state = new int[][] { { 0, 1, 0 }, { 1, 1, 0 }, { 1, 0, 0 }, };
    }

    @Override
    public int getPositionValue(int x, int y) {

        return state[x][y];
    }
}
