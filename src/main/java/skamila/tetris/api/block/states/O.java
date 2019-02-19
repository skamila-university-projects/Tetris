package skamila.tetris.api.block.states;

import skamila.tetris.api.block.BlockState;
import skamila.tetris.api.block.StatePoint;

public class O implements BlockState {

    StatePoint[] state;

    // X X
    // X X

    public O() {

        state = new StatePoint[] {
            new StatePoint(0, 0),
            new StatePoint(0, 1),
            new StatePoint(1, 0),
            new StatePoint(1, 1),
        };
    }

    @Override
    public StatePoint[] getPositionValues() {

        return state;
    }
}
