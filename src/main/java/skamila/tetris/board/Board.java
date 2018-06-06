package skamila.tetris.board;

public class Board {

    private int height, width;

    private BoardField[][] fields;

    public Board(BoardField[][] fields) {

        this.fields = fields;

        height = fields.length;
        width = fields[0].length;
    }

    public int getHeight() {

        return height;
    }

    public int getWidth() {

        return width;
    }

    public void setField(BoardField field, int x, int y) {

        if (isPositionInBoard(x, y)) {
            throw new OutOfBoardException(
                "Max height=" + height + "field position Y=" + y + "\n" + "Max width=" + width + "field position X=" + x + "."
            );
        }

        fields[y][x] = field;
    }

    public BoardField getField(int x, int y) {

        return fields[y][x];
    }

    public BoardField[][] getFields() {

        return fields;
    }

    public boolean isPositionInBoard(int x, int y) {

        return (y > height - 1) || (y < 0) || (x > width - 1) || (x < 0);
    }
}
