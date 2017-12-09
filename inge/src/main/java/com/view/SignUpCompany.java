package com.view;

import com.model.Control;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class SignUpCompany {
    private JFrame frame;
    public JPanel panel1;

    private JTextField name;
    private JTextField email;
    private JTextField username;
    private JTextField department;
    private JTextField incoterms;
    private JTextField pkgsize;
    private JTextField province;
    private JTextField address;
    private JTextField zip;
    private JTextField phone;

    private JPasswordField creationPassword;
    private JPasswordField confirmationPassword;

    private JComboBox country;
    private JComboBox characteristics;
    private JComboBox service_type;
    private JComboBox transportType;
    private JComboBox containerType;
    private JComboBox pkgType;

    private JButton signUpButton;
    private JButton cancelButton;

    public SignUpCompany(JFrame frame) {

        this.frame = frame;

        initCountries();
        initOptions();

        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!incorrectInput()) {
                    int ret = Control.signUpCompany(username.getText(), creationPassword.getSelectedText(), name.getText(), email.getText(), containerType.getSelectedItem().toString(), transportType.getSelectedItem().toString(), pkgsize.getText(), pkgType.getSelectedItem().toString(), phone.getText(), service_type.getSelectedItem().toString(), characteristics.getSelectedItem().toString(), incoterms.getText(), "servicios incluidos", country.getSelectedItem().toString(), province.getText(), department.getText(), address.getText(), zip.getText());
                    System.out.println(ret);
                    goToApp();
                }
                else
                    JOptionPane.showMessageDialog(null, "All information must be inserted and confirmation password must match password");
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                goToApp();
            }
        });


    }

    private void goToApp() {
        JFrame aux = new JFrame("app");
        aux.setContentPane(new app(aux).panel1);
        aux.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        aux.pack();
        frame.setVisible(false);
        aux.setVisible(true);
    }

    public void initOptions(){
        service_type.addItem("Importation");
        service_type.addItem("Exportation");

        pkgType.addItem("International");
        pkgType.addItem("National");

        characteristics.addItem("Door to door");
        characteristics.addItem("Deliver at terminal");
        characteristics.addItem("Deliver at deposit");

        containerType.addItem("FCL");
        containerType.addItem("LCL");

        transportType.addItem("Air");
        transportType.addItem("Sea");
        transportType.addItem("Ground");


    }

    public void initCountries(){
        String[] locales = Locale.getISOCountries();

        for (String countryCode : locales) {
            Locale obj = new Locale("", countryCode);
            country.addItem(obj.getDisplayCountry(Locale.ENGLISH));
        }
    }

    private boolean incorrectInput() {
        return name.getText().equals("") || username.getText().equals("") || address.getText().equals("") || zip.getText().equals("") || email.getText().equals("") || phone.getText().equals("") || province.getText().equals("") || department.getText().equals("") || !String.valueOf(confirmationPassword.getPassword()).equals(String.valueOf(creationPassword.getPassword()));
    }

//    public static void main(String ... args){
//        Singleton.init();
//        //SignUpCompany s = new SignUpCompany();
//        JFrame frame = new JFrame("SignUpCompany");
//
//        frame.setContentPane(s.panel1);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setVisible(true);
//        frame.pack();
//    }
}
