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

        TetrisBlockState[] states = new TetrisBlockState[4];

        states[0] = state1;
        states[1] = state2;
        states[2] = state3;
        states[3] = state4;

        TetrisBlock block = new TetrisBlockImp(states);

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
