package skamila.tetris.states;

import skamila.tetris.TetrisBlockState;

public class J4 implements TetrisBlockState {

    int[][] state;

    J4() {

        state = new int[][] { { 0, 0, 0 }, { 1, 1, 1 }, { 0, 0, 1 }, };
    }

    @Override
    public int getPositionValue(int x, int y) {

        return state[x][y];
    }
}
