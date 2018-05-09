package skamila.tetris.board;

public class Row {

    private Field fields[];

    public Row() {
        fields = new Field[10];
    }

    boolean isFull() {
        return false;
    }

}
