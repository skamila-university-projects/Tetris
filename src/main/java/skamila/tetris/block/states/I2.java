package skamila.tetris.block.states;

import skamila.tetris.block.BlockState;
import skamila.tetris.block.StatePoint;

public class I2 implements BlockState {

    StatePoint[] state;

    // X X X X

    public I2() {

        state = new StatePoint[] {
            new StatePoint(0, 1),
            new StatePoint(1, 1),
            new StatePoint(2, 1),
            new StatePoint(3, 1),
        };
    }

    @Override
    public StatePoint[] getPositionValues() {

        return state;
    }
}
