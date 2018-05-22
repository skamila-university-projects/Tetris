package skamila.tetris.states;

import skamila.tetris.TetrisBlockState;

public class Z1 implements TetrisBlockState {

    int[][] state;

    Z1() {

        state = new int[][] { { 1, 1, 0 }, { 0, 1, 1 }, { 0, 0, 0 }, };
    }

    @Override
    public int getPositionValue(int x, int y) {

        return state[x][y];
    }
}
