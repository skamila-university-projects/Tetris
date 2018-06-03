package skamila.tetris.block;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import skamila.tetris.board.BoardFactory;
import skamila.tetris.board.BoardField;
import skamila.tetris.board.Board;
import skamila.tetris.block.states.I1;
import skamila.tetris.block.states.I2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class BlockTest {

    @Disabled
    @Test
    void oldRotate() {

        Board board = BoardFactory.create();

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
    void rotateSimple() {

        BlockState[] blockStates = new BlockState[2];

        blockStates[0] = new I1();
        blockStates[1] = new I2();

        Board board = BoardFactory.create();

        Block I = new BlockImp(blockStates);
        I.countInitialShift(board);

        for (int i = 0; i < 8; i++) {
            I.moveDown(board);
        }

        I.rotate(board);

        StatePoint[] statePoints = I.getShiftedActiveState().getPositionValues();

        assertEquals(3, statePoints[0].getX());
        assertEquals(4, statePoints[1].getX());
        assertEquals(5, statePoints[2].getX());
        assertEquals(6, statePoints[3].getX());

        assertEquals(5, statePoints[0].getY());
        assertEquals(5, statePoints[1].getY());
        assertEquals(5, statePoints[2].getY());
        assertEquals(5, statePoints[3].getY());
    }

    @Test
    void rotateNearWall() {

        BlockState[] blockStates = new BlockState[2];

        blockStates[0] = new I1();
        blockStates[1] = new I2();

        Board board = createBoardForTests();

        Block I = new BlockImp(blockStates);
        I.countInitialShift(board);

        for (int i = 0; i < 4; i++) {
            I.moveDown(board);
        }

        for (int i = 0; i < 4; i++) {
            I.moveLeft(board);
        }

        for (int i = 0; i < 4; i++) {
            I.moveDown(board);
        }

        I.rotate(board);

        StatePoint[] statePoints = I.getShiftedActiveState().getPositionValues();

        assertEquals(0, statePoints[0].getX());
        assertEquals(0, statePoints[1].getX());
        assertEquals(0, statePoints[2].getX());
        assertEquals(0, statePoints[3].getX());

        assertEquals(4, statePoints[0].getY());
        assertEquals(5, statePoints[1].getY());
        assertEquals(6, statePoints[2].getY());
        assertEquals(7, statePoints[3].getY());
    }

    @Test
    void moveDown() {

        Board board = BoardFactory.create();
        Block O = BlockFactory.O(board);
        StatePoint[] statePoints;

        for (int i = 1; i <= board.getHeight(); i++) {
            O.moveDown(board);
            statePoints = O.getShiftedActiveState().getPositionValues();

            assertEquals(-2 + i, statePoints[0].getY());
            assertEquals(-1 + i, statePoints[1].getY());
            assertEquals(-2 + i, statePoints[2].getY());
            assertEquals(-1 + i, statePoints[3].getY());
        }

        O.moveDown(board);
        O.moveDown(board);
        statePoints = O.getShiftedActiveState().getPositionValues();

        assertEquals(18, statePoints[0].getY());
        assertEquals(19, statePoints[1].getY());
        assertEquals(18, statePoints[2].getY());
        assertEquals(19, statePoints[3].getY());
    }

    @Test
    void countInitialShiftEvenBlock() {

        BlockState[] blockStates = new BlockState[2];

        blockStates[0] = new I2();

        Board board = BoardFactory.create();

        Block I = new BlockImp(blockStates);
        I.countInitialShift(board);

        StatePoint[] statePoints = I.getShiftedActiveState().getPositionValues();

        assertEquals(3, statePoints[0].getX());
        assertEquals(4, statePoints[1].getX());
        assertEquals(5, statePoints[2].getX());
        assertEquals(6, statePoints[3].getX());

        assertEquals(-1, statePoints[0].getY());
        assertEquals(-1, statePoints[1].getY());
        assertEquals(-1, statePoints[2].getY());
        assertEquals(-1, statePoints[3].getY());

    }

    @Test
    void countInitialShiftOddBlock() {

        BlockState[] blockStates = new BlockState[2];

        blockStates[0] = new I1();

        Board board = BoardFactory.create();

        Block I = new BlockImp(blockStates);
        I.countInitialShift(board);

        StatePoint[] statePoints = I.getShiftedActiveState().getPositionValues();

        assertEquals(4, statePoints[0].getX());
        assertEquals(4, statePoints[1].getX());
        assertEquals(4, statePoints[2].getX());
        assertEquals(4, statePoints[3].getX());

        assertEquals(-4, statePoints[0].getY());
        assertEquals(-3, statePoints[1].getY());
        assertEquals(-2, statePoints[2].getY());
        assertEquals(-1, statePoints[3].getY());

    }

    @Test
    void moveLeft() {

        Board board = BoardFactory.create();
        Block O = BlockFactory.O(board);
        StatePoint[] statePoints;

        O.moveLeft(board);
        statePoints = O.getShiftedActiveState().getPositionValues();

        assertEquals(4, statePoints[0].getX());
        assertEquals(4, statePoints[1].getX());
        assertEquals(5, statePoints[2].getX());
        assertEquals(5, statePoints[3].getX());

        O.moveDown(board);
        O.moveLeft(board);
        statePoints = O.getShiftedActiveState().getPositionValues();

        assertEquals(3, statePoints[0].getX());
        assertEquals(3, statePoints[1].getX());
        assertEquals(4, statePoints[2].getX());
        assertEquals(4, statePoints[3].getX());

        O.moveDown(board);

        for (int i = 1; i < board.getWidth() / 2 - 1; i++) {
            O.moveLeft(board);
            statePoints = O.getShiftedActiveState().getPositionValues();

            assertEquals(3 - i, statePoints[0].getX());
            assertEquals(3 - i, statePoints[1].getX());
            assertEquals(4 - i, statePoints[2].getX());
            assertEquals(4 - i, statePoints[3].getX());
        }

        O.moveLeft(board);
        statePoints = O.getShiftedActiveState().getPositionValues();
        assertEquals(0, statePoints[0].getX());
        assertEquals(0, statePoints[1].getX());
        assertEquals(1, statePoints[2].getX());
        assertEquals(1, statePoints[3].getX());
    }

    @Test
    void moveRight() {

        Board board = BoardFactory.create();
        Block O = BlockFactory.O(board);
        StatePoint[] statePoints;

        O.moveRight(board);
        statePoints = O.getShiftedActiveState().getPositionValues();

        assertEquals(4, statePoints[0].getX());
        assertEquals(4, statePoints[1].getX());
        assertEquals(5, statePoints[2].getX());
        assertEquals(5, statePoints[3].getX());

        O.moveDown(board);
        O.moveRight(board);
        statePoints = O.getShiftedActiveState().getPositionValues();

        assertEquals(5, statePoints[0].getX());
        assertEquals(5, statePoints[1].getX());
        assertEquals(6, statePoints[2].getX());
        assertEquals(6, statePoints[3].getX());

        O.moveDown(board);

        for (int i = 1; i < board.getWidth() / 2 - 1; i++) {
            O.moveRight(board);
            statePoints = O.getShiftedActiveState().getPositionValues();

            assertEquals(5 + i, statePoints[0].getX());
            assertEquals(5 + i, statePoints[1].getX());
            assertEquals(6 + i, statePoints[2].getX());
            assertEquals(6 + i, statePoints[3].getX());
        }

        O.moveRight(board);
        statePoints = O.getShiftedActiveState().getPositionValues();
        assertEquals(8, statePoints[0].getX());
        assertEquals(8, statePoints[1].getX());
        assertEquals(9, statePoints[2].getX());
        assertEquals(9, statePoints[3].getX());
    }

    private Board createBoardForTests() {

        BoardField[][] fields = {
            { e(), e(), e(), e(), e(), e(), e(), e(), e(), e() },
            { e(), e(), e(), e(), e(), e(), e(), e(), e(), e() },
            { e(), e(), e(), e(), e(), e(), e(), e(), e(), e() },
            { e(), e(), e(), e(), e(), e(), e(), e(), e(), e() },
            { e(), f(), e(), e(), e(), e(), e(), e(), e(), e() },
            { e(), f(), e(), e(), e(), e(), e(), e(), e(), e() },
            { e(), f(), e(), e(), e(), e(), e(), e(), e(), e() },
            { e(), f(), e(), e(), e(), e(), e(), e(), e(), e() },
            { e(), e(), e(), e(), e(), e(), e(), e(), e(), e() },
            { e(), e(), e(), e(), e(), e(), e(), e(), e(), e() },
            { e(), e(), e(), e(), e(), e(), e(), e(), e(), e() },
            { e(), e(), e(), e(), e(), e(), e(), e(), e(), e() },
            { e(), e(), e(), e(), e(), e(), e(), e(), e(), e() },
            { e(), e(), e(), e(), e(), e(), e(), e(), e(), e() },
            { e(), e(), e(), e(), e(), e(), e(), e(), e(), e() },
            { e(), e(), e(), e(), e(), e(), e(), e(), e(), e() },
            { e(), e(), e(), e(), e(), e(), e(), e(), e(), e() },
            { e(), e(), e(), e(), e(), e(), e(), e(), e(), e() },
            { e(), e(), e(), e(), e(), e(), e(), e(), e(), e() },
            { e(), e(), e(), e(), e(), e(), e(), e(), e(), e() },

        };

        Board board = new Board(fields);

        return board;
    }

    private BoardField f() {

        return new BoardField(true);
    }

    private BoardField e() {

        return new BoardField(false);
    }

}
