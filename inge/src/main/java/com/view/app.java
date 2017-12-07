package com.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Andres on 03/12/2017.
 */
public class app {
    private JPanel panel1;
    private JButton button1;
    private JTextField username;
    private JTextField password;
    private JTextArea signIn;

    public app() {
        button1 = new JButton();
        username = new JTextField();
        password = new JTextField();

        username.setToolTipText("Username");
        password.setToolTipText("Password");

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                com.model.Control.login(username.getText(), password.getText());
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("app");
        frame.setContentPane(new app().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
