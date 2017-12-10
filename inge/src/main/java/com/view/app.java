package com.view;

import com.Control.Control;
import com.model.Login;
import com.model.Singleton;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Andres on 03/12/2017.
 */
public class app extends JFrame{
    public static JFrame appFrame;
    public JPanel panel1;
    private JTextField username;
    private JPasswordField password;
    private JButton signUpAsClientButton;
    private JButton signUpAsCompanyButton;
    private JButton logInButton;

    public app(JFrame frame) {
        appFrame = frame;

        logInButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Login ret = com.Control.Control.login(username.getText(), String.valueOf(password.getPassword()));
                JFrame aux;
                switch (ret){
                    case FAIL:
                        JOptionPane.showMessageDialog(appFrame, "Failed authentication.");
                        break;
                    case CLIENT:
                        aux = new JFrame("Search companies");
                        aux.setContentPane(new Search(aux).panel);
                        aux.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                        aux.pack();
                        appFrame.setVisible(false);
                        aux.setVisible(true);
                        break;
                    case COMPANY:
                        aux = new JFrame("Edit Company");
                        aux.setContentPane(new CompanySettings(aux).panel);
                        aux.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                        aux.pack();
                        appFrame.setVisible(false);
                        aux.setVisible(true);
                }
            }
        });

        signUpAsClientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame aux = new JFrame("Sign up as client");
                aux.setContentPane(new SignUpClient(aux).singUp);
                aux.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                aux.pack();
                appFrame.setVisible(false);
                aux.setVisible(true);
            }
        });

        signUpAsCompanyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame aux = new JFrame("Sign up as company");
                aux.setContentPane(new SignUpCompany(aux).panel1);
                aux.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                aux.pack();
                appFrame.setVisible(false);
                aux.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        Singleton.init();
        appFrame = new JFrame("app");
        appFrame.setContentPane(new app(appFrame).panel1);
        appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        appFrame.pack();
        appFrame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
