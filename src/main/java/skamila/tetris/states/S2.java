package skamila.tetris.states;

import skamila.tetris.TetrisBlockState;

public class S2 implements TetrisBlockState {

    int[][] state;

    S2() {

        state = new int[][] { { 1, 0, 0 }, { 1, 1, 0 }, { 0, 1, 0 }, };
    }

    @Override
    public int getPositionValue(int x, int y) {

        return state[x][y];
    }
}
