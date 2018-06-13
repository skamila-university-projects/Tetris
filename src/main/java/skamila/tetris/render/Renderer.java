package skamila.tetris.render;

import javafx.scene.canvas.Canvas;
import skamila.tetris.Tetris;

public interface Renderer {

    public void render(Tetris tetris, Canvas canvas);
}
