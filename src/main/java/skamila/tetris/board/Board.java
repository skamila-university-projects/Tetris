package skamila.tetris.board;

public class Board {

    private int height;

    private int width;

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
                "Max height=" + height + "field position X=" + field
                    .getX() + "\n" + "Max width=" + width + "field position Y=" + field.getY() + "."
            );
        }

        fields[field.getX()][field.getY()] = field;
    }

    public BoardField getField(int x, int y) {

        return fields[x][y];
    }

    public boolean isFieldInBoard(BoardField field) {

        return (field.getX() > height - 1) || (field.getX() < 0) || (field
            .getY() > width - 1) || (field.getY() < 0);
    }
}
