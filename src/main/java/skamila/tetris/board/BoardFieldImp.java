package skamila.tetris.board;

public class BoardFieldImp implements BoardField {
    private int x;
    private int y;
    private boolean isOccupied = false;

    public BoardFieldImp(int x, int y, boolean isOccupied) {
        this.x = x;
        this.y = y;
        this.isOccupied = isOccupied;
    }

    public BoardFieldImp(int x, int y) {
        this.x = x;
        this.y = y;
        this.isOccupied = false;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public boolean isOccupied() {
        return isOccupied;
    }
}
