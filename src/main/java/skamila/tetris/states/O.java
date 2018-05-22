package skamila.tetris.states;

import skamila.tetris.TetrisBlockState;

public class O implements TetrisBlockState {

    int[][] state;

    public O() {

        state = new int[][] { { 1, 1 }, { 1, 1 }, };
    }

    @Override
    public int getPositionValue(int x, int y) {

        return state[x][y];
    }
}
