package skamila.tetris.block.states;

import skamila.tetris.block.BlockState;
import skamila.tetris.block.StatePoint;

public class Z1 implements BlockState {

    StatePoint[] state;

    // X X
    // X X

    public Z1() {

        state = new StatePoint[] {
            new StatePoint(0, 1),
            new StatePoint(1, 1),
            new StatePoint(1, 2),
            new StatePoint(2, 2),
        };
    }

    @Override
    public StatePoint[] getPositionValues() {

        return state;
    }
}
