package skamila.tetris.block.states;

import skamila.tetris.block.BlockState;

public class L4 implements BlockState {

    Point[] state;

    // X
    // X
    // X X

    public L4() {

        state = new Point[] {
            new Point(1, 0),
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
