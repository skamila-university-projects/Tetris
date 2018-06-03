package skamila.tetris.board;

public class BoardField {

    private boolean isFull;

    private int color;

    public BoardField() {

        color = 0;
        isFull = false;
    }

    public BoardField(boolean isFull) {

        this.color = 0;
        this.isFull = isFull;
    }

    public BoardField(boolean isFull, int color) {

        this.color = color;
        this.isFull = isFull;
    }

    public int getX() {

        return 0;
    }

    public int getY() {

        return 0;
    }

    public boolean isOccupied() {

        return isFull;
    }
}
