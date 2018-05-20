package skamila.tetris.board;

public class Board {

    private Field board[][];
    private int height, width;

    public Board(int height, int width) {

        board = new Field[height][width];
        this.height = height;
        this.width = width;

        for (int i = 0; i < this.height; i++){
            for (int j = 0; j < this.width; j++){
                board[i][j] = new Field();
            }
        }
    }

    public Board(Field board[][]){
        this.board = board;
        this.height = board.length;
        this.width = board[0].length;
    }

    public Field[][] getFields(){
        return board;
    }

    public void cleanBoard(){
        for (int i = 0; i < height; i++){
            if(isRowFull(i)) deleteRow(i);
        }
    }

    private boolean isRowFull (int rowIndex){
        for (int i = 0; i < width; i++){
            if(!board[rowIndex][i].isFull()) return false;
        }
        return true;
    }

    private void deleteRow(int rowIndex){

        for (int i = rowIndex; i > 0; i--){
            for (int j = 0; j < width; j++){
                board[i][j] = board[i - 1][j];
            }
        }

        for(int j = 0; j < width; j++){
            board[0][j] = new Field();
        }

    }
}
