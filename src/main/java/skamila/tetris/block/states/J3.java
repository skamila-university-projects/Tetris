package skamila.tetris.block.states;

import skamila.tetris.block.BlockState;

public class J3 implements BlockState {

    Point[] state;

    // X
    // X X X

    J3() {

        state = new Point[] {
            new Point(0, 0),
            new Point(0, 1),
            new Point(1, 1),
            new Point(2, 1),
        };
    }

    @Override
    public Point[] getPositionValues() {

        return state;
    }
}
