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
    private JButton contactButton;
    private JButton logOutButton;
    private JComboBox countryCB;
    private JComboBox rangeCB;
    private JComboBox containerCB;
    private JComboBox transportCB;
    private JComboBox characteristicsCB;
    private JComboBox serviceCB;
    private JButton searchBtn;
    private DefaultListModel<Company> model;
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
                    if(containerCB.getSelectedItem() != "ANY" && c.getContainer_type() != containerCB.getSelectedItem()) {
                        model.removeElement(c);
                    }
                    if(transportCB.getSelectedItem() != "ANY" && c.getTransport() != transportCB.getSelectedItem()) {
                        model.removeElement(c);
                    }
                    if(countryCB.getSelectedItem() != "ANY" && c.getLocation().getCountry() != countryCB.getSelectedItem()) {
                        model.removeElement(c);
                    }
                    if(serviceCB.getSelectedItem() != "ANY" && c.getService_type() != serviceCB.getSelectedItem()) {
                        model.removeElement(c);
                    }
                    if(rangeCB.getSelectedItem() != "ANY" && c.getLoad_type() != rangeCB.getSelectedItem()) {
                        model.removeElement(c);
                    }
                    if(characteristicsCB.getSelectedItem() != "ANY" && c.getService_description() != characteristicsCB.getSelectedItem()) {
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
        countryCB.addItem("ANY");
        String[] locales = Locale.getISOCountries();
        for (String countryCode : locales) {
            Locale obj = new Locale("", countryCode);
            countryCB.addItem(obj.getDisplayCountry(Locale.ENGLISH));
        }

        serviceCB.addItem("ANY");
        serviceCB.addItem("Importation");
        serviceCB.addItem("Exportation");

        rangeCB.addItem("ANY");
        rangeCB.addItem("International");
        rangeCB.addItem("National");

        characteristicsCB.addItem("ANY");
        characteristicsCB.addItem("Door to door");
        characteristicsCB.addItem("Deliver at terminal");
        characteristicsCB.addItem("Deliver at deposit");

        containerCB.addItem("ANY");
        containerCB.addItem("FCL");
        containerCB.addItem("LCL");

        transportCB.addItem("ANY");
        transportCB.addItem("Air");
        transportCB.addItem("Sea");
        transportCB.addItem("Ground");

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
