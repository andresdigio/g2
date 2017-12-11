package com.view;

import com.Control.Control;
import com.model.Singleton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

import static com.view.app.goToApp;

public class SignUpCompany {
    private JFrame frame;
    public JPanel panel1;
    public JScrollPane srcPane;

    private JTextField name;
    private JTextField email;
    private JTextField username;
    private JPasswordField creationPassword;
    private JPasswordField confirmationPassword;

    private JComboBox country;
    private JTextField province;
    private JTextField department;
    private JTextField address;
    private JTextField zip;
    private JTextField phone;

    private JComboBox serviceRange;
    private JComboBox serviceType;
    private JComboBox serviceCharacteristics;
    private JComboBox serviceIncludes;
    private JTextField serviceIncoterms;

    private JComboBox transportContainer;
    private JComboBox transportType;

    private JComboBox loadSize;
    private JTextField loadType;

    private JButton signUpButton;
    private JButton cancelButton;

    public SignUpCompany(JFrame frame) {

        this.frame = frame;

        initOptions();

        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!incorrectInput()) {
                    int ret = Control.signUpCompany(username.getText(),name.getText(), email.getText(), Singleton.hash(String.valueOf(creationPassword.getPassword())), country.getSelectedItem().toString(), province.getText(), department.getText(), address.getText(), zip.getText(),  phone.getText(), serviceRange.getSelectedItem().toString(), serviceType.getSelectedItem().toString(), serviceCharacteristics.getSelectedItem().toString(), serviceIncoterms.getText(), serviceIncludes.getSelectedItem().toString(),transportContainer.getSelectedItem().toString(), transportType.getSelectedItem().toString(), loadSize.getSelectedItem().toString(), loadType.getText());
                    System.out.println(ret);
                    goToApp(frame);
                }
                else
                    JOptionPane.showMessageDialog(null, "All information must be inserted and confirmation password must match password");
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                goToApp(frame);
            }
        });


    }

    public void initOptions(){
        initCountries();

        serviceRange.addItem("International");
        serviceRange.addItem("National");

        serviceType.addItem("Importation");
        serviceType.addItem("Exportation");

        serviceCharacteristics.addItem("Door to door");
        serviceCharacteristics.addItem("Deliver at terminal");
        serviceCharacteristics.addItem("Deliver at deposit");

        serviceIncludes.addItem("Transport of dangerous packages");
        serviceIncludes.addItem("Loading services");
        serviceIncludes.addItem("Customs management");
        serviceIncludes.addItem("Preboarding customs inspection");
        serviceIncludes.addItem("Tracking services");
        serviceIncludes.addItem("Local control agencies");
        serviceIncludes.addItem("Insurance");

        transportContainer.addItem("FCL");
        transportContainer.addItem("LCL");

        transportType.addItem("Air");
        transportType.addItem("Sea");
        transportType.addItem("Ground");

        loadSize.addItem("Small");
        loadSize.addItem("Medium");
        loadSize.addItem("Large");
        loadSize.addItem("Oversized");
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
