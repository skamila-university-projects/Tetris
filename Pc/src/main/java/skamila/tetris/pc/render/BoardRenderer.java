package skamila.tetris.pc.render;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import skamila.tetris.api.Tetris;
import skamila.tetris.api.block.StatePoint;

public class BoardRenderer implements Renderer {

	@Override
	public void render(Tetris tetris, Canvas canvasGame) {

		GraphicsContext gc = canvasGame.getGraphicsContext2D();

		gc.clearRect(0, 0, canvasGame.getWidth(), canvasGame.getHeight());

		gc.setStroke(Color.web("#262938"));
		gc.setLineWidth(1.0);

		drawBoard(tetris, gc);

		if (tetris.getCurrentBlock() != null) {
			drawBlock(tetris, gc);
		}

	}

	private void drawBoard(Tetris tetris, GraphicsContext gc) {
		double y = 0.5;
		for (int i = 0; i < 20; i++) {
			double x = 0.5;
			for (int j = 0; j < 10; j++) {
				if (tetris.isPaused() && tetris.getBoard().getField(j, i).isOccupied()) {
					gc.setFill(Color.web("#888888"));
				} else {
					gc.setFill(Color.web(tetris.getBoard().getField(j, i).getColor()));
				}
				gc.fillRoundRect(x, y, 26, 26, 15, 15);
				x += 28;
			}
			y += 28;
		}
	}

	private void drawBlock(Tetris tetris, GraphicsContext gc) {

		StatePoint[] blockState = tetris.getCurrentBlock().getShiftedActiveState().getPositionValues();

		for (StatePoint state : blockState) {

			if (state.getY() < 0) {
				continue;
			}

			if (tetris.isPaused()) {
				gc.setFill(Color.web("#888888"));
			} else {
				gc.setFill(Color.web(tetris.getCurrentBlock().getColor()));
			}

			double positionX = state.getX() * 28 + 0.5;
			double positionY = state.getY() * 28 + 0.5;
			gc.fillRoundRect(positionX, positionY, 26, 26, 15, 15);

		}
	}
}
