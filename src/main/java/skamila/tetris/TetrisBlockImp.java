package skamila.tetris;

import skamila.tetris.board.Board;

import java.util.ArrayList;
import java.util.Random;

public class TetrisBlockImp implements TetrisBlock {

    private ArrayList<TetrisBlockState> tetrisBlockStates;

    private int activeStateIndex;

    private int shiftVertical;

    private int shiftHorizontal;

    public TetrisBlockImp(ArrayList<TetrisBlockState> tetrisBlockStates) {

        this.tetrisBlockStates = tetrisBlockStates;
    }

    @Override
    public TetrisBlockState getActiveState() {

        return tetrisBlockStates.get(activeStateIndex);
    }

    @Override
    public void rotate() {

        if (activeStateIndex == tetrisBlockStates.size() - 1)
            activeStateIndex = 0;
        else
            activeStateIndex++;
    }

    @Override
    public void randomizeActiveState() {

        Random generator = new Random();
        activeStateIndex = generator.nextInt(tetrisBlockStates.size());
    }

    @Override
    public void moveLeft(Board board) {
        
    }

    @Override
    public void moveRight(Board board) {

    }

    @Override
    public void moveDown(Board board) {

    }
}
