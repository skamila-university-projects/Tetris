package skamila.tetris;

import skamila.tetris.board.Board;
import skamila.tetris.states.Point;

import java.util.ArrayList;
import java.util.Random;

public class TetrisBlockImp implements TetrisBlock {

    private TetrisBlockState[] states;

    private int activeStateIndex;

    private int shiftVertical;

    private int shiftHorizontal;

    public TetrisBlockImp(TetrisBlockState[] states) {

        this.states = states;
    }

    @Override
    public TetrisBlockState getActiveState() {

        return states[activeStateIndex];
    }

    @Override
    public void rotate() {

        if (activeStateIndex == states.length - 1)
            activeStateIndex = 0;
        else
            activeStateIndex++;
    }

    @Override
    public void randomizeActiveState() {

        Random generator = new Random();
        activeStateIndex = generator.nextInt(states.length);
    }

    @Override
    public void moveLeft(Board board) {

        Point[] points = states[activeStateIndex].getPositionValues();

        for (int i = 0; i < points.length; i++) {
            if (points[i].getX() + shiftHorizontal - 1 < 0)
                return;
            if (
                board
                    .getField(
                        points[i].getX() + shiftHorizontal - 1,
                        points[i].getY() + shiftVertical
                    )
                    .isOccupied()
            )
                return;
        }

        shiftHorizontal--;
    }

    @Override
    public void moveRight(Board board) {

        Point[] points = states[activeStateIndex].getPositionValues();

        for (int i = 0; i < points.length; i++) {
            if (points[i].getX() + shiftHorizontal + 1 >= board.getWidth())
                return;
            if (
                board
                    .getField(
                        points[i].getX() + shiftHorizontal + 1,
                        points[i].getY() + shiftVertical
                    )
                    .isOccupied()
            )
                return;
        }

        shiftHorizontal++;
    }

    @Override
    public void moveDown(Board board) {

        Point[] points = states[activeStateIndex].getPositionValues();

        for (int i = 0; i < points.length; i++) {
            if (points[i].getY() + shiftVertical + 1 >= board.getHeight())
                return;
            if (
                board
                    .getField(
                        points[i].getX() + shiftHorizontal,
                        points[i].getY() + shiftVertical + 1
                    )
                    .isOccupied()
            )
                return;
        }

        shiftVertical++;

        // zatapianie. tu czy nie tu?
    }
}
