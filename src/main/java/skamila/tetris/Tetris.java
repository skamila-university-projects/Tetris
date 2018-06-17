package skamila.tetris;

import javafx.scene.canvas.Canvas;
import javafx.scene.text.Text;
import skamila.tetris.block.*;
import skamila.tetris.board.Board;
import skamila.tetris.board.BoardFactory;
import skamila.tetris.board.BoardField;
import skamila.tetris.leaderboard.Leaderboard;
import skamila.tetris.render.Renderer;
import skamila.tetris.render.RoundCornerBoardRenderer;
import skamila.tetris.render.RoundCornerNextBlockRenderer;

import java.util.Random;

public class Tetris implements Runnable {

    private Board board;

    private Block currentBlock, nextBlock;

    BlockFactoryLambda[] blocks;

    private Canvas canvasGame;

    private static Tetris tetris;

    private int updatesPerFrame;

    private Canvas nextBlockCanvas;

    boolean isPaused = false;

    boolean isRunning = false;

    int level = 1;

    int points;

    private Leaderboard leadderbpard;

    TetrisGameLoop gameLoop;

    private Thread thread;

    private boolean isBlockOnBoard;

    private long currentTime;

    private int blockCounter;

    private Text pointsText;

    private Text levelText;

    public Tetris(Board board, Leaderboard leadderbpard, TetrisGameLoop gameLoop) {

        this.board = board;
        this.leadderbpard = leadderbpard;
        this.gameLoop = gameLoop;
        blocks = new BlockFactoryLambda[7];
        blocks[0] = () -> BlockFactory.I(board);
        blocks[1] = () -> BlockFactory.J(board);
        blocks[2] = () -> BlockFactory.L(board);
        blocks[3] = () -> BlockFactory.O(board);
        blocks[4] = () -> BlockFactory.S(board);
        blocks[5] = () -> BlockFactory.T(board);
        blocks[6] = () -> BlockFactory.Z(board);
        nextBlock = getRandomBlock();
    }

    public void run() {

        gameLoop.run(this, canvasGame, nextBlockCanvas);
    }

    private Block getRandomBlock() {

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

    public void addPoints() {

        for (int i = 0; i < board.getHeight(); i++) {
            if (isRowFull(i))
                points += 10 * level;
        }

        pointsText.setText(points + "");
    }

    public static Tetris create() {

        if (tetris == null) {

            Renderer[] renderers = {
                new RoundCornerBoardRenderer(),
                new RoundCornerNextBlockRenderer()
            };

            Board board = BoardFactory.create();
            tetris = new Tetris(
                board,
                new Leaderboard("leaderboard.txt"),
                new TetrisGameLoop(renderers)
            );
        }

        return tetris;
    }

    public void setGameCanvas(Canvas canvasGame) {

        this.canvasGame = canvasGame;
    }

    public void setNextBlockCanvas(Canvas nextBlockCanvas) {

        this.nextBlockCanvas = nextBlockCanvas;
    }

    public Block getNextBlock() {

        return nextBlock;
    }

    public void setRandomBlock() {

        currentBlock = nextBlock;
        nextBlock = getRandomBlock();
        currentBlock.countInitialShift(board);
        isBlockOnBoard = true;
    }

    public TetrisGameLoop getGameLoop() {

        return gameLoop;
    }

    public void setThread(Thread thread) {

        this.thread = thread;
    }

    public Thread getThread() {

        return thread;
    }

    public void singleCycle() {

        long cycleStartTime = System.nanoTime() / 10000000;
        //System.out.println((cycleStartTime - currentTime) / 100.0 + " >= " + (1 - (level / 10.0)));
        if ((cycleStartTime - currentTime) / 100.0 >= (1 - (level / 10.0))) {
            currentBlock.moveDown(board);
            currentTime = System.nanoTime() / 10000000;
            if (currentBlock.isMergable(board)) {
                board.mergeBlock(currentBlock);
                addPoints();
                cleanBoard();
                isBlockOnBoard = false;
                blockCounter++;
                if (blockCounter >= 10) {
                    level++;
                    levelText.setText(level + "");
                    blockCounter = 0;
                }
            }
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

    public boolean isBockOnBoard() {

        return isBlockOnBoard;
    }

    public void saveCurrentTime() {

        currentTime = System.nanoTime() / 10000000;
    }

    public Board getBoard() {

        return board;
    }

    public Block getCurrentBlock() {

        return currentBlock;
    }

    public String getPoints() {

        return points + "";
    }

    public String getLevel() {

        return level + "";
    }

    public void setPointTextHolder(Text pointsText) {

        this.pointsText = pointsText;
    }

    public void setLevelTextHolder(Text levelText) {

        this.levelText = levelText;
        levelText.setText(level + "");
    }

    public void setLevel(int difficultyLvl) {

        level = difficultyLvl;
    }
}
