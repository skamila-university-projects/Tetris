package skamila.tetris.block;

import org.junit.jupiter.api.Test;
import skamila.tetris.block.state.State;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class StandardBlockTest {

    @Test
    void rotate() {
        State state1 = mock(State.class);
        State state2 = mock(State.class);
        State state3 = mock(State.class);
        State state4 = mock(State.class);

        ArrayList<State> states = new ArrayList<>();

        states.add(state1);
        states.add(state2);
        states.add(state3);
        states.add(state4);

        Block block = new StandardBlock(states);

        assertEquals(state1, block.geActiveState());

        block.rotate();
        assertEquals(state2, block.geActiveState());

        block.rotate();
        assertEquals(state3, block.geActiveState());

        block.rotate();
        assertEquals(state4, block.geActiveState());

        block.rotate();
        assertEquals(state1, block.geActiveState());
    }

}