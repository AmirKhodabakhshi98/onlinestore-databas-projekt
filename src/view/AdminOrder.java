package view;

import controllers.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminOrder extends JFrame implements ActionListener {

    private Controller controller;
    private JTable table;
    private JPanel pnlSouth;
    private JLabel lblId = new JLabel("Order Id");
    private JTextField tfId = new JTextField();
    private JButton btnConfirm = new JButton("Confirm Order");
    private String[] columnNames = {"Order ID", "Confirmed", "Date", "Time"};
    private JButton btnMenu =  new JButton("Main Menu");

    //Admin order gui where they can interact with orders
    public AdminOrder(Controller controller){

        this.controller=controller;
        pnlSouth = new JPanel();
        pnlSouth.setLayout(new GridLayout(1,4));

        setSize(800,500);
        setLocationRelativeTo(null);
        setTitle("Admin Order Menu");
      //  setLayout(new GridLayout(1,2));

        String[] test = {"1","true","idag","förra timmen"};
        String[][] test2 = new String[1][];
        test2[0]= test;
        table = new JTable(test2,columnNames); //lägga in orders här
        table.setEnabled(false);
        add(new JScrollPane(table),BorderLayout.CENTER);

        pnlSouth.add(btnMenu);
        pnlSouth.add(lblId);
        pnlSouth.add(tfId);
        pnlSouth.add(btnConfirm);
        pnlSouth.setSize(500,100);
        btnConfirm.addActionListener(this);

        add(pnlSouth,BorderLayout.SOUTH);

        btnConfirm.addActionListener(this);
        btnMenu.addActionListener(this);

        setVisible(true);

    }


    //Method to refresh the table
    private void updateTable(){
        this.getContentPane().remove(table);
        table= new JTable(controller.getProducts(), columnNames);
        add(new JScrollPane(table), BorderLayout.CENTER);
        revalidate();

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==btnConfirm){

            //Kalla på metod här
            tfId.setText(null);
            updateTable();
        }
        if (e.getSource()==btnMenu){
            this.dispose();
            new AdminMenu(controller);
        }
    }
}
