package skamila.tetris.block.states;

import skamila.tetris.block.BlockState;

public class J2 implements BlockState {

    Point[] state;

    // X
    // X
    // X X

    J2() {

        state = new Point[] {
            new Point(1, 0),
            new Point(1, 1),
            new Point(0, 2),
            new Point(1, 2),
        };
    }

    @Override
    public Point[] getPositionValues() {

        return state;
    }
}
