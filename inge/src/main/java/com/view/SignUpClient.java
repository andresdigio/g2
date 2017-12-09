package com.view;

import com.model.Control;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

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
    private JPasswordField passwordCreation;
    private JPasswordField passwordConfirmation;
    private JComboBox city;
    private JComboBox province;
    private JComboBox country;
    private JButton btSingUp;
    private JButton btCancel;

    public SignUpClient(JFrame frame) {

        this.frame = frame;

        initCountries();
        initOptions();

        //TODO necesito inputs de los datos que estan en el comentario de la linea 35 y pasarlos asi como parametros.
        btSingUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(String.valueOf(passwordConfirmation.getPassword()));
                System.out.println(String.valueOf(passwordCreation.getPassword()));
                if(String.valueOf(passwordConfirmation.getPassword()).equals(String.valueOf(passwordCreation.getPassword())))
                    Control.signUpClient(username.getText(), String.valueOf(passwordCreation.getPassword()), email.getText(), country.getSelectedItem().toString(), province.getSelectedItem().toString(), city.getSelectedItem().toString(), address.getText(), zipcode.getText(), telephoneNumber.getText(), name.getText());
                else {
                    JOptionPane.showMessageDialog(null, "Confirmation password must match password");
                }
            }
        });

        btCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("njdkjdal");
                JFrame aux = new JFrame("app");
                aux.setContentPane(new app(aux).panel1);
                aux.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                aux.pack();
                frame.setVisible(false);
                aux.setVisible(true);
            }
        });
    }

    public void initOptions(){
        province.addItem(new ComboItem("Buenos Aires", "1"));
        city.addItem(new ComboItem("Buenos Aires", "2"));

    }

    public void initCountries(){
        String[] locales = Locale.getISOCountries();

        for (String countryCode : locales) {
            Locale obj = new Locale("", countryCode);
            country.addItem(obj.getDisplayCountry(Locale.ENGLISH));
        }
    }

//    public static void main(String[] args) {
//        JFrame frame = new JFrame("SignUpClient");
//        frame.setContentPane(new SignUpClient().singUp);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.pack();
//        frame.setVisible(true);
//    }
}
