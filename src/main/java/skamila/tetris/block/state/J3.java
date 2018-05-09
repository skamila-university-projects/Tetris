package skamila.tetris.block.state;

public class J3 implements State {
    int[][] state;

    J3() {
        state = new int[][]
                {
                        {0, 1, 1},
                        {0, 1, 0},
                        {0, 1, 0},
                };
    }

    @Override
    public int getPositionValue(int x, int y) {
        return state[x][y];
    }
}
