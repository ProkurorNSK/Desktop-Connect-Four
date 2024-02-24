package four;

public class Game {
    int rows = 6;
    int columns = 7;

    ConnectFour.Button[][] field;

    public Game() {
        field = new ConnectFour.Button[rows][columns];
    }

    ConnectFour.Button setTurn(int column) {
        for (int i = 0; i < rows; i++) {
            if (field[i][column].player != 0) {
                return i == 0 ? null : field[i - 1][column];
            }
        }
        return field[rows - 1][column];
    }
}
