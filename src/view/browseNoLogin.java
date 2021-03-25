package view;

import controllers.Controller;
import model.Orders;
import model.Product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class browseNoLogin extends JFrame implements ActionListener{


        private JPanel northPanel = new JPanel();
        private JPanel southPnl = new JPanel();
        private JPanel centerPnl = new JPanel();
        private String[] prodColumnNames = {"ID", "Supplier", "Name", "Base Price", "Quantity", "Discount", "% off"};
        private JTable prodTable;
        private JRadioButton radioBtnName = new JRadioButton("Name");
        private JRadioButton radioBtnSpl = new JRadioButton("Supplier");
        private JRadioButton radioBtnPrice = new JRadioButton("Base Price");
        private JRadioButton radioBtnID = new JRadioButton("ID");
        private JLabel keyLbl = new JLabel("Keyword");
        private JTextField keyWrdTxf = new JTextField();
        private JButton searchBtn = new JButton("Search");
        private ButtonGroup group;
        private JButton menuBtn = new JButton("Main Menu");

        private JPanel pnlMain = new JPanel();

        private JButton btnAdd = new JButton("ADD");
        private JButton btnDelete = new JButton("Delete");
        private JButton btnPurchase = new JButton("Purchase");
        private JButton btnAllProds = new JButton("All Products");

        private JTable tblShoppingList;
        private String[] shoppingListColumns = {"ProductID", "Quantity", "FinalPrice"};

        private Controller controller;

        public browseNoLogin(Controller controller){
            this.controller=controller;
            setSize(1100,500);
            setVisible(true);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(new GridLayout(1,2));

            pnlMain.setLayout(new BorderLayout());

            northPanel.setBackground(Color.white);
            //northPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            centerPnl.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            centerPnl.setBackground(Color.white);
            northPanel.setPreferredSize(new Dimension(450,150));
            centerPnl.setPreferredSize(new Dimension(450,50));
            northPanel.setBackground(Color.white);
            searchBtn.setBounds(20,60,110,30);
            keyWrdTxf.setPreferredSize(new Dimension(110,20));
            prodTable = new JTable(Product.getAllProductsAndDiscount(), prodColumnNames);
            prodTable.setEnabled(false);
            pnlMain.add(northPanel, BorderLayout.NORTH);
            pnlMain.add(centerPnl, BorderLayout.CENTER);
            northPanel.add(prodTable);
            northPanel.add(new JScrollPane(prodTable), BorderLayout.NORTH);
            radioBtnName.setBackground(Color.WHITE);
            radioBtnPrice.setBackground(Color.WHITE);
            radioBtnSpl.setBackground(Color.WHITE);
            group = new ButtonGroup();
            centerPnl.add(searchBtn);
            centerPnl.add(keyLbl);
            centerPnl.add(keyWrdTxf);
            centerPnl.add(radioBtnName);
            centerPnl.add(radioBtnPrice);
            centerPnl.add(radioBtnSpl);
            centerPnl.add(radioBtnID);
            centerPnl.add(menuBtn);
            centerPnl.add(btnAllProds);


            menuBtn.addActionListener(this);
            searchBtn.addActionListener(this);
            radioBtnName.addActionListener(this);
            radioBtnSpl.addActionListener(this);
            radioBtnPrice.addActionListener(this);
            radioBtnID.addActionListener(this);

            group.add(radioBtnName);
            group.add(radioBtnPrice);
            group.add(radioBtnSpl);
            group.add(radioBtnID);


            tblShoppingList = new JTable(Orders.fetchCartItems(controller.username), shoppingListColumns);
            tblShoppingList.setEnabled(false);

            add(pnlMain);

            btnAdd.addActionListener(this);
            btnDelete.addActionListener(this);
            btnPurchase.addActionListener(this);
            btnAllProds.addActionListener(this);

            northPanel.validate();
            centerPnl.validate();

            this.validate();

        }


        //updates product table(left) with input array
        public void updateTable(String[][] arr){
            northPanel.removeAll();
            prodTable = new JTable(arr, prodColumnNames);
            prodTable.setEnabled(false);

            northPanel.add(new JScrollPane(prodTable));
            revalidate();

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource()==searchBtn){
                String searchword =  keyWrdTxf.getText();

                //updates table with search results based on radiobutton selection
                if (radioBtnPrice.isSelected()){
                    updateTable(Product.customerSearchPrice(Integer.parseInt(searchword)));


                }else if (radioBtnName.isSelected()){
                    updateTable(Product.customerSearchName(searchword));

                }
                else if (radioBtnSpl.isSelected()){
                    updateTable(Product.customerSearchSupplier(searchword));

                }

                else if (radioBtnID.isSelected()){
                    updateTable(Product.customerSearchID(Integer.parseInt(searchword)));

                }

            }

            if (e.getSource()==menuBtn){
                this.dispose();
                new StartingMenu(controller);
            }


            if (e.getSource()==btnAllProds){
                updateTable(Product.getAllProductsAndDiscount());
            }

        }





    }



