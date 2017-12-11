package com.view;

import com.Control.Control;
import com.model.Company;
import com.model.Singleton;
import com.sun.xml.internal.ws.api.ha.StickyFeature;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Locale;

import static com.Control.Control.getCompanies;

/**
 * Created by martina on 12/7/17.
 */
public class Search {
    private JFrame frame;
    public JPanel panel;

    private JList<String> list;
    private DefaultListModel<String> model;

    private JButton contactButton;
    private JButton logOutButton;
    private JButton searchBtn;
    private JButton editProfileButton;

    private JComboBox country;
    private JComboBox serviceRange;
    private JComboBox transportContainer;
    private JComboBox transportType;
    private JComboBox serviceCharacteristics;
    private JComboBox serviceType;
    private JComboBox serviceIncludes;
    private JComboBox loadSize;

    private static String chosen;
    private static Company companyChosen;
    private List<Company> companies;

    public Search(JFrame frame) {
        this.frame = frame;

        model = new DefaultListModel<>();
        list.setModel(model);
        list.setFixedCellHeight(50);
        list.setBorder(new EmptyBorder(5,5, 5, 5));

        list.setFixedCellHeight(50);
        list.setBorder(new EmptyBorder(5,5,5,5));

        initCompanies();
        initFilters();

        list.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                chosen = list.getSelectedValue();
                for(Company c: companies) {
                    if(c.getName().equals(chosen))
                        companyChosen = c;
                }
            }
        });

        contactButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(chosen == null)
                    JOptionPane.showMessageDialog(null, "Please select a company");
                else {
                    JOptionPane.showMessageDialog(null, "This is the email of the company you've chosen:\n\n"
                            + companyChosen.getEmail() + "\n\nFeel free to contact them whenever you want!");
                    Control.contact(companyChosen.getUsername(),app.user.getUsername());
                }
            }
        });

        logOutButton.addActionListener(new ActionListener() {
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

        searchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(Company c: companies) {
                    if(!model.contains(c.getName()))
                        model.addElement(c.getName());
                }
                for(Company c: companies) {
                    if(country.getSelectedItem().toString() != "ANY" && c.getLocation().getCountry().equals(country.getSelectedItem().toString())) {
                        model.removeElement(c.getName());
                    }
                    if(serviceRange.getSelectedItem().toString() != "ANY" && c.getServiceRange().equals(serviceRange.getSelectedItem().toString())) {
                        model.removeElement(c.getName());
                    }
                    if(serviceType.getSelectedItem().toString() != "ANY" && c.getServiceType().equals(serviceType.getSelectedItem().toString())) {
                        model.removeElement(c.getName());
                    }
                    if(serviceCharacteristics.getSelectedItem().toString() != "ANY" && c.getServiceCharacteristics().equals(serviceCharacteristics.getSelectedItem().toString())) {
                        model.removeElement(c.getName());
                    }
                    if(serviceIncludes.getSelectedItem().toString() != "ANY" && c.getServiceIncludes().equals(serviceIncludes.getSelectedItem().toString())) {
                        model.removeElement(c.getName());
                    }
                    if(transportContainer.getSelectedItem().toString() != "ANY" && c.getTransportContainer().equals(transportContainer.getSelectedItem().toString())) {
                        model.removeElement(c.getName());
                    }
                    if(transportType.getSelectedItem().toString() != "ANY" && c.getTransportType().equals(transportType.getSelectedItem().toString())) {
                        model.removeElement(c.getName());
                    }
                    if(loadSize.getSelectedItem().toString() != "ANY" && c.getLoadSize().equals(loadSize.getSelectedItem().toString())) {
                        model.removeElement(c.getName());
                    }
                }
            }
        });

        editProfileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame aux = new JFrame("G2 - Logistics");
                aux.setContentPane(new UserSettings(aux).panel);
                aux.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                aux.pack();
                frame.setVisible(false);
                aux.setVisible(true);
            }
        });
    }

    public static void goToSearch(JFrame frame){
        JFrame aux = new JFrame("G2 - Logistics");
        aux.setContentPane(new Search(aux).panel);
        aux.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        aux.pack();
        frame.setVisible(false);
        aux.setVisible(true);
    }

    private void initCompanies() {
        companies = getCompanies();
        for (Company c: companies)
            model.addElement(c.getName());
    }

    public void initFilters(){
        country.addItem("ANY");
        String[] locales = Locale.getISOCountries();
        for (String countryCode : locales) {
            Locale obj = new Locale("", countryCode);
            country.addItem(obj.getDisplayCountry(Locale.ENGLISH));
        }

        serviceType.addItem("ANY");
        serviceType.addItem("Importation");
        serviceType.addItem("Exportation");

        serviceRange.addItem("ANY");
        serviceRange.addItem("International");
        serviceRange.addItem("National");

        serviceCharacteristics.addItem("ANY");
        serviceCharacteristics.addItem("Door to door");
        serviceCharacteristics.addItem("Deliver at terminal");
        serviceCharacteristics.addItem("Deliver at deposit");

        serviceIncludes.addItem("ANY");
        serviceIncludes.addItem("Transport of dangerous packages");
        serviceIncludes.addItem("Loading services");
        serviceIncludes.addItem("Customs management");
        serviceIncludes.addItem("Preboarding customs inspection");
        serviceIncludes.addItem("Tracking services");
        serviceIncludes.addItem("Local control agencies");
        serviceIncludes.addItem("Insurance");

        transportContainer.addItem("ANY");
        transportContainer.addItem("FCL");
        transportContainer.addItem("LCL");

        transportType.addItem("ANY");
        transportType.addItem("Air");
        transportType.addItem("Sea");
        transportType.addItem("Ground");

        loadSize.addItem("ANY");
        loadSize.addItem("Small");
        loadSize.addItem("Medium");
        loadSize.addItem("Large");
        loadSize.addItem("Oversized");
    }
}
