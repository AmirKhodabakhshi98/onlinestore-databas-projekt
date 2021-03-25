package view;

import controllers.Controller;
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
    private JTextField tfShowProds = new JTextField();
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


    private JTextField tfOrderPrice = new JTextField();
    private JLabel lblOrderIdInput = new JLabel("OrderID to see price");
    private JButton btnOrderPrice = new JButton("Order Price");
    private JLabel lblPrice = new JLabel("Order price: ");


    private JLabel lblOrderProdIdInput = new JLabel("ProductID to see price");
    private JLabel lblDate = new JLabel("Order ID for product: ");
    private JTextField tfProdPrice = new JTextField();
    private JTextField tfDate = new JTextField();
    private JButton btnProdPrice = new JButton("Show product price");
    private JLabel lblProdPrice = new JLabel("Product price: ");



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

        pnlButtons.setLayout(new GridLayout(7,3));
        pnlButtons.add(lblProds);
        pnlButtons.add(tfShowProds);
        pnlButtons.add(btnGetProds);
        pnlButtons.add(lblDelete);
        pnlButtons.add(tfDelete);
        pnlButtons.add(btnDelete);
        pnlButtons.add(lblOrderIdInput);
        pnlButtons.add(tfOrderPrice);
        pnlButtons.add(btnOrderPrice);
        pnlButtons.add(lblPrice);

        pnlButtons.add(new JLabel());
        pnlButtons.add(new JLabel());

        pnlButtons.add(lblOrderProdIdInput);
        pnlButtons.add(tfProdPrice);
        pnlButtons.add(new JLabel());
        pnlButtons.add(lblDate);
        pnlButtons.add(tfDate);
        pnlButtons.add(btnProdPrice);
        pnlButtons.add(lblProdPrice);
        pnlButtons.add(btnMenu);
 //       pnlButtons.add(btnSeeOrders);
        pnlLeft.add(pnlButtons, BorderLayout.SOUTH);


        btnDelete.addActionListener(this);
        btnMenu.addActionListener(this);
        btnGetProds.addActionListener(this);
        btnSeeOrders.addActionListener(this);
        btnOrderPrice.addActionListener(this);
        btnProdPrice.addActionListener(this);
        add(pnlLeft);
        add(pnlRight);
        this.setLocationRelativeTo(null);
        setSize(1100,600);
        setVisible(true);

    }

    public void updateProductTable(String[][] arr){
        pnlRight.removeAll();
        tableProducts= new JTable(arr, tableProductsColumns);
        tableProducts.setEnabled(false);
        pnlRight.add(new JScrollPane(tableProducts), BorderLayout.CENTER);
        revalidate();

    }



    public void updateOrderTable(String[][] arr){
        pnlLeft.removeAll();
        tableOrders = new JTable(arr, tableOrderColumns);
        tableOrders.setEnabled(false);
        pnlLeft.add(new JScrollPane(tableOrders),BorderLayout.CENTER);
        pnlLeft.add(pnlButtons, BorderLayout.SOUTH);

        revalidate();

    }




    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==btnMenu){
            this.dispose();
            new CustomerMainMenu(controller);
        }


        if (e.getSource()==btnGetProds){
            int id = Integer.parseInt(tfShowProds.getText());

            updateProductTable(controller.getUserOrderProducts(id)); //retrieves product array based on order ID and furthers it to
                                                                        // the right table
            tfShowProds.setText(null);
        }



        if (e.getSource()==btnDelete){

            int id = Integer.parseInt(tfDelete.getText());

            Orders.deleteOrder(id, controller.username);

            tfDelete.setText(null);

            updateOrderTable(controller.getUserOrders());
        }

        if (e.getSource()==btnSeeOrders){
            updateOrderTable(controller.getUserOrders());
        }

        if (e.getSource()==btnOrderPrice){
            //sends the orderID to getOrderPrice method to show the orders price
            lblPrice.setText("Order Price: " + Orders.getOrderPrice(Integer.parseInt(tfOrderPrice.getText()),controller.username));
        }
        if (e.getSource()==btnProdPrice){
            int prodID = Integer.parseInt(tfProdPrice.getText());
            int orderID = Integer.parseInt(tfDate.getText());
            int price = Orders.getOrderProductPrice(controller.username,prodID,orderID);
            lblProdPrice.setText("Product price: " + price);

        }


    }
}
