package skamila.tetris.api.block.states;

import skamila.tetris.api.block.BlockState;
import skamila.tetris.api.block.StatePoint;

public class I1 implements BlockState {

    StatePoint[] state;

    // X
    // X
    // X
    // X

    public I1() {

        state = new StatePoint[] {
            new StatePoint(1, 0),
            new StatePoint(1, 1),
            new StatePoint(1, 2),
            new StatePoint(1, 3)
        };
    }

    @Override
    public StatePoint[] getPositionValues() {

        return state;
    }
}
