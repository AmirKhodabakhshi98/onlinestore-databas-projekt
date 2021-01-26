package view;

import controllers.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminProductMenu extends JFrame implements ActionListener {


    private JTable table;
    private Controller controller;

    private String[] columnNames = {"ID", "Supplier", "Name", "Base Price", "Quantity"};

    private JPanel panelLeft = new JPanel();
    private JPanel panelRight = new JPanel();
    private JPanel panelBtn = new JPanel();
    private JPanel pnlEdit;
    private JPanel pnlDelete;
    private JPanel pnlAddProduct;
  //  private JPanel pnlAddSupplier;
    private JPanel pnlAdminProductSearch;

    private JLabel lblEdit = new JLabel("Edit");
    private JLabel lblEditID = new JLabel("ID");
    private JLabel lblQuantity = new JLabel("Quantity");
    private JTextField tfEditId = new JTextField();
    private JTextField tfQuantity = new JTextField();
    private JLabel lblDeleteId = new JLabel("ID");
    private JTextField tfDeleteId = new JTextField();


    private JButton btnEditMenu = new JButton("Edit menu");
    private JButton btnDeleteMenu = new JButton("Delete menu");
    private JButton btnOrderMenu = new JButton("Order menu");
    private JButton btnDiscountMenu = new JButton("Discount menu");
    private JButton btnMainMenu = new JButton("Main menu");
    private JButton btnEdit = new JButton("Edit Quantity");
    private JButton btnDelete = new JButton("Delete Product");
    private JButton btnAddProduct = new JButton("Add Product");
    private JButton btnSearch = new JButton("Search");
  //  private JButton btnSupplierMenu = new JButton("Add supplier");

    public AdminProductMenu(Controller controller){

        this.controller=controller;
        setTitle("Admin Product Menu");
        setSize(800,500);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(1,2));


        table= new JTable(controller.getProducts(), columnNames);
        table.setEnabled(false);    //Makes table not editable
        panelLeft.setLayout(new BorderLayout());
        panelLeft.add(new JScrollPane(table), BorderLayout.CENTER);

        panelBtn.setLayout(new GridLayout(2,5));
        panelBtn.add(btnEditMenu);
        panelBtn.add(btnDeleteMenu);
        panelBtn.add(btnSearch);
   //     panelBtn.add(btnDiscountMenu);
   //     panelBtn.add(btnOrderMenu);
  //      panelBtn.add(btnSupplierMenu);
        panelBtn.add(btnMainMenu);
        panelBtn.add(btnAddProduct);
        panelLeft.add(panelBtn, BorderLayout.SOUTH);

        btnEditMenu.addActionListener(this);
        btnDeleteMenu.addActionListener(this);
        btnOrderMenu.addActionListener(this);
        btnDiscountMenu.addActionListener(this);
        btnMainMenu.addActionListener(this);
        btnAddProduct.addActionListener(this);
        btnSearch.addActionListener(this);

     //   panelRight.setLayout(new GridLayout(1,1));
        panelRight.setLayout(new BorderLayout());

        add(panelLeft);
        add(panelRight);


        setVisible(true);


         pnlEdit = new EditPanel(this);
         pnlDelete = new DeletePanel(this);
         pnlAddProduct = new AddProduct(controller,this);
         pnlAdminProductSearch = new AdminProductSearch(controller,this);
     //   pnlAddSupplier = new addSupplier(controller);

    }

    private void updatePanel(JPanel panel){
        this.getContentPane().remove(panelRight);
        panelRight = new JPanel();
        panelRight.add(panel, BorderLayout.CENTER);
        this.getContentPane().add(panelRight);
        revalidate();
    }

    public void updateTable(){
        this.getContentPane().remove(table);
        table= new JTable(controller.getProducts(), columnNames);
        panelLeft.add(new JScrollPane(table), BorderLayout.CENTER);
        revalidate();

    }




        public void actionPerformed(ActionEvent e) {

            if (e.getSource()== btnEditMenu){
            updatePanel(pnlEdit);
            }

            if (e.getSource()==btnEdit){
                controller.editProduct(Integer.parseInt(tfEditId.getText()),Integer.parseInt(tfQuantity.getText()));
                tfEditId.setText(null);
                tfQuantity.setText(null);
                updateTable();
            }

            if (e.getSource()==btnDeleteMenu){
                updatePanel(pnlDelete);
            }

            if (e.getSource()==btnDelete){
                controller.deleteProduct(Integer.parseInt(tfDeleteId.getText()));
                tfDeleteId.setText(null);
                updateTable();
            }

            if (e.getSource()==btnMainMenu){
                this.dispose();
                new AdminMenu(controller);
            }

            if (e.getSource()==btnAddProduct){
                updatePanel(pnlAddProduct);
            }
            if (e.getSource()==btnSearch){
                updatePanel(pnlAdminProductSearch);
            }



        }


    private class DeletePanel extends JPanel {

        ActionListener al;

        public DeletePanel(ActionListener al) {

            this.al = al;

            setLayout(new GridLayout(2,2));

            add(lblDeleteId);
            add(tfDeleteId);
            add(btnDelete);
            setVisible(true);
            btnDelete.addActionListener(al);

        }
    }

    private class EditPanel extends JPanel {

        ActionListener al;

        public EditPanel(ActionListener al) {

            this.al = al;

            setLayout(new GridLayout(3,2));

            add(lblEditID);
            add(tfEditId);
            add(lblQuantity);
            add(tfQuantity);
            add(btnEdit);
            setVisible(true);
            btnEdit.addActionListener(al);

        }
    }

}


