package skamila.tetris.block.states;

import skamila.tetris.block.BlockState;

public class I1 implements BlockState {

    Point[] state;

    public I1() {

        state = new Point[] {
            new Point(0, 0),
            new Point(1, 0),
            new Point(2, 0),
            new Point(3, 0),
        };
    }

    @Override
    public Point[] getPositionValues() {

        return state;
    }
}
