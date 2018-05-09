package skamila.tetris.block.state;

public class L2 implements State {
    int[][] state;

    public L2() {
        state = new int[][]
                {
                        {0, 0, 0},
                        {1, 1, 1},
                        {1, 0, 0},
                };
    }

    @Override
    public int getPositionValue(int x, int y) {
        return state[x][y];
    }
}
