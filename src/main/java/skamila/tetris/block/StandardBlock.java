package skamila.tetris.block;

import skamila.tetris.block.state.State;

import java.util.ArrayList;
import java.util.Random;

public class StandardBlock implements Block {

    private ArrayList<State> states;
    private int activeStateIndex;

    public StandardBlock(ArrayList<State> states) {

        this.states = states;

        Random generator = new Random();
        activeStateIndex = generator.nextInt(states.size());

    }

    @Override
    public void addState(State state) {
        states.add(state);
    }

    @Override
    public State geActiveState() {
        return states.get(activeStateIndex);
    }

    @Override
    public void rotate() {
        if (activeStateIndex == states.size() - 1)
            activeStateIndex = 0;
        else
            activeStateIndex++;
    }
}
