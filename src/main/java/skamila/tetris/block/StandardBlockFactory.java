package skamila.tetris.block;

import skamila.tetris.block.state.*;

import java.util.ArrayList;

public class StandardBlockFactory {
    public static Block L() {

        ArrayList<State> states = new ArrayList<>();

        states.add(new L1());
        states.add(new L2());
        states.add(new L3());
        states.add(new L4());

        Block block = new StandardBlock(states);
        block.randomizeActiveState();

        return block;
    }

    public static Block O() {

        ArrayList<State> states = new ArrayList<>();

        states.add(new O());

        Block block = new StandardBlock(states);
        block.randomizeActiveState();

        return block;
    }
}
