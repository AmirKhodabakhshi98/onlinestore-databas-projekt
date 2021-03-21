package view;

import controllers.Controller;
import model.Product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerProduct extends JFrame implements ActionListener {


    private JPanel northPanel = new JPanel();
    private JPanel southPnl = new JPanel();
    private JPanel centerPnl = new JPanel();
    private String[] columnNames = {"ID", "Supplier", "Name", "Base Price", "Quantity"};
    private JTable prodTable;
    private JRadioButton radioBtnName = new JRadioButton("Name");
    private JRadioButton radioBtnSpl = new JRadioButton("Supplier");
    private JRadioButton radioBtnPrice = new JRadioButton("Price");
    private JLabel keyLbl = new JLabel("Keyword");
    private JTextField keyWrdTxf = new JTextField();
    private JButton searchBtn = new JButton("Search");
    private ButtonGroup group;
    private JButton menuBtn = new JButton("Main Menu");

    private JPanel pnlMain = new JPanel();
    private JPanel pnlShoppingList =  new JPanel();
    private JPanel pnlShoppingListSouth =  new JPanel();
    private JPanel pnlShoppingListNorth =  new JPanel();
    private JLabel lblEmpty = new JLabel("");
    private JLabel lblEmpty2 = new JLabel("");
    private JLabel lblID = new JLabel("ProductID");
    private JLabel lblQuantity = new JLabel("Quantity");
    private JTextField tfIdAdd = new JTextField();
    private JTextField tfIdDelete = new JTextField();
    private JTextField tfQuantity = new JTextField();
    private JButton btnAdd = new JButton("ADD");
    private JButton btnDelete = new JButton("Delete");
    private JButton btnPurchase = new JButton("Purchase");

    private Controller controller;

    public CustomerProduct(Controller controller){
        this.controller=controller;
        setSize(675,340);
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
        prodTable = new JTable(Product.getAllProducts(), columnNames);
        prodTable.setEnabled(false);
        add(northPanel, BorderLayout.NORTH);
        add(centerPnl, BorderLayout.CENTER);
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
        centerPnl.add(menuBtn);


        menuBtn.addActionListener(this);
        searchBtn.addActionListener(this);
        radioBtnName.addActionListener(this);
        radioBtnSpl.addActionListener(this);
        radioBtnPrice.addActionListener(this);

        group.add(radioBtnName);
        group.add(radioBtnPrice);
        group.add(radioBtnSpl);


        pnlShoppingList.setLayout(new GridLayout(2,1));
        pnlShoppingListSouth.setLayout(new GridLayout(4,3));
        pnlShoppingListNorth.setLayout(new GridLayout(1,1));
        pnlShoppingList.add(lblEmpty);
        pnlShoppingList.add(lblID);
        pnlShoppingList.add(lblQuantity);
        pnlShoppingList.add(btnAdd);
        pnlShoppingList.add(tfIdAdd);
        pnlShoppingList.add(tfQuantity);
        pnlShoppingList.add(btnDelete);
        pnlShoppingList.add(tfIdDelete);
        pnlShoppingList.add(lblEmpty);
        pnlShoppingList.add(btnPurchase);

        add(pnlShoppingList, BorderLayout.EAST);

        btnAdd.addActionListener(this);
        btnDelete.addActionListener(this);
        btnPurchase.addActionListener(this);

        northPanel.validate();
        centerPnl.validate();

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==searchBtn){
            String searchword =  keyWrdTxf.getText();

            if (radioBtnPrice.isSelected()){



            }else if (radioBtnName.isSelected()){

            }
            else if (radioBtnSpl.isSelected()){


            }
        }
        if (e.getSource()==menuBtn){
            this.dispose();
            new CustomerMainMenu(controller);
        }

    }

    public void updateTable(){
        this.getContentPane().remove(prodTable);

    }

}
