package skamila.tetris;

import org.junit.Ignore;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import skamila.tetris.board.Board;
import skamila.tetris.states.I1;
import skamila.tetris.states.I2;
import skamila.tetris.states.Point;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class TetrisBlockTest {

    @Test
    void rotate() {

        TetrisBlockState state1 = mock(TetrisBlockState.class);
        TetrisBlockState state2 = mock(TetrisBlockState.class);
        TetrisBlockState state3 = mock(TetrisBlockState.class);
        TetrisBlockState state4 = mock(TetrisBlockState.class);

        TetrisBlockState[] states = new TetrisBlockState[4];

        states[0] = state1;
        states[1] = state2;
        states[2] = state3;
        states[3] = state4;

        TetrisBlock block = new TetrisBlockImp(states);

        assertEquals(state1, block.getActiveState());

        block.rotate();
        assertEquals(state2, block.getActiveState());

        block.rotate();
        assertEquals(state3, block.getActiveState());

        block.rotate();
        assertEquals(state4, block.getActiveState());

        block.rotate();
        assertEquals(state1, block.getActiveState());
    }

    @Test
    void moveDown() {

        Board board = TetrisBoardFactory.create();
        TetrisBlock O = TetrisBlockFactory.O(board);

        Point[] points = O.getShiftedActiveState().getPositionValues();

        for (int i = 1; i <= board.getHeight(); i++) {
            O.moveDown(board);
            points = O.getShiftedActiveState().getPositionValues();

            assertEquals(-2 + i, points[0].getY());
            assertEquals(-1 + i, points[1].getY());
            assertEquals(-2 + i, points[2].getY());
            assertEquals(-1 + i, points[3].getY());
        }

        O.moveDown(board);
        O.moveDown(board);
        points = O.getShiftedActiveState().getPositionValues();

        assertEquals(18, points[0].getY());
        assertEquals(19, points[1].getY());
        assertEquals(18, points[2].getY());
        assertEquals(19, points[3].getY());
    }

    @Test
    void countInitialShiftEvenBlock() {

        TetrisBlockState[] tetrisBlockStates = new TetrisBlockState[2];

        tetrisBlockStates[0] = new I1();
        tetrisBlockStates[1] = new I2();

        Board board = TetrisBoardFactory.create();

        TetrisBlock I = new TetrisBlockImp(tetrisBlockStates);
        I.countInitialShift(board);

        Point[] points = I.getShiftedActiveState().getPositionValues();

        assertEquals(3, points[0].getX());
        assertEquals(4, points[1].getX());
        assertEquals(5, points[2].getX());
        assertEquals(6, points[3].getX());

        assertEquals(-1, points[0].getY());
        assertEquals(-1, points[1].getY());
        assertEquals(-1, points[2].getY());
        assertEquals(-1, points[3].getY());

    }

    @Test
    void countInitialShiftOddBlock() {

        TetrisBlockState[] tetrisBlockStates = new TetrisBlockState[2];

        tetrisBlockStates[0] = new I2();
        tetrisBlockStates[1] = new I1();

        Board board = TetrisBoardFactory.create();

        TetrisBlock I = new TetrisBlockImp(tetrisBlockStates);
        I.countInitialShift(board);

        Point[] points = I.getShiftedActiveState().getPositionValues();

        assertEquals(4, points[0].getX());
        assertEquals(4, points[1].getX());
        assertEquals(4, points[2].getX());
        assertEquals(4, points[3].getX());

        assertEquals(-4, points[0].getY());
        assertEquals(-3, points[1].getY());
        assertEquals(-2, points[2].getY());
        assertEquals(-1, points[3].getY());

    }

}
