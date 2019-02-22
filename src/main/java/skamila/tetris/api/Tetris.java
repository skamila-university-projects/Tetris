package skamila.tetris.api;

import skamila.tetris.api.block.*;
import skamila.tetris.api.board.*;
import skamila.tetris.api.leaderboard.Leaderboard;

import java.util.Random;

public class Tetris {

    private Board board;
    private Block currentBlock, nextBlock;
    private BlockFactoryLambda[] blocks;
    private boolean isBlockOnBoard, isPaused, isGameOver;
    private static int beginLevel = 1;
    private int level, points, blockCounter;
    private Thread thread;
    private long currentTime;
    private Leaderboard leaderboard;


    public Tetris(Board board, Leaderboard leaderboard) {

        this.board = board;
        this.leaderboard = leaderboard;
        this.blocks = prepareBlocks();
        this.nextBlock = getRandomBlock();
        this.isPaused = true;
        this.isGameOver = false;
    }

    public void cleanBoard() {

        for (int i = 0; i < board.getHeight(); i++) {
            if (isRowFull(i))
                deleteRow(i);
        }
    }

    public static Tetris create(Leaderboard leaderboard) {

        return new Tetris(BoardFactory.create(), leaderboard);

    }

    public Block getNextBlock() {

        return nextBlock;
    }

    public void setThread(Thread thread) {

        this.thread = thread;
    }

    public Thread getThread() {

        return thread;
    }

    public Board getBoard() {

        return board;
    }

    public Block getCurrentBlock() {

        return currentBlock;
    }

    public int getPoints() {
        return points;
    }

    public int getBeginLevel() {
        return beginLevel;
    }

    public boolean isGameOver(){
        return isGameOver;
    }

    public boolean isPaused(){
        return isPaused;
    }

    public void applyCurrentLevel() {
        level = beginLevel;
    }

    public void setLevel(int difficultyLvl) {
        beginLevel = difficultyLvl;
    }

    public void pause() {

        isPaused = true;
    }

    public void unpause() {

        isPaused = false;
    }

    public Leaderboard getLeaderboard() {
        return leaderboard;
    }

    public int getLevel() {
        return level;
    }

    public void setRandomBlock() {

        currentBlock = nextBlock;
        nextBlock = getRandomBlock();
        currentBlock.countInitialShift(board);
        isBlockOnBoard = true;
    }

    public void singleCycle() {

        long cycleStartTime = System.nanoTime() / 10000000;
        if ((cycleStartTime - currentTime) / 100.0 >= (1.02 - (level / 10.0))) {

            if (currentBlock.isMergeable(board)) {
                board.mergeBlock(currentBlock);
                addPoints();
                cleanBoard();

                isGameOver = isEndGame();

                isBlockOnBoard = false;
                blockCounter++;

                if (level < 9 && blockCounter >= 10) {
                    level++;
                    blockCounter = 0;
                }

            }

            currentBlock.moveDown(board);
            currentTime = System.nanoTime() / 10000000;
        }
    }

    public boolean isBlockOnBoard() {

        return isBlockOnBoard;
    }

    public void saveCurrentTime() {

        currentTime = System.nanoTime() / 10000000;
    }

    private boolean isEndGame() {

        BlockState state = currentBlock.getShiftedActiveState();
        StatePoint[] positions = state.getPositionValues();

        for (StatePoint p : positions) {
            if (p.getY() < 0)
                return true;
        }

        return false;
    }

    private void addPoints() {

        for (int i = 0; i < board.getHeight(); i++) {
            if (isRowFull(i))
                points += 10 * level;
        }

    }

    private boolean isRowFull(int rowIndex) {

        for (int i = 0; i < board.getWidth(); i++) {
            if (!board.getField(i, rowIndex).isOccupied())
                return false;
        }
        return true;
    }

    private void deleteRow(int rowIndex) {

        for (int i = rowIndex; i > 0; i--) {
            for (int j = 0; j < board.getWidth(); j++) {
                board.setField(board.getField(j, i - 1), j, i);
            }
        }

        for (int j = 0; j < board.getWidth(); j++) {
            board.setField(new BoardField(), j, 0);
        }

    }

    private Block getRandomBlock() {

        Random generator = new Random();
        int randomNumber = generator.nextInt(blocks.length);

        return blocks[randomNumber].getBlock();
    }

    private BlockFactoryLambda[]  prepareBlocks() {
        blocks = new BlockFactoryLambda[7];
        blocks[0] = () -> BlockFactory.I(board);
        blocks[1] = () -> BlockFactory.J(board);
        blocks[2] = () -> BlockFactory.L(board);
        blocks[3] = () -> BlockFactory.O(board);
        blocks[4] = () -> BlockFactory.S(board);
        blocks[5] = () -> BlockFactory.T(board);
        blocks[6] = () -> BlockFactory.Z(board);
        return blocks;
    }
}
