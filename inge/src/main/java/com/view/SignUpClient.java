package com.view;

import javax.swing.*;

/**
 * Created by martina on 12/7/17.
 */
public class SignUpClient {
    private JPanel singUp;
    private JTextField firstName;
    private JTextField lastName;
    private JPasswordField passwordCreation;
    private JPasswordField passwordConfirmation;
    private JTextField address;
    private JTextField zipcode;
    private JTextField mobileNumber;
    private JTextField workNumber;
    private JComboBox city;
    private JComboBox province;
    private JComboBox country;
    private JButton btSingUp;
    private JButton btCancel;

    public SignUpClient() {
        firstName = new JTextField();
        lastName = new JTextField();
        passwordCreation = new JPasswordField();
        passwordConfirmation = new JPasswordField();
        address = new JTextField();
        zipcode = new JTextField();
        mobileNumber = new JTextField();
        workNumber = new JTextField();
        city = new JComboBox();
        province = new JComboBox();
        province = new JComboBox();
        country = new JComboBox();
        btSingUp = new JButton();
        btCancel = new JButton();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("SignUpClient");
        frame.setContentPane(new SignUpClient().singUp);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
