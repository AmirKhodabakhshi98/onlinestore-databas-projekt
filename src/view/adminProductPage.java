package view;

import controllers.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class adminProductPage extends JFrame {


    private JTable table;
    private Controller controller;
    private JTextArea textArea = new JTextArea();



    private JLabel lblEmpty = new JLabel();
    private JLabel lblId = new JLabel("ID");
    private JLabel lblQuantity = new JLabel("Quantity");
    private JTextField tfIdEdit = new JTextField();
    private JTextField tfQuantity = new JTextField();



    private String[] columnNames = {"ID", "Supplier", "Name", "Base Price", "Quantity"};


    private JPanel panelLeft = new JPanel();
    private JPanel panelRight = new JPanel();
    private JPanel editPanel = new JPanel();


    private CardLayout card;
    private Container c;
    private JButton btnEditMenu = new JButton("Edit menu");
    private JButton btnDeleteMenu = new JButton("Delete menu");
    private JButton btnOrderMenu = new JButton("Order menu");
    private JButton btnDiscountMenu = new JButton("Discount menu");
    private JButton btnMainMenu = new JButton("Main menu");
    public adminProductPage(Controller controller){
        this.controller=controller;
        setTitle("admin product page");
        setSize(1100,500);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(1,2));
        actionListener al = new actionListener();


        table= new JTable(controller.getProducts(), columnNames);
        table.setEnabled(false);    //Makes table not editable
        panelLeft.setLayout(new BorderLayout());
        panelLeft.add(new JScrollPane(table), BorderLayout.CENTER);




        btnEditMenu.addActionListener(al);
        btnDeleteMenu.addActionListener(al);
        btnOrderMenu.addActionListener(al);
        btnDiscountMenu.addActionListener(al);
        btnMainMenu.addActionListener(al);


        add(panelLeft);
        add(panelRight);

        setVisible(true);

    }

    private void updatePanel(JPanel panel){
        this.getContentPane().remove(panelRight);
        panelRight = new JPanel();
        panelRight.add(panel);
        this.getContentPane().add(panelRight);
    }

    private void updateTable(){
        table= new JTable(controller.getProducts(), columnNames);

    }

    private void editMenu(){

    }

    private void editProduct(){
    //
            controller.editProduct(Integer.parseInt(tfIdEdit.getText()), Integer.parseInt(tfQuantity.getText()));
            tfIdEdit.setText(null);
            tfQuantity.setText(null);
            updateTable();

    }

    private class EditPanel extends JPanel{

        JLabel lblEdit = new JLabel("Edit");

    }

    private class actionListener implements ActionListener {


        public void actionPerformed(ActionEvent e) {

            if (e.getSource()== btnEditMenu){

        //        updatePanel( );

            }

        }
    }

}
