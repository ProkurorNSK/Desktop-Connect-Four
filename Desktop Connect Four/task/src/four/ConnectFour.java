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

        JPanel content = new JPanel();
        content.setLayout(new GridLayout(game.rows, game.columns));

        for (int i = 0; i < game.rows; i++) {
            for (int j = 0; j < game.columns; j++) {
                Button button = new Button(" ", i, j);
                button.setFocusPainted(false);
                button.setName("Button" + (char) (65 + j) + (game.columns - i - 1));
                button.addActionListener(this);
//                if ((i + j) % 2 == 0) {
//                    button.setBackground(new Color(156, 204, 101));
//                } else {
                    button.setBackground(new Color(175, 213, 130));
//                }
                game.field[i][j] = button;
                content.add(button);
            }
        }

        setLayout(new BorderLayout());
        add(content, BorderLayout.CENTER);

        JButton reset = new JButton("Reset");
        reset.addActionListener(this);
        reset.setBackground(new Color(255, 213, 80));
        reset.setName("ButtonReset");
        add(reset, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setVisible(true);
        setTitle("Connect Four");
    }

    void reset() {
        player = "X";
        game.endGame = false;
        for (int i = 0; i < game.rows; i++) {
            for (int j = 0; j < game.columns; j++) {
//                if ((i + j) % 2 == 0) {
//                    game.field[i][j].setBackground(new Color(156, 204, 101));
//                } else {
                    game.field[i][j].setBackground(new Color(175, 213, 130));
//                }
                game.field[i][j].player = 0;
                game.field[i][j].setText(" ");
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String action = actionEvent.getActionCommand();
        if (Objects.equals(action, "Reset")) {
            reset();
        } else if (!game.endGame && !Objects.equals(action, "X") && !Objects.equals(action, "O")) {
            Button button = (Button) actionEvent.getSource();
            button = game.setTurn(button.column, Objects.equals(player, "X") ? 1 : -1);
            if (!Objects.isNull(button)) {
                button.setText(player);
                changePlayer();
            }
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