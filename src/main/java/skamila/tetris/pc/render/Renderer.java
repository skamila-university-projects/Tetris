package skamila.tetris.pc.render;

import javafx.scene.canvas.Canvas;
import skamila.tetris.api.Tetris;

public interface Renderer {

    void render(Tetris tetris, Canvas canvas);

}
