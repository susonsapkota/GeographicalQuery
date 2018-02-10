package com.googletest.main;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Main extends JFrame {
    public JTextField textField = new JTextField(44);
    private GoogleURL googleURL = new GoogleURL();
    private String nameOfPlace = "kathmandu";
    private JLabel label = new JLabel();
    private JPanel panel = new JPanel();
    private JButton button = new JButton("Search");


    public Main() {

        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

        panel.add(textField);
        panel.add(button);
        button.addMouseListener(new Event());

        setNewPlace(nameOfPlace);
        add(label);
        add(BorderLayout.NORTH, panel);


        pack();


    }

    public void setNewPlace(String nameOfPlace) {
        setTitle(nameOfPlace.toUpperCase());
        googleURL.downloadMap(nameOfPlace);
        label.setIcon(googleURL.getIcon(nameOfPlace));
        googleURL.deleteFile(nameOfPlace);
        add(BorderLayout.SOUTH, label);
    }

    public class Event implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {

            setNewPlace(textField.getText());
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

}
