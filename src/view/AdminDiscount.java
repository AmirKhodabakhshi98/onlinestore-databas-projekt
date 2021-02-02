package view;

import controllers.Controller;
import database.Connection;
import model.Discount;
import model.Product;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminDiscount extends JFrame implements ActionListener {

    private Controller controller;
    private JTable table;
    private JPanel pnlRight = new JPanel();
    private JPanel pnlLeft = new JPanel();
    private JPanel pnlBtns = new JPanel();
    private JPanel pnlRightTop = new JPanel();
    private JPanel pnlRightBottom = new JPanel();

    private JLabel lblDiscountId = new JLabel("Discount ID");
    private JLabel lblDescription = new JLabel("Description");
    private JLabel lblPercentage = new JLabel("Discount %");
    private JLabel lblProductId = new JLabel("Product ID");
    private JLabel lblStartDate = new JLabel("Start YYYY-MM-DD HH:MI:SS");
    private JLabel lblEndDate = new JLabel("End YYYY-MM-DD HH:MI:SS");
    private JLabel lblEmpty = new JLabel("");



    private JTextField tfDiscountId = new JTextField();
    private JTextField tfProductId = new JTextField();
    private JTextField tfDescription = new JTextField();
    private JTextField tfPercentage = new JTextField();
    private JTextField tfStart = new JTextField();
    private JTextField tfEnd = new JTextField();

    private JButton btnNewDiscount = new JButton("Create Discount");
    private JButton btnDiscountToProduct = new JButton("Add discount to product");
    private JButton btnMain = new JButton("Main Menu");
    private JButton btnSeeDisc = new JButton("Discounts");
    private JButton btnSeeProd = new JButton("Discounted products");

    private String[] columnNames = {};


    //Class for admins gui interaction with discounts
    public AdminDiscount(Controller controller){
        this.setLayout(new GridLayout(1,2));
        this.controller=controller;
        setSize(900,500);
        setLocationRelativeTo(null);
        setTitle("Admin Discount Menu");

        Border borderRightTop = BorderFactory.createTitledBorder("Create new discount");
        Border borderRightBottom = BorderFactory.createTitledBorder("Add discount to a product");

        pnlBtns.setLayout(new GridLayout(1,3));
        pnlBtns.add(btnSeeDisc);
        pnlBtns.add(btnSeeProd);
        pnlBtns.add(btnMain);


        GridLayout gridLayout = new GridLayout(2,1);
        gridLayout.setVgap(20);
        pnlRight.setLayout(gridLayout);

        pnlRightTop.setLayout(new GridLayout(3,2));
        pnlRightTop.add(lblDescription);
        pnlRightTop.add(tfDescription);
        pnlRightTop.add(lblPercentage);
        pnlRightTop.add(tfPercentage);
        pnlRightTop.add(btnNewDiscount);
        pnlRightTop.setBorder(borderRightTop);

        pnlRightBottom.setLayout(new GridLayout(5,2));
        pnlRightBottom.add(lblProductId);
        pnlRightBottom.add(tfProductId);
        pnlRightBottom.add(lblDiscountId);
        pnlRightBottom.add(tfDiscountId);
        pnlRightBottom.add(lblStartDate);
        pnlRightBottom.add(tfStart);
        pnlRightBottom.add(lblEndDate);
        pnlRightBottom.add(tfEnd);
        pnlRightBottom.add(btnDiscountToProduct);
        pnlRightBottom.setBorder(borderRightBottom);


        table= new JTable(Product.getAllProducts(), columnNames);
        table.setEnabled(false);    //Makes table not editable

        pnlLeft.setLayout(new BorderLayout());
        pnlLeft.add(pnlBtns, BorderLayout.SOUTH);
        pnlLeft.add(new JScrollPane(table), BorderLayout.CENTER);

        pnlRight.add(pnlRightTop);
        pnlRight.add(pnlRightBottom);

        add(pnlLeft);
        add(pnlRight);

        btnDiscountToProduct.addActionListener(this);
        btnMain.addActionListener(this);
        btnNewDiscount.addActionListener(this);
        btnSeeDisc.addActionListener(this);
        btnSeeProd.addActionListener(this);


        setVisible(true);


    }


    public static void main(String[] args) {
        Connection.connect();
        new AdminDiscount(new Controller());
    }


    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==btnMain){
            this.dispose();
            new AdminMenu(controller);
        }
        if (e.getSource()==btnSeeDisc){
            //functionality to see all discounts




        }
        if (e.getSource()==btnSeeProd){
            //functionality to see all products w discount



        }




        if (e.getSource()==btnNewDiscount){
            try{
                int x = Integer.parseInt(tfPercentage.getText());

                Discount.addDiscounts(tfDescription.getText(), Integer.parseInt(tfPercentage.getText()));

                tfDescription.setText(null);
                tfPercentage.setText(null);

            }catch (NumberFormatException nfe){
                JOptionPane.showMessageDialog(null,"Percentage must be int");
            }



        }
        if (e.getSource()==btnDiscountToProduct){

            try{
                int x = Integer.parseInt(tfProductId.getText());
                x = Integer.parseInt(tfDiscountId.getText());


                Discount.addProductDiscount(Integer.parseInt(tfProductId.getText()), Integer.parseInt(tfDiscountId.getText()),
                        tfStart.getText(), tfEnd.getText());



                tfProductId.setText(null);
                tfDiscountId.setText(null);
                tfStart.setText(null);
                tfEnd.setText(null);
            }catch (NumberFormatException nfe){
                JOptionPane.showMessageDialog(null,"Percentage must be int");
            }


        }
    }
/*

            if (e.getSource() == buttonRegister){
                try{
                    int x = Integer.parseInt(tfNbr.getText());
                    register();
            }catch (NumberFormatException nfe){
                    JOptionPane.showMessageDialog(null,"Phonenumber must be integers only");


 */

}
