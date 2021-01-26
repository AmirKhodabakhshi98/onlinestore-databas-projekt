package view;

import controllers.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminProductSearch extends JPanel implements ActionListener {

    private JLabel lblKeyword = new JLabel("Keyword");
    private JTextField tfKeyword = new JTextField();
    private Controller controller;
    private JRadioButton rbId = new JRadioButton("Id");
    private JRadioButton rbSupplier = new JRadioButton("Supplier");
    private JRadioButton rbName = new JRadioButton("Product Name");
    private JPanel panelButtons = new JPanel();
    private JButton btnSearch = new JButton("Search");
    private ButtonGroup group;
    private AdminProductMenu apm;

    public AdminProductSearch(Controller controller, AdminProductMenu apm){

        this.apm=apm;
        this.controller=controller;
        setLayout(new GridLayout(3,2));
        add(lblKeyword);
        add(tfKeyword);
        add(rbId);
        add(rbName);
        add(rbSupplier);
        add(btnSearch);

        group = new ButtonGroup();
        group.add(rbId);
        group.add(rbName);
        group.add(rbSupplier);

        rbId.addActionListener(this);
        rbName.addActionListener(this);
        rbSupplier.addActionListener(this);
        btnSearch.addActionListener(this);



    }


    //uppdatera med metoder när de finns
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==btnSearch){
            if (rbName.isSelected()){
                JOptionPane.showMessageDialog(null,"name");
                //kalla metod här
                apm.updateTable(); //fylla in med returdata här
                tfKeyword.setText(null);
            }
            else if (rbId.isSelected()){
                JOptionPane.showMessageDialog(null,"id");
                //kalla metod här
                apm.updateTable(); //fylla in med returdata här
                tfKeyword.setText(null);

            }
            else if (rbSupplier.isSelected()){
                JOptionPane.showMessageDialog(null,"supply");
                //kalla metod här
                apm.updateTable(); //fylla in med returdata här
                tfKeyword.setText(null);
            }
            else JOptionPane.showMessageDialog(null, "Please select a button");

        }
    }



}
