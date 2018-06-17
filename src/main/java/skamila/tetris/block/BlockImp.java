package skamila.tetris.block;

import java.util.Random;

import skamila.tetris.board.Board;

public class BlockImp implements Block {

    private BlockState[] states;

    private int activeStateIndex;

    private int shiftVertical;

    private int shiftHorizontal;

    private String color = "#709255";

    public BlockImp(BlockState[] states) {

        //                  green,      yellow,    blue,      red,       purple,    orange,  color of sea
        String[] colors = {"#ABDC18", "#FFD953", "#0098D9", "#D5111B", "#7B377B", "#DC750E", "#009669"};
        Random generator = new Random();
        int randomNumber = generator.nextInt(colors.length);

        this.color = colors[randomNumber];
        this.states = states;

    }

    @Override
    public BlockState getActiveState() {

        return states[activeStateIndex];
    }

    @Override
    public void rotate(Board board) {

        if (!isBlockVisible())
            return;

        int newStateIndex = activeStateIndex + 1;
        if (newStateIndex == states.length)
            newStateIndex = 0;

        int newShiftHorizontal = shiftHorizontal;
        boolean rightShift = false;
        boolean leftShift = false;

        StatePoint[] points = states[newStateIndex].getPositionValues();

        int i = 0;

        while (i < points.length) {

            if (points[i].getX() + newShiftHorizontal < 0) {

                if (leftShift == true)
                    return;

                newShiftHorizontal++;
                rightShift = true;
                i = 0;
                continue;

            }

            if (points[i].getX() + newShiftHorizontal >= board.getWidth()) {

                if (rightShift == true)
                    return;

                newShiftHorizontal--;
                leftShift = true;
                i = 0;
                continue;

            }
            i++;

        }

        for (i = 0; i < points.length; i++) {
            if (points[i].getY() + shiftVertical >= board.getHeight() - 1)
                return;
            if (
                points[i].getY() + shiftVertical > 0 && board
                    .getField(
                        points[i].getX() + newShiftHorizontal,
                        points[i].getY() + shiftVertical
                    )
                    .isOccupied()
            )
                return;
        }

        shiftHorizontal = newShiftHorizontal;
        activeStateIndex = newStateIndex;
    }

    @Override
    public void randomizeActiveState() {

        Random generator = new Random();
        activeStateIndex = generator.nextInt(states.length);
    }

    @Override
    public void moveLeft(Board board) {

        if (!isBlockVisible())
            return;

        StatePoint[] statePoints = states[activeStateIndex].getPositionValues();

        for (int i = 0; i < statePoints.length; i++) {
            if (statePoints[i].getX() + shiftHorizontal - 1 < 0)
                return;
            if (isLeftOccupied(board, statePoints[i]))
                return;
        }
        shiftHorizontal--;
    }

    @Override
    public void moveRight(Board board) {

        if (!isBlockVisible())
            return;

        StatePoint[] statePoints = states[activeStateIndex].getPositionValues();

        for (int i = 0; i < statePoints.length; i++) {
            if (statePoints[i].getX() + shiftHorizontal + 1 >= board.getWidth())
                return;
            if (isRightOccupied(board, statePoints[i]))
                return;
        }

        shiftHorizontal++;
    }

    @Override
    public void moveDown(Board board) {

        StatePoint[] statePoints = states[activeStateIndex].getPositionValues();

        for (int i = 0; i < statePoints.length; i++) {

            if (statePoints[i].getY() + shiftVertical + 1 >= board.getHeight())
                return;
            if (statePoints[i].getY() + shiftVertical <= -2)
                continue;
            if (isUnderOccupied(board, statePoints[i]))
                return;
        }

        shiftVertical++;

    }

    public boolean isMergable(Board board) {

        StatePoint[] statePoints = states[activeStateIndex].getPositionValues();

        for (int i = 0; i < statePoints.length; i++) {

            if (statePoints[i].getY() + shiftVertical <= -2)
                continue;

            if (statePoints[i].getY() + shiftVertical + 1 >= board.getHeight())
                return true;

            if (isUnderOccupied(board, statePoints[i]))
                return true;
        }
        return false;
    }

