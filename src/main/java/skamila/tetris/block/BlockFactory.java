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
}
