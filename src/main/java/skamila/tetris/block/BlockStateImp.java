package skamila.tetris.block;

import skamila.tetris.block.states.Point;

public class BlockStateImp implements BlockState {

    private Point[] points;

    public BlockStateImp(Point[] points) {

        this.points = points;
    }

    @Override
    public Point[] getPositionValues() {

        return points;
    }
}
