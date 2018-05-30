package skamila.tetris.board;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    public void boardWithOneField() {

        BoardField[][] fields = { { new BoardFieldImp(0, 0) } };

        Board board = new Board(fields);

        assertEquals(1, board.getHeight());
        assertEquals(1, board.getWidth());
    }

    @Test
    public void boardWithOneRow() {

        BoardField[][] fields = {
            { new BoardFieldImp(0, 0), new BoardFieldImp(0, 1), new BoardFieldImp(0, 2) }
        };

        Board board = new Board(fields);

        assertEquals(1, board.getHeight());
        assertEquals(3, board.getWidth());
    }

    @Test
    public void boardWithOneColumn() {

        BoardField[][] fields = {
            { new BoardFieldImp(0, 0) },
            { new BoardFieldImp(1, 0) },
            { new BoardFieldImp(2, 0) }
        };

        Board board = new Board(fields);

        assertEquals(3, board.getHeight());
        assertEquals(1, board.getWidth());
    }

    @Test
    public void boardWithMultiRowColumns() {

        BoardField[][] fields = {
            { new BoardFieldImp(0, 0), new BoardFieldImp(0, 1), new BoardFieldImp(0, 2) },
            { new BoardFieldImp(1, 0), new BoardFieldImp(1, 1), new BoardFieldImp(1, 2) },
            { new BoardFieldImp(2, 0), new BoardFieldImp(2, 1), new BoardFieldImp(2, 2) }
        };

        Board board = new Board(fields);

        assertEquals(3, board.getHeight());
        assertEquals(3, board.getWidth());
    }

    @Test
    public void outOfBoardException() {

        BoardField[][] fields = {
            { new BoardFieldImp(0, 0), new BoardFieldImp(0, 1), new BoardFieldImp(0, 2) },
            { new BoardFieldImp(1, 0), new BoardFieldImp(1, 1), new BoardFieldImp(1, 2) },
            { new BoardFieldImp(2, 0), new BoardFieldImp(2, 1), new BoardFieldImp(2, 2) }
        };

        Board board = new Board(fields);

        board.setField(new BoardFieldImp(2, 2));
        assertThrows(OutOfBoardException.class, () -> board.setField(new BoardFieldImp(3, 2)));
        assertThrows(OutOfBoardException.class, () -> board.setField(new BoardFieldImp(2, 3)));
        assertThrows(OutOfBoardException.class, () -> board.setField(new BoardFieldImp(-1, 2)));
        assertThrows(OutOfBoardException.class, () -> board.setField(new BoardFieldImp(2, -1)));
    }

    @Test
    public void getField() {

        BoardField[][] fields = {
            { new BoardFieldImp(0, 0), new BoardFieldImp(0, 1), new BoardFieldImp(0, 2) },
            { new BoardFieldImp(1, 0), new BoardFieldImp(1, 1), new BoardFieldImp(1, 2) },
            { new BoardFieldImp(2, 0), new BoardFieldImp(2, 1), new BoardFieldImp(2, 2) }
        };

        Board board = new Board(fields);
        BoardField field = board.getField(1, 1);
        assertEquals(1, field.getX());
        assertEquals(1, field.getY());
    }
}
