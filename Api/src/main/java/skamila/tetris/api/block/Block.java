package skamila.tetris.api.block;

import skamila.tetris.api.board.Board;

public interface Block {

	BlockState getActiveState();

	void rotate(Board board);

	void randomizeActiveState();

	void moveLeft(Board board);

	void moveRight(Board board);

	void moveDown(Board board);

	void countInitialShift(Board board);

	boolean isMergeable(Board board);

	BlockState getShiftedActiveState();

	String getColor();
}
