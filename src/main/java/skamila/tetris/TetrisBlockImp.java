package skamila.tetris;

import skamila.tetris.board.Board;
import skamila.tetris.board.BoardField;
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
            if (points[i].getY() + shiftVertical <= -2)
                continue;
            if (isNextOccupied(board, points[i]))
                return;
        }

        shiftVertical++;

        // zatapianie. tu czy nie tu?
    }

    private boolean isNextOccupied(Board board, Point point) {

        return board
            .getField(
                point.getX() + shiftHorizontal,
                point.getY() + shiftVertical + 1
            )
            .isOccupied();
    }

    public TetrisBlockState getShiftedActiveState() {

        TetrisBlockState activeState = states[activeStateIndex];
        Point[] points = activeState.getPositionValues();
        Point[] shiftedPoints = new Point[points.length];

        for (int i = 0; i < points.length; i++) {
            shiftedPoints[i] = new Point(
                points[i].getX() + shiftHorizontal,
                points[i].getY() + shiftVertical
            );
        }

        return new TetrisBlockStateImp(shiftedPoints);
    }

    public void countInitialShift(Board board) {

        shiftHorizontal = (board.getWidth() - countWidth()) / 2;
        shiftVertical -= countHeight();
    }

    private int countWidth() {

        Point[] points = states[activeStateIndex].getPositionValues();
        boolean[] blockWidth = new boolean[4];
        int width = 0;

        for (int i = 0; i < points.length; i++) {
            blockWidth[points[i].getX()] = true;
        }

        for (int i = 0; i < blockWidth.length; i++) {
            if (blockWidth[i] == true) {
                width++;
            }
        }
        return width;
    }

    private int countHeight() {

        Point[] points = states[activeStateIndex].getPositionValues();
        boolean[] blockHeight = new boolean[4];
        int height = 0;

        for (int i = 0; i < points.length; i++) {
            blockHeight[points[i].getY()] = true;
        }

        for (int i = 0; i < blockHeight.length; i++) {
            if (blockHeight[i] == true) {
                height++;
            }
        }
        return height;
    }

}
