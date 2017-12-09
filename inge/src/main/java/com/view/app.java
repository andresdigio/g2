package com.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Andres on 03/12/2017.
 */
public class app extends JFrame{
    public static JFrame appFrame;
    public JPanel panel1;
    private JButton button1;
    private JTextField username;
    private JTextField password;
    private JTextArea signIn;
    private JButton signUpButton;

    public app(JFrame frame) {
        button1 = new JButton();
        username = new JTextField();
        password = new JTextField();

        appFrame = frame;

        username.setToolTipText("Username");
        password.setToolTipText("Password");

        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                com.model.Control.login(username.getText(), password.getText());
            }
        });

        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame aux = new JFrame("SignUpClient");
                aux.setContentPane(new SignUpClient(aux).singUp);
                aux.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                aux.pack();
                appFrame.setVisible(false);
                aux.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        appFrame = new JFrame("app");
        appFrame.setContentPane(new app(appFrame).panel1);
        appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        appFrame.pack();
        appFrame.setVisible(true);
    }
}
