package com.view;

import com.model.Control;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by martina on 12/7/17.
 */
public class SignUpClient {
    JFrame frame;
    public JPanel singUp;
    private JTextField name;
    private JTextField username;
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

        //TODO necesito inputs de los datos que estan en el comentario de la linea 35 y pasarlos asi como parametros.
        btSingUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Control.signUpClient(username, pass, email, country, province, department, address, zip, tel_number, name);
            }
        });
    }

}
