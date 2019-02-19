package skamila.tetris;

import org.junit.jupiter.api.Test;
import skamila.tetris.api.board.*;
import skamila.tetris.api.leaderboard.Leaderboard;
import skamila.tetris.pc.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class TetrisTest {

    private BoardField e() {

        return new BoardField();
    }

    private BoardField f() {

        return new BoardField(true);
    }

    @Test
    void cleanBoardTwoRows() {

        BoardField inputFields[][] = {
            { e(), e(), e(), f(), e() },
            { e(), f(), e(), e(), e() },
            { f(), f(), f(), f(), f() },
            { f(), e(), f(), f(), f() },
            { f(), f(), f(), f(), f() }
        };

        Board board = new Board(inputFields);
        Tetris tetris = new Tetris(board, mock(Leaderboard.class), mock(TetrisGameLoop.class));
        tetris.cleanBoard();
        BoardField[][] actualFields = board.getFields();

        BoardField expectedFields[][] = {
            { e(), e(), e(), e(), e() },
            { e(), e(), e(), e(), e() },
            { e(), e(), e(), f(), e() },
            { e(), f(), e(), e(), e() },
            { f(), e(), f(), f(), f() }
        };

        for (int i = 0; i < actualFields.length; i++) {
            for (int j = 0; j < actualFields[i].length; j++) {
                assertEquals(actualFields[i][j].isOccupied(), expectedFields[i][j].isOccupied());
            }
        }
    }

    @Test
    void cleanBoardNoRowsToClean() {

        BoardField inputFields[][] = {
            { e(), e(), e(), f(), e() },
            { e(), f(), e(), e(), e() },
            { f(), f(), e(), f(), f() },
            { f(), e(), f(), f(), f() },
            { f(), f(), e(), f(), f() }
        };

        Board board = new Board(inputFields);
        Tetris tetris = new Tetris(board, mock(Leaderboard.class), mock(TetrisGameLoop.class));
        tetris.cleanBoard();
        BoardField[][] actualFields = board.getFields();

        BoardField expectedFields[][] = {
            { e(), e(), e(), f(), e() },
            { e(), f(), e(), e(), e() },
            { f(), f(), e(), f(), f() },
            { f(), e(), f(), f(), f() },
            { f(), f(), e(), f(), f() }
        };

        for (int i = 0; i < actualFields.length; i++) {
            for (int j = 0; j < actualFields[i].length; j++) {
                assertEquals(actualFields[i][j].isOccupied(), expectedFields[i][j].isOccupied());
            }
        }
    }

    @Test
    void cleanBoardAllRowsToClean() {

        BoardField inputFields[][] = {
            { f(), f(), f(), f(), f() },
            { f(), f(), f(), f(), f() },
            { f(), f(), f(), f(), f() },
            { f(), f(), f(), f(), f() },
            { f(), f(), f(), f(), f() }
        };

        Board board = new Board(inputFields);
        Tetris tetris = new Tetris(board, mock(Leaderboard.class), mock(TetrisGameLoop.class));
        tetris.cleanBoard();
        BoardField[][] actualFields = board.getFields();

        BoardField expectedFields[][] = {
            { e(), e(), e(), e(), e() },
            { e(), e(), e(), e(), e() },
            { e(), e(), e(), e(), e() },
            { e(), e(), e(), e(), e() },
            { e(), e(), e(), e(), e() }
        };

        for (int i = 0; i < actualFields.length; i++) {
            for (int j = 0; j < actualFields[i].length; j++) {
                assertEquals(actualFields[i][j].isOccupied(), expectedFields[i][j].isOccupied());
            }
        }
    }
}
