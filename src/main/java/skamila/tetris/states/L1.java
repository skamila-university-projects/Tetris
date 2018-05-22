package skamila.tetris.states;

import skamila.tetris.TetrisBlockState;

public class L1 implements TetrisBlockState {

    int[][] state;

    public L1() {

        state = new int[][] { { 0, 1, 0 }, { 0, 1, 0 }, { 0, 1, 1 }, };
    }

    @Override
    public int getPositionValue(int x, int y) {

        return state[x][y];
    }
}
