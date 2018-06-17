package skamila.tetris.block.states;

import skamila.tetris.block.BlockState;
import skamila.tetris.block.StatePoint;

public class J2 implements BlockState {

    StatePoint[] state;

    // X
    // X
    // X X

    public J2() {

        state = new StatePoint[] {
            new StatePoint(1, 0),
            new StatePoint(1, 1),
            new StatePoint(0, 2),
            new StatePoint(1, 2),
        };
    }

    @Override
    public StatePoint[] getPositionValues() {

        return state;
    }
}
