package com.view;

import com.Control.Control;
import com.model.Singleton;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.util.Locale;

import static com.view.Search.goToSearch;
import static com.view.app.company;
import static com.view.app.goToApp;
import static com.view.app.user;

/**
 * Created by martina on 12/7/17.
 */
public class UserSettings {
    private JFrame frame;

    public JPanel panel;

    private JTextField address;
    private JTextField zip;
    private JTextField telephoneNumber;
    private JTextField name;
    private JTextField email;
    private JTextField province;
    private JTextField department;

    private JPasswordField passwordConfirmation;
    private JPasswordField passwordCreation;

    private JComboBox country;

    private JButton cancelBtn;
    private JButton saveBtn;
    private JButton deleteBtn;

    public UserSettings(JFrame frame) {
        this.frame = frame;

        initOptions();

        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!incorrectInput()) {
                    Control.updateUser(user.getUsername(), String.valueOf(passwordCreation.getPassword()).equals("")?"":Singleton.hash(String.valueOf(passwordCreation.getPassword())), email.getText(), country.getSelectedItem().toString(), province.getText(), department.getText(), address.getText(), zip.getText(), telephoneNumber.getText(), name.getText());
                    goToSearch(frame);
                }
                else
                    JOptionPane.showMessageDialog(null, "All information must be inserted and new password must match confirmation.");
            }
        });

        cancelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                goToSearch(frame);
            }
        });


        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Control.deleteClient(user.getUsername());
                user = null;
                goToApp(frame);
            }
        });
    }

    public void initOptions(){
        name.setText(user.getName());
        email.setText(user.getEmail());

        initCountries();

        country.setSelectedItem(user.getLocation().getCountry());
        province.setText(user.getLocation().getProvince());
        department.setText(user.getLocation().getCity());
        address.setText(user.getLocation().getAddress());
        zip.setText(user.getLocation().getZipCode());
        telephoneNumber.setText(user.getPhoneNum());
    }

    public void initCountries() {
        String[] locales = Locale.getISOCountries();

        for (String countryCode : locales) {
            Locale obj = new Locale("", countryCode);
            country.addItem(obj.getDisplayCountry(Locale.ENGLISH));
        }
    }

    private boolean incorrectInput() {
       return name.getText().equals("") || address.getText().equals("") || zip.getText().equals("") || email.getText().equals("") || telephoneNumber.getText().equals("") || province.getText().equals("") || department.getText().equals("") || !String.valueOf(passwordConfirmation.getPassword()).equals(String.valueOf(passwordCreation.getPassword()));
    }
    /*
    public static void main(String[] args) {
        Singleton.init();
        JFrame frame = new JFrame("User Settings");
        frame.setContentPane(new UserSettings(frame).panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();
    }
    */
}
