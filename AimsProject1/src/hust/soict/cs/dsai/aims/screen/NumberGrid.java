package hust.soict.cs.dsai.aims.screen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberGrid extends JFrame {

    private static final long serialVersionUID = 1L;

    public NumberGrid() {
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(10, 10, 5, 5));

        for (int i = 1; i <= 100; i++) {
            JButton btn = new JButton(String.valueOf(i));
            btn.addActionListener(new ButtonListener());
            cp.add(btn);
        }

        setTitle("Number Grid");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton src = (JButton) e.getSource();
            System.out.println("Button " + src.getText() + " clicked");
        }
    }

    public static void main(String[] args) {
        new NumberGrid();
    }
}
