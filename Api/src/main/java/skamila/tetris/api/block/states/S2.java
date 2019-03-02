package skamila.tetris.api.block.states;

import skamila.tetris.api.block.BlockState;
import skamila.tetris.api.block.StatePoint;

public class S2 implements BlockState {

	StatePoint[] state;

	// X
	// X X
	// X

	public S2() {

		state = new StatePoint[]{new StatePoint(0, 0), new StatePoint(0, 1), new StatePoint(1, 1),
				new StatePoint(1, 2),};
	}

	@Override
	public StatePoint[] getPositionValues() {

		return state;
	}
}
