package skamila.tetris.block.states;

import skamila.tetris.block.BlockState;

public class T3 implements BlockState {

    Point[] state;

    // X
    // X X X

    T3() {

        state = new Point[] {
            new Point(1, 0),
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
