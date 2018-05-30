package skamila.tetris.block;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import skamila.tetris.TetrisBoardFactory;
import skamila.tetris.board.Board;
import skamila.tetris.block.states.I1;
import skamila.tetris.block.states.I2;
import skamila.tetris.block.states.Point;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class BlockTest {

    @Disabled
    @Test
    void oldRotate() {

        Board board = TetrisBoardFactory.create();

        BlockState state1 = mock(BlockState.class);
        BlockState state2 = mock(BlockState.class);
        BlockState state3 = mock(BlockState.class);
        BlockState state4 = mock(BlockState.class);

        BlockState[] states = new BlockState[4];

        states[0] = state1;
        states[1] = state2;
        states[2] = state3;
        states[3] = state4;

        Block block = new BlockImp(states);

        assertEquals(state1, block.getActiveState());

        block.rotate(board);
        assertEquals(state2, block.getActiveState());

        block.rotate(board);
        assertEquals(state3, block.getActiveState());

        block.rotate(board);
        assertEquals(state4, block.getActiveState());

        block.rotate(board);
        assertEquals(state1, block.getActiveState());
    }

    @Test
    void rotate() {

        BlockState[] blockStates = new BlockState[2];

        blockStates[0] = new I1();
        blockStates[1] = new I2();

        Board board = TetrisBoardFactory.create();

        Block I = new BlockImp(blockStates);
        I.countInitialShift(board);

        for (int i = 0; i < 8; i++) {
            I.moveDown(board);
        }

        I.rotate(board);

        Point[] points = I.getShiftedActiveState().getPositionValues();

        assertEquals(3, points[0].getX());
        assertEquals(4, points[1].getX());
        assertEquals(5, points[2].getX());
        assertEquals(6, points[3].getX());

        assertEquals(5, points[0].getY());
        assertEquals(5, points[1].getY());
        assertEquals(5, points[2].getY());
        assertEquals(5, points[3].getY());
    }

    @Test
    void moveDown() {

        Board board = TetrisBoardFactory.create();
        Block O = BlockFactory.O(board);
        Point[] points;

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

        BlockState[] blockStates = new BlockState[2];

        blockStates[0] = new I2();

        Board board = TetrisBoardFactory.create();

        Block I = new BlockImp(blockStates);
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

        BlockState[] blockStates = new BlockState[2];

        blockStates[0] = new I1();

        Board board = TetrisBoardFactory.create();

        Block I = new BlockImp(blockStates);
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

    @Test
    void moveLeft() {

        Board board = TetrisBoardFactory.create();
        Block O = BlockFactory.O(board);
        Point[] points;

        O.moveLeft(board);
        points = O.getShiftedActiveState().getPositionValues();

        assertEquals(4, points[0].getX());
        assertEquals(4, points[1].getX());
        assertEquals(5, points[2].getX());
        assertEquals(5, points[3].getX());

        O.moveDown(board);
        O.moveLeft(board);
        points = O.getShiftedActiveState().getPositionValues();

        assertEquals(3, points[0].getX());
        assertEquals(3, points[1].getX());
        assertEquals(4, points[2].getX());
        assertEquals(4, points[3].getX());

        O.moveDown(board);

        for (int i = 1; i < board.getWidth() / 2 - 1; i++) {
            O.moveLeft(board);
            points = O.getShiftedActiveState().getPositionValues();

            assertEquals(3 - i, points[0].getX());
            assertEquals(3 - i, points[1].getX());
            assertEquals(4 - i, points[2].getX());
            assertEquals(4 - i, points[3].getX());
        }

        O.moveLeft(board);
        points = O.getShiftedActiveState().getPositionValues();
        assertEquals(0, points[0].getX());
        assertEquals(0, points[1].getX());
        assertEquals(1, points[2].getX());
        assertEquals(1, points[3].getX());
    }

    @Test
    void moveRight() {

        Board board = TetrisBoardFactory.create();
        Block O = BlockFactory.O(board);
        Point[] points;

        O.moveRight(board);
        points = O.getShiftedActiveState().getPositionValues();

        assertEquals(4, points[0].getX());
        assertEquals(4, points[1].getX());
        assertEquals(5, points[2].getX());
        assertEquals(5, points[3].getX());

        O.moveDown(board);
        O.moveRight(board);
        points = O.getShiftedActiveState().getPositionValues();

        assertEquals(5, points[0].getX());
        assertEquals(5, points[1].getX());
        assertEquals(6, points[2].getX());
        assertEquals(6, points[3].getX());

        O.moveDown(board);

        for (int i = 1; i < board.getWidth() / 2 - 1; i++) {
            O.moveRight(board);
            points = O.getShiftedActiveState().getPositionValues();

            assertEquals(5 + i, points[0].getX());
            assertEquals(5 + i, points[1].getX());
            assertEquals(6 + i, points[2].getX());
            assertEquals(6 + i, points[3].getX());
        }

        O.moveRight(board);
        points = O.getShiftedActiveState().getPositionValues();
        assertEquals(8, points[0].getX());
        assertEquals(8, points[1].getX());
        assertEquals(9, points[2].getX());
        assertEquals(9, points[3].getX());
    }

}
