package skamila.tetris.states;

import skamila.tetris.TetrisBlockState;

public class I2 implements TetrisBlockState {

    Point[] state;

    public I2() {

        state = new Point[] {
            new Point(0, 0),
            new Point(0, 1),
            new Point(0, 2),
            new Point(0, 3),
        };
    }

    @Override
    public Point[] getPositionValues() {

        return state;
    }
}
