package skamila.tetris.board;

public class Field {

    private boolean isFull;
    private int color;

    public Field() {
        color = 0;
        isFull = false;
    }

    public boolean isFull(){
        return isFull;
    }

    public void resetField(){
        color = 0;
        isFull = false;
    }

    public void setField(int color){
        isFull = true;
    }

}
