package skamila.tetris.block.state;

public class I2 implements State {
    int[][] state;

    I2() {
        state = new int[][]
                {
                        {0, 0, 0, 0},
                        {0, 0, 0, 0},
                        {1, 1, 1, 1},
                        {0, 0, 0, 0},
                };
    }

    @Override
    public int getPositionValue(int x, int y) {
        return state[x][y];
    }
}