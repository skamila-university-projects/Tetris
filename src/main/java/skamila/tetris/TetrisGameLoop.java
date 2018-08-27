package skamila.tetris;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import skamila.tetris.render.Renderer;

public class TetrisGameLoop extends AnimationTimer {

    private Canvas canvasGame;

    private Canvas nextBlockCanvas;

    private Renderer[] renderers;

    private boolean isPaused;

    private Tetris tetris;

    private boolean animation;

    private long endOfFrameTime;

    private long accumulatedTime;

    public TetrisGameLoop(Renderer[] renderers) {

        this.renderers = renderers;
        this.animation = true;
        this.isPaused = true;
    }

    @Override
    public void handle(long startOfFrameTime) {

        if (endOfFrameTime == 0) {
            endOfFrameTime = startOfFrameTime;
            return;
        }

        long updateTime = startOfFrameTime - endOfFrameTime;

        endOfFrameTime = startOfFrameTime;
        accumulatedTime += updateTime;

        if (!isPaused) {
            update(tetris);
        }
        render(tetris, canvasGame, nextBlockCanvas);
    }

    private void update(Tetris tetris) {

        if (!tetris.isBockOnBoard()) {
            tetris.setRandomBlock();
            tetris.saveCurrentTime();
        }

        tetris.singleCycle();
    }

    private void render(Tetris tetris, Canvas canvasGame, Canvas nextBlockCanvas) {

        if (animation) {

            renderers[1].render(tetris, nextBlockCanvas);

            if (accumulatedTime < 1000000000L) {
                renderers[2].render(tetris, canvasGame);
            } else if (accumulatedTime < 2000000000L) {
                renderers[3].render(tetris, canvasGame);
            } else if (accumulatedTime < 3000000000L) {
                renderers[4].render(tetris, canvasGame);
            } else if (accumulatedTime < 4000000000L) {
                renderers[5].render(tetris, canvasGame);
            } else {
                animation = false;
                unpause();
            }
        } else {
            renderers[0].render(tetris, canvasGame);
            renderers[1].render(tetris, nextBlockCanvas);
        }
    }

    public void pause() {
        isPaused = true;
    }

    public void unpause() {
        isPaused = false;
    }

    public boolean isPaused() {

        return isPaused;
    }

    public void setTetris(Tetris tetris) {
        this.tetris = tetris;
    }

    public void setCanvasGame(Canvas canvasGame) {
        this.canvasGame = canvasGame;
    }

    public void setNextBlockCanvas(Canvas nextBlockCanvas) {
        this.nextBlockCanvas = nextBlockCanvas;
    }
}
