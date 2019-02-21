package skamila.tetris.pc.render;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import skamila.tetris.api.board.Board;
import skamila.tetris.api.board.BoardFactory;

public class AnimationRender {

    public static void renderAnimation(Canvas canvasGame, int option) {

        Board board;

        if (option == 3) {
            board = BoardFactory.start3();
        } else if (option == 2) {
            board = BoardFactory.start2();
        } else if (option == 1) {
            board = BoardFactory.start1();
        } else {
            board = BoardFactory.startGo();
        }

        GraphicsContext gc = canvasGame.getGraphicsContext2D();

        gc.clearRect(0, 0, canvasGame.getWidth(), canvasGame.getHeight());

        gc.setStroke(Color.web("#262938"));
        gc.setLineWidth(1.0);

        drawBoards(board, gc);

    }

    private static void drawBoards(Board board, GraphicsContext gc){
        double y = 0.5;
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
