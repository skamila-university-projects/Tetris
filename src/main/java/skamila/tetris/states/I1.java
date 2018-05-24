package skamila.tetris.states;

import skamila.tetris.TetrisBlockState;

public class I1 implements TetrisBlockState {

    Point[] state;

    public I1() {

        state = new Point[] {
            new Point(-1, 0),
            new Point(0, 0),
            new Point(1, 0),
            new Point(2, 0),
        };
    }

    @Override
    public Point[] getPositionValues() {

        return state;
    }
}
