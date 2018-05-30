package skamila.tetris.block.states;

import skamila.tetris.block.BlockState;

public class Z1 implements BlockState {

    Point[] state;

    // X X
    // X X

    Z1() {

        state = new Point[] {
            new Point(0, 1),
            new Point(1, 1),
            new Point(1, 2),
            new Point(2, 2),
        };
    }

    @Override
    public Point[] getPositionValues() {

        return state;
    }
}
