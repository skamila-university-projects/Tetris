package skamila.tetris.block;

import skamila.tetris.board.Board;
import skamila.tetris.block.states.*;

public class BlockFactory {

    Board board;

    public static Block I(Board board) {

        BlockState[] blockStates = new BlockState[2];

        blockStates[0] = new I1();
        blockStates[1] = new I2();

        Block block = new BlockImp(blockStates);
        block.randomizeActiveState();
        block.countInitialShift(board);

        return block;
    }

    public static Block O(Board board) {

        BlockState[] blockStates = new BlockState[1];

        blockStates[0] = new O();

        Block block = new BlockImp(blockStates);
        block.randomizeActiveState();
        block.countInitialShift(board);

        return block;
    }

    public static Block J(Board board) {

        BlockState[] blockStates = new BlockState[4];

        blockStates[0] = new J1();
        blockStates[1] = new J2();
        blockStates[2] = new J3();
        blockStates[3] = new J4();

        Block block = new BlockImp(blockStates);
        block.randomizeActiveState();
        block.countInitialShift(board);

        return block;
    }

    public static Block L(Board board) {

        BlockState[] blockStates = new BlockState[4];

        blockStates[0] = new L1();
        blockStates[1] = new L2();
        blockStates[2] = new L3();
        blockStates[3] = new L4();

        Block block = new BlockImp(blockStates);
        block.randomizeActiveState();
        block.countInitialShift(board);

        return block;
    }

    public static Block S(Board board) {

        BlockState[] blockStates = new BlockState[2];

        blockStates[0] = new S1();
        blockStates[1] = new S2();

        Block block = new BlockImp(blockStates);
        block.randomizeActiveState();
        block.countInitialShift(board);

        return block;
    }

    public static Block T(Board board) {

        BlockState[] blockStates = new BlockState[4];

        blockStates[0] = new T1();
        blockStates[1] = new T2();
        blockStates[2] = new T3();
        blockStates[3] = new T4();

        Block block = new BlockImp(blockStates);
        block.randomizeActiveState();
        block.countInitialShift(board);

        return block;
    }

    public static Block Z(Board board) {

        BlockState[] blockStates = new BlockState[2];

        blockStates[0] = new Z1();
        blockStates[1] = new Z2();

        Block block = new BlockImp(blockStates);
        block.randomizeActiveState();
        block.countInitialShift(board);

        return block;
    }
}
