package skamila.tetris.block.states;

import skamila.tetris.block.BlockState;

public class I1 implements BlockState {

    Point[] state;

    // X
    // X
    // X
    // X

    public I1() {

        state = new Point[] {
            new Point(1, 0),
            new Point(1, 1),
            new Point(1, 2),
            new Point(1, 3)
        };
    }

    @Override
    public Point[] getPositionValues() {

        return state;
    }
}
