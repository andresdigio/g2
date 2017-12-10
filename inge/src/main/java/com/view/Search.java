package com.view;

import com.model.Company;
import com.model.Singleton;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Locale;

import static com.model.Control.getCompanies;

/**
 * Created by martina on 12/7/17.
 */
public class Search {
    private JFrame frame;
    public JPanel panel;

    private JList<Company> list;
    private DefaultListModel<Company> model;

    private JButton contactButton;
    private JButton logOutButton;
    private JButton searchBtn;

    private JComboBox country;
    private JComboBox serviceRange;
    private JComboBox transportContainer;
    private JComboBox transportType;
    private JComboBox serviceCharacteristics;
    private JComboBox serviceType;
    private JComboBox serviceIncludes;
    private JComboBox loadSize;

    private static Company chosen;
    private List<Company> companies;

    public Search(JFrame frame) {
        this.frame = frame;

        model = new DefaultListModel<>();
        list.setModel(model);

        initCompanies();
        initFilters();

        list.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                chosen = list.getSelectedValue();
            }
        });

        contactButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(chosen == null)
                    JOptionPane.showMessageDialog(null, "Please select a company");
                else
                    JOptionPane.showMessageDialog(null,"This is the email of the company you've chosen:\n\n"
                    + chosen.getName() + "@gmail.com\n\nFeel free to contact them whenever you want!");

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
                    if(!model.contains(c))
                        model.addElement(c);
                }
                for(Company c: companies) {
                    if(country.getSelectedItem() != "ANY" && c.getLocation().getCountry() != country.getSelectedItem()) {
                        model.removeElement(c);
                    }
                    if(serviceRange.getSelectedItem() != "ANY" && c.getServiceRange() != serviceRange.getSelectedItem()) {
                        model.removeElement(c);
                    }
                    if(serviceType.getSelectedItem() != "ANY" && c.getServiceType() != serviceType.getSelectedItem()) {
                        model.removeElement(c);
                    }
                    if(serviceCharacteristics.getSelectedItem() != "ANY" && c.getServiceCharacteristics() != serviceCharacteristics.getSelectedItem()) {
                        model.removeElement(c);
                    }
                    if(serviceIncludes.getSelectedItem() != "ANY" && c.getServiceIncludes() != serviceIncludes.getSelectedItem()) {
                        model.removeElement(c);
                    }
                    if(transportContainer.getSelectedItem() != "ANY" && c.getTransportContainer() != transportContainer.getSelectedItem()) {
                        model.removeElement(c);
                    }
                    if(transportType.getSelectedItem() != "ANY" && c.getTransportType() != transportType.getSelectedItem()) {
                        model.removeElement(c);
                    }
                    if(loadSize.getSelectedItem() != "ANY" && c.getLoadSize() != loadSize.getSelectedItem()) {
                        model.removeElement(c);
                    }
                }
            }
        });
    }

    private void initCompanies() {
        companies = getCompanies();
        for (Company c: companies)
            model.addElement(c);
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

    public static void main(String[] args) {
        Singleton.init();
        JFrame frame = new JFrame("Search Companies");
        frame.setContentPane(new Search(frame).panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();
    }
}
