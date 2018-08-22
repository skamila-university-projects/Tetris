package skamila.tetris;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import skamila.tetris.render.Renderer;

public class TetrisGameLoop extends AnimationTimer {

    private Canvas canvasGame;

    private Canvas nextBlockCanvas;

    private Renderer[] renderers;

    private int updatesPerFrame;

    private boolean isRunning = false;

    private boolean isPaused = false;

    private Tetris tetris;

    private boolean animation;

    private long endOfFrameTime;

    private long accumulatedTime;

    private long fpsAccumulator;

    private long frames;

    private double fps;

    public TetrisGameLoop(
        Renderer[] renderers
    ) {

        this.renderers = renderers;
        this.animation = true;
    }

    @Override
    public void handle(long startOfFrameTime) {

        if (endOfFrameTime == 0) {
            endOfFrameTime = startOfFrameTime;
            return;
        }

        long updateTime = startOfFrameTime - endOfFrameTime;

        endOfFrameTime = startOfFrameTime;
        accumulatedTime += updateTime; // suma czasów realizacji każdej ramk

        double UPDATE_SPEED = 1000000000.0 / 30.0;

        if (!isPaused) {
            update(tetris, UPDATE_SPEED);
        }
        render(tetris, canvasGame, nextBlockCanvas);
    }

    private void update(Tetris tetris, double update_speed) {

        if (!tetris.isBockOnBoard()) {
            tetris.setRandomBlock();
            tetris.saveCurrentTime();
        }
        tetris.singleCycle();
        System.out.println(3);
        updatesPerFrame++;
    }

    private void render(Tetris tetris, Canvas canvasGame, Canvas nextBlockCanvas) {
        if (animation) {
            renderers[1].render(tetris, nextBlockCanvas);
            renderers[2].render(tetris, canvasGame);
            animation = false;
        } else {
            renderers[0].render(tetris, canvasGame);
            renderers[1].render(tetris, nextBlockCanvas);
        }
    }

//     public void start() {
//
//        super.start();
//        isRunning = true;
//     }
//
//     public void stop() {
//
//        isRunning = false;
//     }

    public void pause() {

        isPaused = true;
    }

    public void unpouse() {

        isPaused = false;
        tetris.getThread().interrupt();
    }

    public boolean isPaused() {

        return isPaused;
    }

    public boolean isRunning() {

        return isRunning;
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
