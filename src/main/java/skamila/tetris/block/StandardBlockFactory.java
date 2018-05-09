package skamila.tetris.block;

import skamila.tetris.block.state.*;

import java.util.ArrayList;

public class StandardBlockFactory {
    static StandardBlock L() {

        ArrayList<State> states = new ArrayList<>();

        states.add(new L1());
        states.add(new L2());
        states.add(new L3());
        states.add(new L4());

        return new StandardBlock(states);
    }
}
