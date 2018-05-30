package skamila.tetris.block.states;

import skamila.tetris.block.BlockState;

public class T1 implements BlockState {

    Point[] state;

    // X X X
    // X

    T1() {

        state = new Point[] {
            new Point(0, 1),
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
