package com.view;

import com.Control.Control;
import com.model.Singleton;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

import static com.view.app.goToApp;

/**
 * Created by martina on 12/7/17.
 */
public class SignUpClient {
    private JFrame frame;
    public JPanel singUp;

    private JTextField name;
    private JTextField username;
    private JTextField address;
    private JTextField zipcode;
    private JTextField email;
    private JTextField telephoneNumber;
    private JTextField province;
    private JTextField city;

    private JPasswordField passwordCreation;
    private JPasswordField passwordConfirmation;

    private JComboBox country;

    private JButton btSingUp;
    private JButton btCancel;

    public SignUpClient(JFrame frame) {

        this.frame = frame;

        initCountries();

        btSingUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ret = 1;
                if(!incorrectInput()){
                    ret = Control.signUpClient(username.getText(), Singleton.hash(String.valueOf(passwordCreation.getPassword())), email.getText(), country.getSelectedItem().toString(), province.getText(), city.getText(), address.getText(), zipcode.getText(), telephoneNumber.getText(), name.getText());
                    goToApp(frame);
                    if(ret == 0)
                        JOptionPane.showMessageDialog(null, "Invalid username :(");
                }else
                    JOptionPane.showMessageDialog(null, "All information must be inserted and confirmation password must match password");
            }
        });

        btCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                goToApp(frame);
            }
        });
    }



    public void initCountries(){
        String[] locales = Locale.getISOCountries();

        for (String countryCode : locales) {
            Locale obj = new Locale("", countryCode);
            country.addItem(obj.getDisplayCountry(Locale.ENGLISH));
        }
    }

    private boolean incorrectInput() {
        return name.getText().equals("") || username.getText().equals("") || address.getText().equals("") || zipcode.getText().equals("") || email.getText().equals("") || telephoneNumber.getText().equals("") || province.getText().equals("") || city.getText().equals("") || !String.valueOf(passwordConfirmation.getPassword()).equals(String.valueOf(passwordCreation.getPassword()));
    }

//    public static void main(String[] args) {
//        JFrame frame = new JFrame("SignUpClient");
//        frame.setContentPane(new SignUpClient().singUp);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.pack();
//        frame.setVisible(true);
//    }
}
