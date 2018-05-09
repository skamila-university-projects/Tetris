package skamila.tetris.block;

import skamila.tetris.block.state.State;

public interface Block {
    void addState(State state);

    State geActiveState();

    void rotate();
}
