package skamila.tetris.board;

public class Field {

    private boolean isFull;
    private int color;

    public Field() {
        color = 0;
        isFull = false;
    }

    public Field(int color){
        this.color = 0;
        isFull = true;
    }

    public boolean isFull(){
        return isFull;
    }
}
