package skamila.tetris.board;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BoardTest {

    private Field e() {
        return new Field();
    }

    private Field f() {
        return new Field(1);
    }

    @Test
    void cleanBoardTwoRows() {

            Field inputFields [][] = {
                    {e(), e(), e(), f(), e()},
                    {e(), f(), e(), e(), e()},
                    {f(), f(), f(), f(), f()},
                    {f(), e(), f(), f(), f()},
                    {f(), f(), f(), f(), f()}
            };
            
            Board board = new Board(inputFields);
            board.cleanBoard();
            Field[][] actualFields = board.getFields();

            Field expectedFields [][] = {
                    {e(), e(), e(), e(), e()},
                    {e(), e(), e(), e(), e()},
                    {e(), e(), e(), f(), e()},
                    {e(), f(), e(), e(), e()},
                    {f(), e(), f(), f(), f()}
            };

            for (int i = 0; i < actualFields.length; i++){
                for (int j = 0; j < actualFields[i].length; j++){
                    assertEquals(actualFields[i][j].isFull(), expectedFields[i][j].isFull());
                }
            }
        }

    @Test
    void cleanBoardNoRowsToClean() {

        Field inputFields [][] = {
                {e(), e(), e(), f(), e()},
                {e(), f(), e(), e(), e()},
                {f(), f(), e(), f(), f()},
                {f(), e(), f(), f(), f()},
                {f(), f(), e(), f(), f()}
        };

        Board board = new Board(inputFields);
        board.cleanBoard();
        Field[][] actualFields = board.getFields();

        Field expectedFields [][] = {
                {e(), e(), e(), f(), e()},
                {e(), f(), e(), e(), e()},
                {f(), f(), e(), f(), f()},
                {f(), e(), f(), f(), f()},
                {f(), f(), e(), f(), f()}
        };

        for (int i = 0; i < actualFields.length; i++){
            for (int j = 0; j < actualFields[i].length; j++){
                assertEquals(actualFields[i][j].isFull(), expectedFields[i][j].isFull());
            }
        }
    }

    @Test
    void cleanBoardAllRowsToClean() {

        Field inputFields [][] = {
                {f(), f(), f(), f(), f()},
                {f(), f(), f(), f(), f()},
                {f(), f(), f(), f(), f()},
                {f(), f(), f(), f(), f()},
                {f(), f(), f(), f(), f()}
        };

        Board board = new Board(inputFields);
        board.cleanBoard();
        Field[][] actualFields = board.getFields();

        Field expectedFields [][] = {
                {e(), e(), e(), e(), e()},
                {e(), e(), e(), e(), e()},
                {e(), e(), e(), e(), e()},
                {e(), e(), e(), e(), e()},
                {e(), e(), e(), e(), e()}
        };

        for (int i = 0; i < actualFields.length; i++){
            for (int j = 0; j < actualFields[i].length; j++){
                assertEquals(actualFields[i][j].isFull(), expectedFields[i][j].isFull());
            }
        }
    }
}