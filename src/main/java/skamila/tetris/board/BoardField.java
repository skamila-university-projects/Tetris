package skamila.tetris.board;

public class BoardField {

    private boolean isFull;

    private String color;

    public BoardField() {

        color = "#303447";
        isFull = false;
    }

    public BoardField(boolean isFull) {

        this.color = "#303447";
        this.isFull = isFull;
    }

    public BoardField(String color) {

        this.color = color;
        this.isFull = true;
    }

    public BoardField(boolean isFull, String color) {

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

    public String getColor() {

        return color;
    }
}
