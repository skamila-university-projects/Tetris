package skamila.tetris;

import javafx.scene.canvas.Canvas;
import skamila.tetris.render.Renderer;

public class TetrisGameLoop {

    private Renderer[] renderers;

    private int updatesPerFrame;

    private boolean isRunning = false;

    private boolean isPaused = false;

    private Tetris tetris;

    public TetrisGameLoop(Renderer[] renderers) {

        this.renderers = renderers;
    }

    public void run(Tetris tetris, Canvas canvasGame, Canvas nextBlockCanvas) {

        this.tetris = tetris;
        long startOfFrameTime = System.nanoTime(); // aktualny czas
        double UPDATE_SPEED = 1000000000.0 / 30.0; // czas co jaki update ma być wywoływany (30
        // updates per second)
        long updateTime = 0; // czas realizacji update
        long endOfFrameTime = 0; // czas w którym zakończyła się realizacja jednej ramki
        long accumulatedTime = 0;

        long fpsAccumulator = 0;
        long frames = 0;
        double fps = 0.0;

        while (isRunning) {
            if (isPaused) {
                try {
                    System.out.println("Sleep");
                    Thread.sleep(Long.MAX_VALUE);
                }
                catch (InterruptedException e) {

                }
            }
            if (!isRunning) {
                System.out.println("isRunning " + isRunning);
                return;
            }

            updatesPerFrame = 0;
            endOfFrameTime = System.nanoTime(); // tu jest pobierany czas zakończenia ramki
            updateTime = endOfFrameTime - startOfFrameTime; // tutaj wyliczany jest czas trwania
            // ramki
            startOfFrameTime = endOfFrameTime; // tutaj ramka się zaczyna

            accumulatedTime += updateTime; // suma czasów realizacji każdej ramk

            if (accumulatedTime >= UPDATE_SPEED) {
                render(tetris, canvasGame, nextBlockCanvas);
            }

            while (accumulatedTime >= UPDATE_SPEED) { // jeżeli suma czasów realizacji ramek jest
                // większa od czasu między wykonywaniem update
                update(tetris, UPDATE_SPEED); // to wykonywany jest update. update wykownywany jest
                                              // tak
                // długo aż wyczerpie się zakumulowany
                accumulatedTime -= UPDATE_SPEED; // czas z poprzednich klatek.
            }

            fpsAccumulator += updateTime;
            if (fpsAccumulator >= 250000000) { // co 0.25 s obliczamy fps
                fps = frames * (4.0 * (250000000.0 / fpsAccumulator)); // monożymy ilość klatek x4
                // bo sprawdzamy co 1/4
                // sekundy * korekcja

                frames = 0; // zerujemy ilość ramek
                fpsAccumulator = 0; // zerujemy akumulator
            }

            frames++; // zliczamy ramki dla obliczenia fps
        }

        System.out.println("exited");
    }

    private void update(Tetris tetris, double update_speed) {

        if (!tetris.isBockOnBoard()) {
            System.out.println("NeedBlock");
            tetris.setRandomBlock();
            tetris.saveCurrentTime();
        }
        tetris.singleCycle();

        updatesPerFrame++;
    }

    private void render(Tetris tetris, Canvas canvasGame, Canvas nextBlockCanvas) {

        renderers[0].render(tetris, canvasGame);
        renderers[1].render(tetris, nextBlockCanvas);
    }

    public void start() {

        System.out.println("Start");
        isRunning = true;
    }

    public void stop() {

        System.out.println("Stop");
        isRunning = false;
    }

    public void pause() {

        System.out.println("Pause");
        isPaused = true;
    }

    public void unpouse() {

        System.out.println("unpause");
        isPaused = false;
        tetris.getThread().interrupt();
    }

    public boolean isPaused() {

        return isPaused;
    }

    public boolean isRunning() {

        return isRunning;
    }
}
