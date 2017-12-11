package com.view;

import com.model.User;
import com.model.Company;
import com.model.Singleton;
import com.model.Login;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Andres on 03/12/2017.
 */
public class app extends JFrame{
    private static JFrame appFrame;
    public JPanel panel1;
    private JTextField username;
    private JPasswordField password;
    private JButton signUpAsClientButton;
    private JButton signUpAsCompanyButton;
    private JButton logInButton;
    public static User user;
    public static Company company;

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
                        aux = new JFrame("G2 - Logistics");
                        aux.setContentPane(new Search(aux).panel);
                        aux.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                        aux.pack();
                        appFrame.setVisible(false);
                        aux.setVisible(true);
                        break;
                    case COMPANY:
                        aux = new JFrame("G2 - Logistics");
                        aux.setContentPane(new CompanySettings(aux).srcPane);
                        aux.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                        aux.pack();
                        appFrame.setVisible(false);
                        aux.setVisible(true);
                }
            }
        });

        signUpAsClientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame aux = new JFrame("G2 - Logistics");
                aux.setContentPane(new SignUpClient(aux).singUp);
                aux.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                aux.pack();
                appFrame.setVisible(false);
                aux.setVisible(true);
            }
        });

        signUpAsCompanyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame aux = new JFrame("G2 - Logistics");
                aux.setContentPane(new SignUpCompany(aux).srcPane);
                aux.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                aux.pack();
                appFrame.setVisible(false);
                aux.setVisible(true);
            }
        });
    }

    public static void goToApp(JFrame frame){
        JFrame aux = new JFrame("G2 - Logistics");
        aux.setContentPane(new app(aux).panel1);
        aux.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        aux.pack();
        frame.setVisible(false);
        aux.setVisible(true);
    }

    public static void main(String[] args) {
        Singleton.init();
        appFrame = new JFrame("G2 - Logistics");
        appFrame.setContentPane(new app(appFrame).panel1);
        appFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        appFrame.pack();
        appFrame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
