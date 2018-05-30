package skamila.tetris.block.states;

import skamila.tetris.block.BlockState;

public class Z2 implements BlockState {

    Point[] state;

    // X
    // X X
    // X

    Z2() {

        state = new Point[] {
            new Point(2, 0),
            new Point(1, 1),
            new Point(2, 1),
            new Point(1, 2),
        };
    }

    @Override
    public Point[] getPositionValues() {

        return state;
    }
}
