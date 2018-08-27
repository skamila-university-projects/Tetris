package skamila.tetris.render;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import skamila.tetris.Tetris;
import skamila.tetris.board.Board;
import skamila.tetris.board.BoardFactory;

public class StartAnimation1 implements Renderer {

    @Override
    public void render(Tetris tetris, Canvas canvasGame) {

        GraphicsContext gc = canvasGame.getGraphicsContext2D();
        double y = 0.5;
        Board board = BoardFactory.start1();

        gc.clearRect(0, 0, canvasGame.getWidth(), canvasGame.getHeight());

        gc.setStroke(Color.web("#262938"));
        gc.setLineWidth(1.0);

        y = 0.5;
        for (int i = 0; i < 20; i++) {
            double x = 0.5;
            for (int j = 0; j < 10; j++) {
                gc.setFill(Color.web(board.getField(j, i).getColor()));
                gc.fillRoundRect(x, y, 26, 26, 15, 15);
                x += 28;
            }
            y += 28;
        }
    }
}
