package view;

import controllers.Controller;
import database.Connection;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.AbstractBorder;

public class BrowsePanel extends JFrame implements ActionListener {

    private Controller controller;

    private JTable table;
    private String[] columnNames = {"ID", "Supplier", "Name", "Base Price", "Quantity"};

    private JPanel pnlLeft = new JPanel();
    private JPanel pnlButtons = new JPanel();
    private JPanel pnlRight= new JPanel();

    private JRadioButton rbId = new JRadioButton("Id");
    private JRadioButton rbSupplier = new JRadioButton("Supplier");
    private JRadioButton rbName = new JRadioButton("Product Name");
    private JButton btnSearch = new JButton("Search");
    private JButton btnStartingMenu = new JButton("Starting Menu");
    private ButtonGroup group;

    private JLabel lblKeyword = new JLabel("Keyword");
    private JTextField tfKeyword = new JTextField();

    //Class that handles unregistered users browsing

    public BrowsePanel(Controller controller){
        this.controller=controller;
   //     setLayout(new GridLayout(1,2));
        setLayout(new BorderLayout());


        group = new ButtonGroup();
        group.add(rbId);
        group.add(rbName);
        group.add(rbSupplier);

        btnSearch.addActionListener(this);
        btnStartingMenu.addActionListener(this);

        pnlRight.setLayout(new GridLayout(3,2));
        pnlRight.add(lblKeyword);
        pnlRight.add(tfKeyword);
        pnlRight.add(rbId);
        pnlRight.add(rbName);
        pnlRight.add(rbSupplier);
        pnlRight.add(btnSearch);

        table = new JTable(controller.getProducts(),columnNames);
        table.setEnabled(false);

        pnlLeft.setLayout(new BorderLayout());
        pnlLeft.add(new JScrollPane(table),BorderLayout.CENTER);
        pnlLeft.add(btnStartingMenu,BorderLayout.SOUTH);
        pnlButtons.setLayout(new GridLayout(1,5));


        add(pnlLeft,BorderLayout.CENTER);
        add(pnlRight,BorderLayout.SOUTH);
        setSize(900,500);
        setLocationRelativeTo(null);
        setVisible(true);


    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==btnSearch){
            //command here
        }
        if (e.getSource()==btnStartingMenu){
            this.dispose();
            new StartingMenu(controller);
        }
    }

}
