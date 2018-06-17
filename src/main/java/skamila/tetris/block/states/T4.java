package skamila.tetris.block.states;

import skamila.tetris.block.BlockState;
import skamila.tetris.block.StatePoint;

public class T4 implements BlockState {

    StatePoint[] state;

    // X
    // X X
    // X

    public T4() {

        state = new StatePoint[] {
            new StatePoint(1, 0),
            new StatePoint(1, 1),
            new StatePoint(2, 1),
            new StatePoint(1, 2),
        };
    }

    @Override
    public StatePoint[] getPositionValues() {

        return state;
    }
}
