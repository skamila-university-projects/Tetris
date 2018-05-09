package skamila.tetris.block.state;

public class L3 implements State {
    int[][] state;

    public L3() {
        state = new int[][]
                {
                        {1, 1, 0},
                        {0, 1, 0},
                        {0, 1, 0},
                };
    }

    @Override
    public int getPositionValue(int x, int y) {
        return state[x][y];
    }
}
