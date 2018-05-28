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

    public void setField(BoardField field) {

        if (isFieldInBoard(field)) {
            throw new OutOfBoardException(
                "Max height=" + height + "field position Y=" + field
                    .getY() + "\n" + "Max width=" + width + "field position X=" + field.getX() + "."
            );
        }

        fields[field.getY()][field.getX()] = field;
    }

    public BoardField getField(int x, int y) {

        return fields[y][x];
    }

    public boolean isFieldInBoard(BoardField field) {

        return (field.getY() > height - 1) || (field.getY() < 0) || (field
            .getX() > width - 1) || (field.getX() < 0);
    }
}
