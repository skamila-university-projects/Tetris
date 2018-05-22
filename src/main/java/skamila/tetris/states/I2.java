package skamila.tetris.states;

import skamila.tetris.TetrisBlockState;

public class I2 implements TetrisBlockState {

    int[][] state;

    I2() {

        state = new int[][] {
                { 0, 0, 0, 0 },
                { 0, 0, 0, 0 },
                { 1, 1, 1, 1 },
                { 0, 0, 0, 0 },
        };
    }

    @Override
    public int getPositionValue(int x, int y) {

        return state[x][y];
    }
}
