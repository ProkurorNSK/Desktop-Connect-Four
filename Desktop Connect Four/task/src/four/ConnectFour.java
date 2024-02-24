package four;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class ConnectFour extends JFrame implements ActionListener {
    String player = "X";
    public ConnectFour() {
        int rows = 6;
        int columns = 7;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                JButton jButton = new JButton(" ");
                jButton.setFocusPainted(false);
                jButton.setName("Button" + (char) (65 + j) + (columns - i - 1));
                jButton.addActionListener(this);
                add(jButton);
            }
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setVisible(true);
        setLayout(new GridLayout(rows, columns));
        setTitle("Connect Four");
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JButton jButton = (JButton) actionEvent.getSource();
        jButton.setText(player);
        changePlayer();
    }

    private void changePlayer() {
        if (Objects.equals(player, "X")) {
            player = "O";
        } else {
            player = "X";
        }
    }
}