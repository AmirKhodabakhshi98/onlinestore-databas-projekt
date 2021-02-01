package model;

import database.Connection;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Product {

    private int id;
    private String supplier;
    private String name;
    private int price;
    private int quantity;
    private static String query;

    public Product(int id, String supplier, String name, int price, int quantity){

        this.id= id;
        this.supplier=supplier;
        this.name=name;
        this.price=price;
        this.quantity=quantity;

    }



    //Sends query to db to add new product row
    public static void addProduct(Product product){

        query =  "Insert into Product (Product_id, Supplier_name, Name, Base_price, Quantity) " +
                "values (" + product.id + ", '" + product.supplier + "', '" + product.name + "', " + product.price + ", "
                + product.quantity  + ");";

        Connection.executeQueryNoResult(query);

    }

    public static void addProduct(int id, String supplier, String name, int price, int quantity){

        query = "Insert into Product (Product_id, Supplier_name, Name, Base_price, Quantity) " +
                "values (" + id + ", '" + supplier + "', '" + name + "', " + price + ", "
                + quantity  + ");";

        Connection.executeQueryNoResult(query);

    }



    //Alter quantity of a product in db based on input id
    public static void editProductQuantity(int id, int quantity){

        if (quantity>=0) {

            query = "Update Product " +
                    "Set Quantity = " + quantity +
                    "Where Product_id = " + id;
            Connection.executeQueryNoResult(query);

        }else JOptionPane.showMessageDialog(null,"Quantity can't be negative");

    }

    //Delete a product in db based on input id
    public static void deleteProduct(int id){

        query = "Delete from Product " +
                "Where Product_id = " + id;

        Connection.executeQueryNoResult(query);
    }


    //returns number of products in db
    public static int getRows(){

        query = "Select count(Product_id)  " +
                "from Product ";

        ResultSet res = Connection.executeQueryWithResult(query);

        int rows = 0;

        try {

            res.next(); //Moves cursor to first row
             rows = res.getInt(1);  //retrieves count value


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rows;
    }

    //Returns an array of representing all products stored in the database
    public static String[][] getAllProducts(){
        try {

            query = "Select * from Product";
            ResultSet res = Connection.executeQueryWithResult(query);   // returns all products

            String[][] prodArray = new String[getRows()][5];

            ArrayList<String> arrayList = new ArrayList();

            for (int i=0; i<prodArray.length; i++){
                res.next();
                prodArray[i][0] = String.valueOf(res.getInt("Product_id"));
                prodArray[i][1] = res.getNString("Supplier_name");
                prodArray[i][2] = res.getNString("Name");
                prodArray[i][3] = String.valueOf(res.getInt("Base_price"));
                prodArray[i][4] = String.valueOf(res.getInt("Quantity"));
            }



            return prodArray;

        }catch (SQLException e){
            e.printStackTrace();
        }

        return null;

    }

    public int getId() {
        return id;
    }

    public String getSupplier() {
        return supplier;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}

