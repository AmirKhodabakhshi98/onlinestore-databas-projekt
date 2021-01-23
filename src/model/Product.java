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



    //Add a new product
    public static void addProduct(Product product){

        query =  "Insert into Product (Product_id, Supplier_name, Name, Base_price, Quantity) " +
                "values (" + product.id + ", '" + product.supplier + "', '" + product.name + "', " + product.price + ", "
                + product.quantity  + ");";

        Connection.executeQueryNoResult(query);

    }

    //Alter quantity of a product based on input id
    public static void editProductQuantity(int id, int quantity){

        if (quantity>=0) {

            query = "Update Product " +
                    "Set Quantity = " + quantity +
                    "Where Product_id = " + id;
            Connection.executeQueryNoResult(query);

        }else JOptionPane.showMessageDialog(null,"Quantity can't be negative");

    }

    //Delete product based on input id
    public static void deleteProduct(int id){

        query = "Delete from Product " +
                "Where Product_id = " + id;

        Connection.executeQueryNoResult(query);
    }


    public static ArrayList<Product> getAllProducts(){
        try {

            ArrayList<Product> products = new ArrayList<Product>();

            // query to count nbr of products
            query = "Select count(Product_id) as rows " +
                    "From Product";
            ResultSet res = Connection.executeQueryWithResult(query);
        //    products = new Product[res.getInt("rows")]; //initializes array based on nbr of products

            query = "Select * from product";
            res = Connection.executeQueryWithResult(query);   // returns all products

            int i = 0;
            Product prod;

            //Loops through the resultset and filling the products array with product objects
            while (res.next()){
                prod = new Product(res.getInt("Product_id"),
                        res.getNString("Supplier_name"),
                        res.getNString("Name"),
                        res.getInt("Base_price"),
                        res.getInt("Quantity"));

                products.add(prod);
            }

            return products;

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

