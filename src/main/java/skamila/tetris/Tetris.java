package skamila.tetris;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import skamila.tetris.block.*;
import skamila.tetris.board.Board;
import skamila.tetris.board.BoardFactory;
import skamila.tetris.board.BoardField;
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

    TetrisGameLoop gameLoop;

    public Tetris(Board board, TetrisGameLoop gameLoop) {

        this.board = board;
        this.gameLoop = gameLoop;
        blocks = new BlockFactoryLambda[2];
        blocks[0] = () -> BlockFactory.O(board);
        blocks[1] = () -> BlockFactory.I(board);
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

    public static Tetris create() {

        if (tetris == null) {

            Renderer[] renderers = {
                new RoundCornerBoardRenderer(),
                new RoundCornerNextBlockRenderer()
            };

            Board board = BoardFactory.create();
            tetris = new Tetris(board, new TetrisGameLoop(renderers));
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
    }

    public TetrisGameLoop getGameLoop() {

        return gameLoop;
    }
}
