package skamila.tetris.block.state;

public class O implements State {
    int[][] state;

    O() {
        state = new int[][]
                {
                        {1, 1},
                        {1, 1},
                };
    }

    @Override
    public int getPositionValue(int x, int y) {
        return state[x][y];
    }
}
