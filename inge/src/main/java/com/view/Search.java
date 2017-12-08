package com.view;

import com.model.Company;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created by martina on 12/7/17.
 */
public class Search {
    private JFrame frame;
    private JPanel panel;
    private JList<Company> list;
    private JButton button;
    private DefaultListModel<Company> model;
    private static Company chosen;
    private List<Company> companies;

    public Search() {
        frame = new JFrame("Search");
        list = new JList<Company>();
        panel = new JPanel();
        button = new JButton();
        model = new DefaultListModel<Company>();

        list.setModel(model);
        /*
        companies = getCompanies();
        for (Company c: companies)
            model.addElement(c);
        */
        model.addElement(new Company("Mertens"));
        model.addElement(new Company("Griezman"));
        list.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                chosen = list.getSelectedValue();
            }
        });

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(chosen == null)
                    JOptionPane.showMessageDialog(null, "Please select a company");
                else
                    JOptionPane.showMessageDialog(null,"This is the email of the company you've chosen:\n\n"
                    + chosen.getName() + "@gmail.com\n\nFeel free to contact them whenever you want!");

            }
        });

        panel.add(list);
        panel.add(button);

        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Search::new);
    }

    private class Empresa {
        private String name;
        private Integer number;

        public Empresa(String name, Integer number) {
            this.name = name;
            this.number = number;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getNumber() {
            return number;
        }

        public void setNumber(Integer number) {
            this.number = number;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
