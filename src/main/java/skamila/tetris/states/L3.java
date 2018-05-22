package skamila.tetris.states;

import skamila.tetris.TetrisBlockState;

public class L3 implements TetrisBlockState {

    int[][] state;

    public L3() {

        state = new int[][] { { 1, 1, 0 }, { 0, 1, 0 }, { 0, 1, 0 }, };
    }

    @Override
    public int getPositionValue(int x, int y) {

        return state[x][y];
    }
}
