package com.view;

import com.model.Company;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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
    private DefaultListModel<Company> model;
    private static Company chosen;
    private List<Company> companies;

    public Search(JFrame frame) {
        this.frame = frame;

        model = new DefaultListModel<>();

        list.setModel(model);
        companies = getCompanies();

        for (Company c: companies)
            model.addElement(c);

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

    //    public static void main(String[] args) {
//       SwingUtilities.invokeLater(() -> new Search());
//        Singleton.init();
//        JFrame frame = new JFrame("Search Companies");
//        frame.setContentPane(new Search().panel);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setVisible(true);
//        frame.pack();
//    }
}
