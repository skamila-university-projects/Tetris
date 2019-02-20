package skamila.tetris.pc.render;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import skamila.tetris.api.Tetris;
import skamila.tetris.api.block.StatePoint;

public class RoundCornerNextBlockRenderer implements Renderer {

    @Override
    public void render(Tetris tetris, Canvas nextBlockCanvas) {

        GraphicsContext gc = nextBlockCanvas.getGraphicsContext2D();

        gc.clearRect(0, 0, nextBlockCanvas.getWidth(), nextBlockCanvas.getHeight());

        StatePoint[] statePoints = tetris.getNextBlock().getActiveState().getPositionValues();

        int[][] points = new int[4][4];

        for (int i = 0; i < statePoints.length; i++) {
            int x = statePoints[i].getX();
            int y = statePoints[i].getY();
            points[y][x] = 1;
        }

        double y = 0.5;

        for (int i = 0; i < 4; i++) {
            double x = 0.5;
            for (int j = 0; j < 4; j++) {
                if (points[i][j] == 1) {
                    gc.setFill(Color.web(tetris.getNextBlock().getColor()));
                } else {
                    gc.setFill(Color.web("#303447"));
                }
                gc.fillRoundRect(x, y, 18, 18, 10, 10);
                x += 20;
            }
            y += 20;
        }
    }
}
