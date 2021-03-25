package view;

import controllers.Controller;
import database.Connection;
import model.Discount;

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
    private JButton btnSeeSpecificProdDiscount = new JButton("Search ProductID");
    private JButton btnseeAllProductDiscount = new JButton("All product discounts");

    private String[] discountsColumnNames = {"ID", "Description", "Percentage"};
    private String[] allProductDiscountColumnNames = {"ProductID", "DiscountID", "StartDate", "EndDate", "Description", "Percentage"};
    private String[] specificProductDiscountColumnNames = {"ProdID", "DisctID", "SDate", "EDate", "Desc", "%", "FinalPrice"};

    private JTextField tfProductDiscountID = new JTextField();


    //Class for admins gui interaction with discounts
    public AdminDiscount(Controller controller){
        this.setLayout(new GridLayout(1,2));
        this.controller=controller;
        setSize(1000,500);
        setLocationRelativeTo(null);
        setTitle("Admin Discount Menu");

        Border borderRightTop = BorderFactory.createTitledBorder("Create new discount");
        Border borderRightBottom = BorderFactory.createTitledBorder("Add discount to a product");

        pnlBtns.setLayout(new GridLayout(3,2));
        pnlBtns.add(btnSeeDisc);
        pnlBtns.add(btnMain);
        pnlBtns.add(tfProductDiscountID);
        pnlBtns.add(btnSeeSpecificProdDiscount);
        pnlBtns.add(btnseeAllProductDiscount);


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


        table= new JTable(Discount.seeAllDiscounts(), discountsColumnNames);
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
        btnSeeSpecificProdDiscount.addActionListener(this);
        btnseeAllProductDiscount.addActionListener(this);


        setVisible(true);


    }




    public void updateTable(String[][] arr, String[] columnNames){
        this.getContentPane().remove(table);
        table= new JTable(arr, columnNames);
        pnlLeft.add(new JScrollPane(table), BorderLayout.CENTER);
        revalidate();

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==btnMain){
            this.dispose();
            new AdminMenu(controller);
        }

        //see all discounts
        if (e.getSource()==btnSeeDisc){
            updateTable(Discount.seeAllDiscounts(),discountsColumnNames);


        }
        //see discount history of a product.
        if (e.getSource()==btnSeeSpecificProdDiscount){
            int id = Integer.parseInt(tfProductDiscountID.getText());
            tfProductDiscountID.setText(null);
            updateTable(Discount.seeSpecificProductDiscountHistory(id), specificProductDiscountColumnNames); //displays discount history for product based on id. inputs relevant column names
        }
        if (e.getSource()==btnseeAllProductDiscount){
            updateTable(Discount.seeAllProductDiscountHistory(), allProductDiscountColumnNames);
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
