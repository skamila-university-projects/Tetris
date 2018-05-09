package skamila.tetris.block.state;

public class J2 implements State {
    int[][] state;

    J2() {
        state = new int[][]
                {
                        {1, 0, 0},
                        {1, 1, 1},
                        {0, 0, 0},
                };
    }

    @Override
    public int getPositionValue(int x, int y) {
        return state[x][y];
    }
}
