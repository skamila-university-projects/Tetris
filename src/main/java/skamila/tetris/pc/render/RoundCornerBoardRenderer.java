package skamila.tetris.pc.render;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import skamila.tetris.pc.Tetris;
import skamila.tetris.api.block.StatePoint;

public class RoundCornerBoardRenderer implements Renderer {

    @Override
    public void render(Tetris tetris, Canvas canvasGame) {

        GraphicsContext gc = canvasGame.getGraphicsContext2D();

        gc.clearRect(0, 0, canvasGame.getWidth(), canvasGame.getHeight());

        gc.setStroke(Color.web("#262938"));
        gc.setLineWidth(1.0);

        double y = 0.5;
        for (int i = 0; i < 20; i++) {
            double x = 0.5;
            for (int j = 0; j < 10; j++) {
                gc.setFill(Color.web(tetris.getBoard().getField(j, i).getColor()));
                gc.fillRoundRect(x, y, 26, 26, 15, 15);
                x += 28;
            }
            y += 28;
        }

        if (tetris.getCurrentBlock() != null) {
            StatePoint[] blockState = tetris
                .getCurrentBlock()
                .getShiftedActiveState()
                .getPositionValues();

            for (int i = 0; i < blockState.length; i++) {
                if (blockState[i].getY() < 0)
                    continue;

                gc.setFill(Color.web(tetris.getCurrentBlock().getColor()));
                double positionX = blockState[i].getX() * 28 + 0.5;
                double positionY = blockState[i].getY() * 28 + 0.5;
                gc.fillRoundRect(positionX, positionY, 26, 26, 15, 15);
            }
        }

    }
}
