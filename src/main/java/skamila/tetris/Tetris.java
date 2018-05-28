package skamila.tetris;

import skamila.tetris.board.Board;

import java.util.Random;

public class Tetris {

    private Board board;

    private TetrisBlock currentBlock, nextBlock;

    TetrisBlockFactoryLambda[] blocks;

    public Tetris(Board board) {

        this.board = board;
        blocks = new TetrisBlockFactoryLambda[2];
        blocks[0] = () -> TetrisBlockFactory.O(board);
        blocks[1] = () -> TetrisBlockFactory.I(board);
        nextBlock = getRandomBlock();
    }

    public void singleCycle() {

        currentBlock = nextBlock;
        nextBlock = getRandomBlock();
    }

    private TetrisBlock getRandomBlock() {

        Random generator = new Random();
        int randomNumber = generator.nextInt(blocks.length);

        return blocks[randomNumber].getBlock();
    }

    public void cleanBoard() {

        for (int i = 0; i < board.getHeight(); i++) {
            if (isRowFull(i))
                deleteRow(i);
        }
    }

    private boolean isRowFull(int rowIndex) {

        for (int i = 0; i < board.getWidth(); i++) {
            // if(!board[rowIndex][i].isFull()) return false;
        }
        return true;
    }

    private void deleteRow(int rowIndex) {

        for (int i = rowIndex; i > 0; i--) {
            for (int j = 0; j < board.getWidth(); j++) {
                // board[i][j] = board[i - 1][j];
            }
        }

        for (int j = 0; j < board.getWidth(); j++) {
            // board[0][j] = new BoardField();
        }

    }

}
