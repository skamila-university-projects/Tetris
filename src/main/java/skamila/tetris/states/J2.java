package skamila.tetris.states;

import skamila.tetris.TetrisBlockState;

public class J2 implements TetrisBlockState {

    int[][] state;

    J2() {

        state = new int[][] { { 1, 0, 0 }, { 1, 1, 1 }, { 0, 0, 0 }, };
    }

    @Override
    public int getPositionValue(int x, int y) {

        return state[x][y];
    }
}
