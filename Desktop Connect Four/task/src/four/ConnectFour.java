package four;

import javax.swing.*;
import java.awt.*;

public class ConnectFour extends JFrame {
    public ConnectFour() {
        int rows = 6;
        int columns = 7;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                String indexName = String.valueOf((char) (65 + j)) + String.valueOf(columns - i - 1);
                JButton jButton = new JButton(indexName);
                jButton.setFocusPainted(false);
                jButton.setName("Button" + indexName);
                add(jButton);
            }
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setVisible(true);
        setLayout(new GridLayout(rows, columns));
        setTitle("Connect Four");
    }
}