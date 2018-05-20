package skamila.tetris;

import skamila.tetris.block.Block;
import skamila.tetris.block.Blockable;
import skamila.tetris.block.StandardBlockFactory;
import skamila.tetris.board.Board;

import java.util.Random;

public class Tetris {

    private Board board;
    private Block currentBlock, nextBlock;
    Blockable[] blocks;

    public Tetris(Board board) {
        this.board = board;
        blocks = new Blockable[2];
        blocks[0] = () -> StandardBlockFactory.O();
        blocks[1] = () -> StandardBlockFactory.L();
        nextBlock = getRandomBlock();
    }

    public void singleCycle(){
        currentBlock = nextBlock;
        nextBlock = getRandomBlock();
    }

    private Block getRandomBlock(){
        Random generator = new Random();
        int randomNumber = generator.nextInt(blocks.length);

        return blocks[randomNumber].getBlock();
    }



}
