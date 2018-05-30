package skamila.tetris.block.states;

import skamila.tetris.block.BlockState;

public class I2 implements BlockState {

    Point[] state;

    // X X X X

    public I2() {

        state = new Point[] {
            new Point(0, 1),
            new Point(1, 1),
            new Point(2, 1),
            new Point(3, 1),
        };
    }

    @Override
    public Point[] getPositionValues() {

        return state;
    }
}
