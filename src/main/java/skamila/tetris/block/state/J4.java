package skamila.tetris.block.state;

public class J4 implements State {
    int[][] state;

    J4() {
        state = new int[][]
                {
                        {0, 0, 0},
                        {1, 1, 1},
                        {0, 0, 1},
                };
    }

    @Override
    public int getPositionValue(int x, int y) {
        return state[x][y];
    }
}
