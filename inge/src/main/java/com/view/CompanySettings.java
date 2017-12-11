package com.view;

import com.Control.Control;
import com.model.Company;
import com.model.Singleton;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

import static com.view.app.company;
import static com.view.app.goToApp;
import static com.view.app.user;

/**
 * Created by martina on 12/7/17.
 */
public class CompanySettings {
    private JFrame frame;
    public JPanel panel;
    public JScrollPane srcPane;

    private JTextField name;
    private JTextField email;
    private JTextField province;
    private JTextField department;
    private JTextField address;
    private JTextField zip;
    private JTextField phone;
    private JTextField serviceIncoterms;
    private JTextField loadType;

    private JComboBox country;
    private JComboBox serviceRange;
    private JComboBox serviceType;
    private JComboBox serviceCharacteristics;
    private JComboBox serviceIncludes;
    private JComboBox transportContainer;
    private JComboBox transportType;
    private JComboBox loadSize;

    private JButton saveBtn;
    private JButton cancelButton;
    private JButton deleteBtn;

    private JPasswordField passwordCreation;
    private JPasswordField passwordConfirmation;

    public CompanySettings(JFrame frame){
        this.frame = frame;

        initOptions();

        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!incorrectInput()) {
                    Control.updateCompany(company.getUsername(),name.getText(), email.getText(), String.valueOf(passwordCreation.getPassword()).equals("")?"":Singleton.hash(String.valueOf(passwordCreation.getPassword())), country.getSelectedItem().toString(), province.getText(), department.getText(), address.getText(), zip.getText(),  phone.getText(), serviceRange.getSelectedItem().toString(), serviceType.getSelectedItem().toString(), serviceCharacteristics.getSelectedItem().toString(), serviceIncoterms.getText(), serviceIncludes.getSelectedItem().toString(),transportContainer.getSelectedItem().toString(), transportType.getSelectedItem().toString(), loadSize.getSelectedItem().toString(), loadType.getText());
                    goToApp(frame);
                }
                else
                    JOptionPane.showMessageDialog(null, "All information must be inserted and new password must match confirmation.");
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                goToApp(frame);
            }
        });

        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Control.deleteCompany(company.getUsername());
                company = null;
                goToApp(frame);
            }
        });
    }

    public void initOptions(){
        name.setText(company.getName());
        email.setText(company.getEmail());

        initCountries();
        country.setSelectedItem(company.getLocation().getCountry());
        province.setText(company.getLocation().getProvince());
        department.setText(company.getLocation().getCity());
        address.setText(company.getLocation().getAddress());
        zip.setText(company.getLocation().getZipCode());
        phone.setText(company.getPhoneNum());

        serviceRange.addItem("International");
        serviceRange.addItem("National");
        serviceRange.setSelectedItem(company.getServiceRange().toString());

        serviceType.addItem("Importation");
        serviceType.addItem("Exportation");
        serviceType.setSelectedItem(company.getServiceType());

        serviceCharacteristics.addItem("Door to door");
        serviceCharacteristics.addItem("Deliver at terminal");
        serviceCharacteristics.addItem("Deliver at deposit");
        serviceCharacteristics.setSelectedItem(company.getServiceCharacteristics());

        serviceIncludes.addItem("Transport of dangerous packages");
        serviceIncludes.addItem("Loading services");
        serviceIncludes.addItem("Customs management");
        serviceIncludes.addItem("Preboarding customs inspection");
        serviceIncludes.addItem("Tracking services");
        serviceIncludes.addItem("Local control agencies");
        serviceIncludes.addItem("Insurance");
        serviceIncludes.setSelectedItem(company.getServiceIncludes());

        serviceIncoterms.setText(company.getServiceIncoterms());

        transportContainer.addItem("FCL");
        transportContainer.addItem("LCL");
        transportContainer.setSelectedItem(company.getTransportContainer());

        transportType.addItem("Air");
        transportType.addItem("Sea");
        transportType.addItem("Ground");
        transportType.setSelectedItem(company.getTransportType());

        loadSize.addItem("Small");
        loadSize.addItem("Medium");
        loadSize.addItem("Large");
        loadSize.addItem("Oversized");
        loadSize.setSelectedItem(company.getLoadSize());

        loadType.setText(company.getLoadType());
    }

    public void initCountries() {
        String[] locales = Locale.getISOCountries();

        for (String countryCode : locales) {
            Locale obj = new Locale("", countryCode);
            country.addItem(obj.getDisplayCountry(Locale.ENGLISH));
        }
    }

    private boolean incorrectInput() {
        return name.getText().equals("") || address.getText().equals("") || zip.getText().equals("") || email.getText().equals("") || phone.getText().equals("") || province.getText().equals("") || department.getText().equals("") || !String.valueOf(passwordConfirmation.getPassword()).equals(String.valueOf(passwordCreation.getPassword()));
    }
    /*
    public static void main(String[] args) {
        Singleton.init();
        JFrame frame = new JFrame("Company Settings");
        frame.setContentPane(new CompanySettings(frame).panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();
    }
    */
}
