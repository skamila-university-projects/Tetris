package skamila.tetris.pc;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.text.Text;
import skamila.tetris.api.Tetris;
import skamila.tetris.pc.controller.GameController;
import skamila.tetris.pc.render.*;

public class TetrisGame extends AnimationTimer implements Runnable{

    private Canvas canvasGame;
    private Canvas nextBlockCanvas;
    private Renderer[] renderers;
    private Tetris tetris;
    private boolean animation;
    private long endOfFrameTime;
    private long accumulatedTime;
    private Text pointsText, levelText;
    private GameController controller;

    public TetrisGame() {

        this(Tetris.create());

    }

    public TetrisGame(Tetris tetris) {

        this.renderers = new Renderer[]{
                new RoundCornerBoardRenderer(),
                new RoundCornerNextBlockRenderer(),
        };

        this.animation = true;
        this.tetris = tetris;
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

        if (!tetris.isPaused()) {
            update(tetris);
        }
        render(tetris, canvasGame, nextBlockCanvas);
    }

    private void update(Tetris tetris) {

        if (!tetris.isBlockOnBoard()) {
            tetris.setRandomBlock();
            tetris.saveCurrentTime();
        }

        tetris.singleCycle();
    }

    private void render(Tetris tetris, Canvas canvasGame, Canvas nextBlockCanvas) {

        if (animation) {

            renderers[1].render(tetris, nextBlockCanvas);

            if (accumulatedTime < 1000000000L) {
                AnimationRender.renderAnimation(canvasGame, 3);
            } else if (accumulatedTime < 2000000000L) {
                AnimationRender.renderAnimation(canvasGame, 2);
            } else if (accumulatedTime < 3000000000L) {
                AnimationRender.renderAnimation(canvasGame, 1);
            } else if (accumulatedTime < 4000000000L) {
                AnimationRender.renderAnimation(canvasGame, 0);
            } else {
                animation = false;
                tetris.unpause();
            }
        } else {
            renderers[0].render(tetris, canvasGame);
            renderers[1].render(tetris, nextBlockCanvas);
            levelText.setText(tetris.getLevel() + "");
            pointsText.setText(tetris.getPoints() + "");

            if (tetris.isGameOver()) {
                long timer = System.nanoTime() / 10000000;
                while (timer < 10) {
                    timer = System.nanoTime() / 10000000;
                }

                if (tetris.getLeaderboard().isTheBestScore(tetris.getPoints())){
                    controller.congratulation();
                    stop();
                } else {
                    controller.gameOver();
                    stop();
                }
            }
        }
    }

    public void setTetris(Tetris tetris) {

        this.tetris = tetris;
    }

    public void setGameCanvas(Canvas canvasGame) {

        this.canvasGame = canvasGame;
    }

    public void setNextBlockCanvas(Canvas nextBlockCanvas) {

        this.nextBlockCanvas = nextBlockCanvas;
    }

    public Tetris getTetris(){
        return tetris;
    }

    public void setPointTextHolder(Text pointsText) {

        this.pointsText = pointsText;
    }

    public void setLevelTextHolder(Text levelText) {
        this.levelText = levelText;
        levelText.setText(tetris.getLevel() + "");
    }

    public void setController(GameController gameController) {
        controller = gameController;
    }

    @Override
    public void run() {
        start();
    }
}
