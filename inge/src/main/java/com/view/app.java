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

    public app() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                com.model.Control.login(username.getText(), password.getText());
            }
        });
    }
}
