package skamila.tetris;

public class TetrisBoardFieldImp implements TetrisBoardField {

    private boolean isFull;

    private int color;

    public TetrisBoardFieldImp() {

        color = 0;
        isFull = false;
    }

    public TetrisBoardFieldImp(int color) {

        this.color = 0;
        isFull = true;
    }

    @Override
    public int getX() {

        return 0;
    }

    @Override
    public int getY() {

        return 0;
    }

    public boolean isOccupied() {

        return isFull;
    }
}
