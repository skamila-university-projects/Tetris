package skamila.tetris;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class TetrisBlockTest {

    @Test
    void rotate() {

        TetrisBlockState state1 = mock(TetrisBlockState.class);
        TetrisBlockState state2 = mock(TetrisBlockState.class);
        TetrisBlockState state3 = mock(TetrisBlockState.class);
        TetrisBlockState state4 = mock(TetrisBlockState.class);

        ArrayList<TetrisBlockState> states = new ArrayList<>();

        states.add(state1);
        states.add(state2);
        states.add(state3);
        states.add(state4);

        TetrisBlock block = new TetrisBlockImpl(states);

        assertEquals(state1, block.getActiveState());

        block.rotate();
        assertEquals(state2, block.getActiveState());

        block.rotate();
        assertEquals(state3, block.getActiveState());

        block.rotate();
        assertEquals(state4, block.getActiveState());

        block.rotate();
        assertEquals(state1, block.getActiveState());
    }

}
