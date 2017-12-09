package com.view;

import com.model.Control;
import com.model.Singleton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class SignUpCompany {
    private JFrame frame;
    public JPanel panel1;
    private JComboBox country;
    private JTextField province;
    private JTextField address;
    private JTextField zip;
    private JTextField characteristics;
    private JTextField phone;
    private JComboBox service_type;
    private JTextField incoterms;
    private JTextField pkgsize;
    private JTextField transportType;
    private JTextField containerType;
    private JTextField email;
    private JPasswordField password;
    private JTextField name;
    private JComboBox pkgType;
    private JButton signUpButton;
    private JTextField username;
    private JTextField department;
    private JButton cancelButton;

    public SignUpCompany(JFrame frame) {

        this.frame = frame;

        initCountries();
        initOptions();

        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ret = Control.signUpCompany(username.getText(),password.getSelectedText(),name.getText(),email.getText(),containerType.getText(),transportType.getText(),pkgsize.getText(),pkgType.getSelectedItem().toString(),phone.getText(),service_type.getSelectedItem().toString(),characteristics.getText(),incoterms.getText(),"servicios incluidos",country.getSelectedItem().toString(),province.getText(),department.getText(),address.getText(),zip.getText());
                System.out.println(ret);
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
        service_type.addItem("Container.");
        pkgType.addItem("Buen paquete.");
    }

    public void initCountries(){
        String[] locales = Locale.getISOCountries();

        for (String countryCode : locales) {
            Locale obj = new Locale("", countryCode);
            country.addItem(obj.getDisplayCountry(Locale.ENGLISH));
        }
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
