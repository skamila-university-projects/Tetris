package skamila.tetris.board;

import org.junit.jupiter.api.Test;
import skamila.tetris.board.Board;
import skamila.tetris.board.BoardField;
import skamila.tetris.board.OutOfBoardException;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    public void boardWithOneField() {

        BoardField[][] fields = { { new BoardField() } };

        Board board = new Board(fields);

        assertEquals(1, board.getHeight());
        assertEquals(1, board.getWidth());
    }

    @Test
    public void boardWithOneRow() {

        BoardField[][] fields = {
            { new BoardField(), new BoardField(), new BoardField() }
        };

        Board board = new Board(fields);

        assertEquals(1, board.getHeight());
        assertEquals(3, board.getWidth());
    }

    @Test
    public void boardWithOneColumn() {

        BoardField[][] fields = {
            { new BoardField() },
            { new BoardField() },
            { new BoardField() },
        };

        Board board = new Board(fields);

        assertEquals(3, board.getHeight());
        assertEquals(1, board.getWidth());
    }

    @Test
    public void boardWithMultiRowColumns() {

        BoardField[][] fields = {
            { new BoardField(), new BoardField(), new BoardField() },
            { new BoardField(), new BoardField(), new BoardField() },
            { new BoardField(), new BoardField(), new BoardField() },
        };

        Board board = new Board(fields);

        assertEquals(3, board.getHeight());
        assertEquals(3, board.getWidth());
    }

    @Test
    public void outOfBoardException() {

        BoardField[][] fields = {
            { new BoardField(), new BoardField(), new BoardField() },
            { new BoardField(), new BoardField(), new BoardField() },
            { new BoardField(), new BoardField(), new BoardField() },
        };

        Board board = new Board(fields);

        board.setField(new BoardField(), 2, 2);
        assertThrows(
            OutOfBoardException.class,
            () -> board.setField(new BoardField(), 3, 2)
        );
        assertThrows(
            OutOfBoardException.class,
            () -> board.setField(new BoardField(), 2, 3)
        );
        assertThrows(
            OutOfBoardException.class,
            () -> board.setField(new BoardField(), -1, 2)
        );
        assertThrows(
            OutOfBoardException.class,
            () -> board.setField(new BoardField(), 2, -1)
        );
    }

    @Test
    public void getField() {

        BoardField testField = new BoardField();

        BoardField[][] fields = {
            { new BoardField(), new BoardField(), new BoardField() },
            { new BoardField(), testField, new BoardField() },
            { new BoardField(), new BoardField(), new BoardField() },
        };

        Board board = new Board(fields);
        BoardField field = board.getField(1, 1);
        assertEquals(testField, field);
    }
}
