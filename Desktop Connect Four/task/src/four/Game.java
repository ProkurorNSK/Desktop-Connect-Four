package four;

import java.awt.*;

public class Game {
    int rows = 6;
    int columns = 7;

    boolean endGame;

    ConnectFour.Button[][] field;

    public Game() {
        field = new ConnectFour.Button[rows][columns];
    }

    ConnectFour.Button setTurn(int column, int player) {
        ConnectFour.Button result = field[rows - 1][column];
        for (int i = 0; i < rows; i++) {
            if (field[i][column].player != 0) {
                result = i == 0 ? null : field[i - 1][column];
                break;
            }
        }

        if (result != null) {
            result.player = player;
        }

        isEndGame();

        return result;
    }

    private void isEndGame() {
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = 0; j < columns; j++) {
                for (int k = -1; k < 2; k++) {
                    for (int l = -1; l < 2; l++) {
                        if (k != 0 || l != 0) {
                            int sum = 0;
                            for (int m = 0; m < 4; m++) {
                                if (i + m * k >= 0 &&
                                        i + m * k < rows &&
                                        j + m * l >= 0 &&
                                        j + m * l < columns) {
                                    sum += field[i + m * k][j + m * l].player;
                                }
                            }
                            if (sum == -4 || sum == 4) {
                                paintEnd(i, j, k, l);
                                endGame = true;
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    private void paintEnd(int r, int c, int dr, int dc) {
        for (int i = 0; i < 4; i++) {
            field[r + i * dr][c + i * dc].setBackground(new Color(1, 231, 119));
        }
    }
}
