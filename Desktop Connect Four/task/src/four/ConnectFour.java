package four;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class ConnectFour extends JFrame implements ActionListener {
    String player = "X";
    Game game = new Game();

    public ConnectFour() {

        for (int i = 0; i < game.rows; i++) {
            for (int j = 0; j < game.columns; j++) {
                Button button = new Button(" ", i, j);
                button.setFocusPainted(false);
                button.setName("Button" + (char) (65 + j) + (game.columns - i - 1));
                button.addActionListener(this);
                if ((i + j) % 2 == 0) {
                    button.setBackground(new Color(156, 204, 101));
                } else {
                    button.setBackground(new Color(175, 213, 130));
                }
                game.field[i][j] = button;
                add(button);
            }
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setVisible(true);
        setLayout(new GridLayout(game.rows, game.columns));
        setTitle("Connect Four");
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();
        button = game.setTurn(button.column);
        if (!Objects.isNull(button)) {
            button.setText(player);
            button.player = Objects.equals(player, "X") ? 1 : 2;
            changePlayer();
        }
    }

    private void changePlayer() {
        if (Objects.equals(player, "X")) {
            player = "O";
        } else {
            player = "X";
        }
    }

    static class Button extends JButton {
        int row;
        int column;

        int player;

        public Button(String text, int row, int column) {
            super(text);
            this.row = row;
            this.column = column;
        }
    }
}