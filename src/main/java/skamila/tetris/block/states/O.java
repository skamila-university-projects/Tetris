package skamila.tetris.block.states;

import skamila.tetris.block.BlockState;

public class O implements BlockState {

    Point[] state;

    // X X
    // X X

    public O() {

        state = new Point[] {
            new Point(0, 0),
            new Point(0, 1),
            new Point(1, 0),
            new Point(1, 1),
        };
    }

    @Override
    public Point[] getPositionValues() {

        return state;
    }
}
