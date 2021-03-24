package view;

import controllers.Controller;
import database.Connection;
import model.Orders;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerOrder extends JFrame implements ActionListener {




    private JTable tableProducts;
    private JTable tableOrders;

    private JButton btnMenu = new JButton("Main Menu");
    private JButton btnDelete = new JButton("Delete Order");
    private JButton btnGetProds = new JButton("Show products");
    private JButton btnSeeOrders = new JButton("All Orders");

    private JLabel lblProds = new JLabel("Order ID to show products");
    private JTextField tfProds = new JTextField();
    private JLabel lblDelete = new JLabel("OrderId to delete");
    private JTextField tfDelete = new JTextField();


    private String[] tableOrderColumns = {"OrderId", "Username", "Confirmed", "Datetime"};
    private String[] tableProductsColumns = {"OrderID", "ProductID","Name", "Quantity"};



    private JPanel pnlRight = new JPanel();
    private JPanel pnlLeft = new JPanel();
    private JPanel pnlButtons = new JPanel();

    private Controller controller;

    private String[][] empty2dArray= {
            {"","","",""}
                        };

    public CustomerOrder(Controller controller){
        this.controller=controller;
        setLayout(new GridLayout(1,2));

        pnlLeft.setLayout(new BorderLayout());
        pnlRight.setLayout(new BorderLayout());

        tableOrders = new JTable(controller.getUserOrders(),tableOrderColumns);
        tableOrders.setEnabled(false);
        pnlLeft.add(new JScrollPane(tableOrders),BorderLayout.CENTER);

        tableProducts = new JTable(empty2dArray,tableProductsColumns);
        tableProducts.setEnabled(false);
        pnlRight.add(new JScrollPane(tableProducts));

        pnlButtons.setLayout(new GridLayout(3,3));
        pnlButtons.add(lblProds);
        pnlButtons.add(tfProds);
        pnlButtons.add(btnGetProds);
        pnlButtons.add(lblDelete);
        pnlButtons.add(tfDelete);
        pnlButtons.add(btnDelete);
        pnlButtons.add(btnMenu);
 //       pnlButtons.add(btnSeeOrders);
        pnlLeft.add(pnlButtons, BorderLayout.SOUTH);


        btnDelete.addActionListener(this);
        btnMenu.addActionListener(this);
        btnGetProds.addActionListener(this);
        btnSeeOrders.addActionListener(this);
        add(pnlLeft);
        add(pnlRight);
        this.setLocationRelativeTo(null);
        setSize(1100,600);
        setVisible(true);

    }

    public void updateProductTable(String[][] arr){
        pnlRight.removeAll();
        tableProducts= new JTable(arr, tableProductsColumns);
        pnlRight.add(new JScrollPane(tableProducts), BorderLayout.CENTER);
        revalidate();

    }



    public void updateOrderTable(String[][] arr){
        pnlLeft.removeAll();
        tableOrders = new JTable(arr, tableOrderColumns);
        pnlLeft.add(new JScrollPane(tableOrders),BorderLayout.CENTER);
        pnlLeft.add(pnlButtons, BorderLayout.SOUTH);

        revalidate();

    }

    public static void main(String[] args) {
        Connection.connect();
        new CustomerOrder(new Controller());
    }
 


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==btnMenu){
            this.dispose();
            new CustomerMainMenu(controller);
        }


        if (e.getSource()==btnGetProds){
            int id = Integer.parseInt(tfProds.getText());

            updateProductTable(controller.getUserOrderProducts(id)); //retrieves product array based on order ID and furthers it to
                                                                        // the right table
            tfProds.setText(null);
        }



        if (e.getSource()==btnDelete){

            int id = Integer.parseInt(tfDelete.getText());

            Orders.deleteOrder(id);

            tfDelete.setText(null);

            updateOrderTable(controller.getUserOrders());
        }

        if (e.getSource()==btnSeeOrders){
            updateOrderTable(controller.getUserOrders());
        }


    }
}
