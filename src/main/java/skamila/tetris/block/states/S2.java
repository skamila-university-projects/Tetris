package skamila.tetris.block.states;

import skamila.tetris.block.BlockState;

public class S2 implements BlockState {

    Point[] state;

    // X
    // X X
    // X

    S2() {

        state = new Point[] {
            new Point(0, 0),
            new Point(0, 1),
            new Point(1, 1),
            new Point(1, 2),
        };
    }

    @Override
    public Point[] getPositionValues() {

        return state;
    }
}
