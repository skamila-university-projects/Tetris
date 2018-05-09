package skamila.tetris.block.state;

public class S2 implements State {
    int[][] state;

    S2() {
        state = new int[][]
                {
                        {1, 0, 0},
                        {1, 1, 0},
                        {0, 1, 0},
                };
    }

    @Override
    public int getPositionValue(int x, int y) {
        return state[x][y];
    }
}
