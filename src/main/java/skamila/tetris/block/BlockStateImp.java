package skamila.tetris.block;

public class BlockStateImp implements BlockState {

    private StatePoint[] statePoints;

    public BlockStateImp(StatePoint[] statePoints) {

        this.statePoints = statePoints;
    }

    @Override
    public StatePoint[] getPositionValues() {

        return statePoints;
    }
}
