package skamila.tetris;

import skamila.tetris.states.Point;

public class TetrisBlockStateImp implements TetrisBlockState {

    private Point[] points;

    public TetrisBlockStateImp(Point[] points) {

        this.points = points;
    }

    @Override
    public Point[] getPositionValues() {

        return points;
    }
}
