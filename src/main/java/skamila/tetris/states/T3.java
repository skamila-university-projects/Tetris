package skamila.tetris.states;

import skamila.tetris.TetrisBlockState;

public class T3 implements TetrisBlockState {

    int[][] state;

    T3() {

        state = new int[][] { { 0, 1, 0 }, { 1, 1, 0 }, { 0, 1, 0 }, };
    }

    @Override
    public int getPositionValue(int x, int y) {

        return state[x][y];
    }
}
