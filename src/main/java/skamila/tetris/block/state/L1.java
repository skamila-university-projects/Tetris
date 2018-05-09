package skamila.tetris.block.state;

public class L1 implements State {
    int[][] state;

    public L1() {
        state = new int[][]
                {
                        {0, 1, 0},
                        {0, 1, 0},
                        {0, 1, 1},
                };
    }

    @Override
    public int getPositionValue(int x, int y) {
        return state[x][y];
    }
}