    private boolean isBlockVisible() {

        StatePoint[] statePoints = states[activeStateIndex].getPositionValues();

        for (int i = 0; i < statePoints.length; i++) {
            if (statePoints[i].getY() + shiftVertical >= 0)
                return true;
        }

        return false;
    }

    private boolean isUnderOccupied(Board board, StatePoint statePoint) {

        return board
            .getField(
                statePoint.getX() + shiftHorizontal,
                statePoint.getY() + shiftVertical + 1
            )
            .isOccupied();
    }

    private boolean isLeftOccupied(Board board, StatePoint statePoint) {

        if (statePoint.getY() + shiftVertical < 0)
            return false;

        return board
            .getField(
                statePoint.getX() + shiftHorizontal - 1,
                statePoint.getY() + shiftVertical
            )
            .isOccupied();
    }

    private boolean isLeftOccupied(Board board, StatePoint statePoint, int shiftHorizontal) {

        if (statePoint.getY() + shiftVertical < 0)
            return false;

        return board
            .getField(
                statePoint.getX() + shiftHorizontal - 1,
                statePoint.getY() + shiftVertical
            )
            .isOccupied();
    }

    private boolean isRightOccupied(Board board, StatePoint statePoint) {

        if (statePoint.getY() + shiftVertical < 0)
            return false;

        return board
            .getField(
                statePoint.getX() + shiftHorizontal + 1,
                statePoint.getY() + shiftVertical
            )
            .isOccupied();
    }

    private boolean isRightOccupied(Board board, StatePoint statePoint, int shiftHorizontal) {

        if (statePoint.getY() + shiftVertical < 0)
            return false;

        return board
            .getField(
                statePoint.getX() + shiftHorizontal + 1,
                statePoint.getY() + shiftVertical
            )
            .isOccupied();
    }

    public BlockState getShiftedActiveState() {

        BlockState activeState = states[activeStateIndex];
        StatePoint[] statePoints = activeState.getPositionValues();
        StatePoint[] shiftedStatePoints = new StatePoint[statePoints.length];

        for (int i = 0; i < statePoints.length; i++) {
            shiftedStatePoints[i] = new StatePoint(
                statePoints[i].getX() + shiftHorizontal,
                statePoints[i].getY() + shiftVertical
            );
        }

        return new BlockStateImp(shiftedStatePoints);
    }

    public void countInitialShift(Board board) {

        shiftHorizontal = (board.getWidth() - countWidth()) / 2 - firstindexX();
        shiftVertical -= countHeight() + firstindexY();
    }

    private int firstindexX() {

        StatePoint[] statePoints = states[activeStateIndex].getPositionValues();
        int firstindexX = statePoints[0].getX();

        for (int i = 1; i < statePoints.length; i++) {
            if (statePoints[i].getX() < firstindexX)
                firstindexX = statePoints[i].getX();
        }

        return firstindexX;
    }

    private int firstindexY() {

        StatePoint[] statePoints = states[activeStateIndex].getPositionValues();
        int firstindexY = statePoints[0].getY();

        for (int i = 1; i < statePoints.length; i++) {
            if (statePoints[i].getY() < firstindexY)
                firstindexY = statePoints[i].getY();
        }

        return firstindexY;
    }

    private int countWidth() {

        StatePoint[] statePoints = states[activeStateIndex].getPositionValues();
        boolean[] blockWidth = new boolean[4];
        int width = 0;

        for (int i = 0; i < statePoints.length; i++) {
            blockWidth[statePoints[i].getX()] = true;
        }

        for (int i = 0; i < blockWidth.length; i++) {
            if (blockWidth[i] == true)
                width++;
        }
        return width;
    }

    private int countHeight() {

        StatePoint[] statePoints = states[activeStateIndex].getPositionValues();
        boolean[] blockHeight = new boolean[4];
        int height = 0;

        for (int i = 0; i < statePoints.length; i++) {
            blockHeight[statePoints[i].getY()] = true;
        }

        for (int i = 0; i < blockHeight.length; i++) {
            if (blockHeight[i] == true)
                height++;
        }
        return height;
    }

    public String getColor() {

        return color;
    }
}
