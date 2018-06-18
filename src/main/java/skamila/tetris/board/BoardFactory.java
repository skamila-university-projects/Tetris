package skamila.tetris.board;

public abstract class BoardFactory {

    public static Board create() {

        BoardField fields[][] = new BoardField[20][10];

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 10; j++) {
                fields[i][j] = new BoardField();
            }
        }

        return new Board(fields);
    }

    public static Board start3() {

        BoardField[][] fields = {
            { o(), o(), o(), o(), o(), o(), o(), o(), o(), o() },
            { o(), o(), o(), o(), o(), o(), o(), o(), o(), o() },
            { o(), o(), o(), o(), o(), o(), o(), o(), o(), o() },
            { o(), o(), o(), o(), o(), o(), o(), o(), o(), o() },
            { o(), o(), o(), o(), o(), o(), o(), o(), o(), o() },
            { o(), o(), o(), o(), o(), o(), o(), o(), o(), o() },
            { o(), o(), o(), b(), b(), b(), b(), o(), o(), o() },
            { o(), o(), b(), o(), o(), o(), b(), b(), o(), o() },
            { o(), o(), o(), o(), o(), o(), b(), b(), o(), o() },
            { o(), o(), o(), o(), b(), b(), b(), o(), o(), o() },
            { o(), o(), o(), o(), o(), o(), b(), b(), o(), o() },
            { o(), o(), b(), o(), o(), o(), b(), b(), o(), o() },
            { o(), o(), o(), b(), b(), b(), b(), o(), o(), o() },
            { o(), o(), o(), o(), o(), o(), o(), o(), o(), o() },
            { o(), o(), o(), o(), o(), o(), o(), o(), o(), o() },
            { o(), o(), o(), o(), o(), o(), o(), o(), o(), o() },
            { o(), o(), o(), o(), o(), o(), o(), o(), o(), o() },
            { o(), o(), o(), o(), o(), o(), o(), o(), o(), o() },
            { o(), o(), o(), o(), o(), o(), o(), o(), o(), o() },
            { o(), o(), o(), o(), o(), o(), o(), o(), o(), o() }
        };

        return new Board(fields);
    }

    public static Board start2() {

        BoardField[][] fields = {
            { o(), o(), o(), o(), o(), o(), o(), o(), o(), o() },
            { o(), o(), o(), o(), o(), o(), o(), o(), o(), o() },
            { o(), o(), o(), o(), o(), o(), o(), o(), o(), o() },
            { o(), o(), o(), o(), o(), o(), o(), o(), o(), o() },
            { o(), o(), o(), o(), o(), o(), o(), o(), o(), o() },
            { o(), o(), o(), o(), o(), o(), o(), o(), o(), o() },
            { o(), o(), o(), g(), g(), g(), g(), o(), o(), o() },
            { o(), o(), g(), o(), o(), o(), g(), g(), o(), o() },
            { o(), o(), o(), o(), o(), o(), g(), g(), o(), o() },
            { o(), o(), o(), o(), o(), g(), g(), o(), o(), o() },
            { o(), o(), o(), o(), g(), g(), o(), o(), o(), o() },
            { o(), o(), o(), g(), g(), o(), o(), o(), o(), o() },
            { o(), o(), g(), g(), g(), g(), g(), g(), o(), o() },
            { o(), o(), o(), o(), o(), o(), o(), o(), o(), o() },
            { o(), o(), o(), o(), o(), o(), o(), o(), o(), o() },
            { o(), o(), o(), o(), o(), o(), o(), o(), o(), o() },
            { o(), o(), o(), o(), o(), o(), o(), o(), o(), o() },
            { o(), o(), o(), o(), o(), o(), o(), o(), o(), o() },
            { o(), o(), o(), o(), o(), o(), o(), o(), o(), o() },
            { o(), o(), o(), o(), o(), o(), o(), o(), o(), o() }
        };

        return new Board(fields);
    }

    public static Board start1() {

        BoardField[][] fields = {
            { o(), o(), o(), o(), o(), o(), o(), o(), o(), o() },
            { o(), o(), o(), o(), o(), o(), o(), o(), o(), o() },
            { o(), o(), o(), o(), o(), o(), o(), o(), o(), o() },
            { o(), o(), o(), o(), o(), o(), o(), o(), o(), o() },
            { o(), o(), o(), o(), o(), o(), o(), o(), o(), o() },
            { o(), o(), o(), o(), o(), o(), o(), o(), o(), o() },
            { o(), o(), o(), o(), r(), r(), o(), o(), o(), o() },
            { o(), o(), o(), r(), r(), r(), o(), o(), o(), o() },
            { o(), o(), o(), o(), r(), r(), o(), o(), o(), o() },
            { o(), o(), o(), o(), r(), r(), o(), o(), o(), o() },
            { o(), o(), o(), o(), r(), r(), o(), o(), o(), o() },
            { o(), o(), o(), o(), r(), r(), o(), o(), o(), o() },
            { o(), o(), o(), r(), r(), r(), r(), o(), o(), o() },
            { o(), o(), o(), o(), o(), o(), o(), o(), o(), o() },
            { o(), o(), o(), o(), o(), o(), o(), o(), o(), o() },
            { o(), o(), o(), o(), o(), o(), o(), o(), o(), o() },
            { o(), o(), o(), o(), o(), o(), o(), o(), o(), o() },
            { o(), o(), o(), o(), o(), o(), o(), o(), o(), o() },
            { o(), o(), o(), o(), o(), o(), o(), o(), o(), o() },
            { o(), o(), o(), o(), o(), o(), o(), o(), o(), o() }
        };

        return new Board(fields);
    }

    public static Board startGo() {

        BoardField[][] fields = {
            { o(), o(), o(), o(), o(), o(), o(), o(), o(), o() },
            { o(), o(), o(), o(), o(), o(), o(), o(), o(), o() },
            { o(), o(), o(), y(), y(), y(), y(), o(), o(), o() },
            { o(), o(), y(), y(), o(), o(), o(), o(), o(), o() },
            { o(), o(), y(), y(), o(), o(), o(), o(), o(), o() },
            { o(), o(), y(), y(), o(), y(), y(), y(), o(), o() },
            { o(), o(), y(), y(), o(), o(), y(), y(), o(), o() },
            { o(), o(), y(), y(), o(), o(), y(), y(), o(), o() },
            { o(), o(), o(), y(), y(), y(), y(), o(), o(), o() },
            { o(), o(), o(), o(), o(), o(), o(), o(), o(), o() },
            { o(), o(), o(), y(), y(), y(), y(), o(), o(), o() },
            { o(), o(), y(), y(), o(), o(), y(), y(), o(), o() },
            { o(), o(), y(), y(), o(), o(), y(), y(), o(), o() },
            { o(), o(), y(), y(), o(), o(), y(), y(), o(), o() },
            { o(), o(), y(), y(), o(), o(), y(), y(), o(), o() },
            { o(), o(), y(), y(), o(), o(), y(), y(), o(), o() },
            { o(), o(), o(), y(), y(), y(), y(), o(), o(), o() },
            { o(), o(), o(), o(), o(), o(), o(), o(), o(), o() },
            { o(), o(), o(), o(), o(), o(), o(), o(), o(), o() },
            { o(), o(), o(), o(), o(), o(), o(), o(), o(), o() }
        };

        return new Board(fields);
    }

    private static BoardField o() {

        return new BoardField();
    }

    private static BoardField r() {

        return new BoardField("#D5111B");
    }

    private static BoardField g() {

        return new BoardField("#ABDC18");
    }

    private static BoardField b() {

        return new BoardField("#0098D9");
    }

    private static BoardField y() {

        return new BoardField("#FFD953");
    }
}
