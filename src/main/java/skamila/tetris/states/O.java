package skamila.tetris.states;

import skamila.tetris.TetrisBlockState;

public class O implements TetrisBlockState {

    Point[] state;

    public O() {

        state = new Point[] {
            new Point(0, 0),
            new Point(0, 1),
            new Point(1, 0),
            new Point(1, 1),
        };
    }

    @Override
    public Point[] getPositionValues() {

        return state;
    }
}
