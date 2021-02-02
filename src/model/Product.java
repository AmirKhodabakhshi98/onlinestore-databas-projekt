package model;

import controllers.Controller;
import database.Connection;

import javax.naming.ldap.Control;
import javax.swing.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
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



    public static void addProduct( String supplier, String name, int price, int quantity){

        query = "EXEC addProduct @Supplier_name = '" + supplier + "', @Name = '" + name + "', @Base_price = " +
                price + ", @Quantity = " + quantity;

        Connection.executeQueryNoResult(query);

    }


    //Alter quantity of a product in db based on input id
    public static void editProductQuantity(int id, int quantity){



            query = "EXEC setProductQuantity @Product_id = '" + id + "', @Quantity = '" + quantity + "'";

            Connection.executeQueryNoResult(query);


    }

    //Delete a product in db based on input id
    public static void deleteProduct(int id){

        query = "EXEC deleteProduct @Product_id = " + id;

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


            query = "Select * from Product";

            ResultSet res = Connection.executeQueryWithResult(query);   // returns all products

            return Controller.resultSetToArray(res);

    }

}


            /*
            for (int i=0; i<prodArray.length; i++){
                res.next();
                prodArray[i][0] = String.valueOf(res.getInt("Product_id"));
                prodArray[i][1] = res.getNString("Supplier_name");
                prodArray[i][2] = res.getNString("Name");
                prodArray[i][3] = String.valueOf(res.getInt("Base_price"));
                prodArray[i][4] = String.valueOf(res.getInt("Quantity"));
            }

             */

