package model;

import controllers.Controller;
import database.Connection;

import java.text.SimpleDateFormat;
import java.util.Date;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Orders {


    public static void addToCart(String username, int productId, int quantity){

        int FinalPrice = calculateDiscountedPrice(productId,quantity,null);


        String query = "EXEC addToCart @Username = '" + username + "', @Product_ID = " + productId
        + ", @Quantity = " + quantity + ", @FinalPrice = " + FinalPrice;

        Connection.executeQueryNoResult(query);


    }


    //Method to calculate product price at a given date taking in account quantity and discount
    public static int calculateDiscountedPrice(int productID, int quantity, String dateStamp){


        if (dateStamp == null || dateStamp.equals("")){ //if datestamp is empty or null it gets the current datetime
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            dateStamp = formatter.format(date);
            System.out.println(dateStamp);

        }

        String query = "SELECT Base_price FROM Product where Product_id = " + productID; //Gets the base price of a product
        ResultSet res = Connection.executeQueryWithResult(query);

        try {

            int basePrice = res.getInt("Base_price");

        //gets the discount percentage applied to the product at the given date
        query = "Select Percentage \n" +
                "FROM Discount\n" +
                "JOIN Product_discount on Discount.Discount_id = Product_discount.Discount_id\n" +
                "WHERE '" + dateStamp + "' >= Start_date AND '" + dateStamp + "' <= End_date AND Product_discount.Product_id = " + productID;
        res = Connection.executeQueryWithResult(query);

       int percentage;

        if (res == null || !res.first()) { //check if there is discount. checks if null or if it isnt on first row which would mean its empty

             percentage=0;

        }else {

             percentage = res.getInt("Percentage");

        }

        double finalPrice = basePrice * quantity * (1 - percentage/100); //calculates total price


            return (int)finalPrice;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return -1;

    }


    public static void deleteFromCart(int productId){
        String query = "EXEC deleteFromCart @Product_ID = " + productId;
        Connection.executeQueryNoResult(query);
    }


    public static void createOrder(String username, int[] productId, int[] quantity){
        String query = "EXEC newOrder @username = '" + username + "'"; //skapar ny order
        Connection.executeQueryNoResult(query);

        for (int i = 0; i < productId.length; i++){
            int id = productId[i];
            int quant = quantity[i];

             query = "EXEC createOrderProduct @Username = '" + username + "', @Product_id = "
                    + id + "@Quantity = " + quant; //lägger in alla items
             Connection.executeQueryNoResult(query);
        }
        query = "EXEC clearCart"; //tömmer kundvagn
        Connection.executeQueryNoResult(query);
    }

    public static int totalPrice(String username){
        String query = "EXEC totalPrice @username = '" + username + "'";
        ResultSet res = Connection.executeQueryWithResult(query);

        try {

            return res.getInt("price"); // fixa sen

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return -1;

    }

    //Method for getting the total price of an order
    public static int getOrderPrice(int orderID){

        int orderPrice = 0;

        try {

        String query = "Select [Date] from [Order] where Order_id = " + orderID;
        ResultSet res = Connection.executeQueryWithResult(query);
        String date = res.getNString("Date");

        query = "Select Product_id, QuantitySold from Order_Product where Order_product.Order_id = " + orderID;
        res = Connection.executeQueryWithResult(query);


            while (res.next()) {
                int productID = res.getInt("Product_id");
                int quantity = res.getInt("QuantitySold");

                orderPrice += calculateDiscountedPrice(productID,quantity,date);

            }


        }catch (SQLException e){
            e.printStackTrace();
        }

        return orderPrice;
    }

    public static ResultSet getCustomerOrders(String username){
        String query = "Select Order_id from [Order] where Username = '" + username + "'";
        ResultSet res  = Connection.executeQueryWithResult(query);

        return res;

    }


    public static void deleteOrder(int id){

        String query = "EXEC deleteOrder @Order_id = " + id;

        Connection.executeQueryNoResult(query);

    }


    public static String[][] findOrderProductsByOrderId(int id){

        String query = "EXEC findOrderProductsByOrderId @Order_id = " + id;

        ResultSet res = Connection.executeQueryWithResult(query);

        return Controller.resultSetToArray(res);

    }

    public static String[][] findOrdersByUsername(String username){

        String query = "EXEC findOrdersByUsername @Username = '" + username + "'";

        ResultSet res = Connection.executeQueryWithResult(query);

        return Controller.resultSetToArray(res);

    }

    public static String[][] UnconfirmedOrders(){
        String query = "EXEC UnconfirmedOrders";

        ResultSet res = Connection.executeQueryWithResult(query);

        return Controller.resultSetToArray(res);
    }

    public static Object[] maxMonthlyOrder(){
        Object[] returnData = new Object[2];

        String query = "EXEC maxMonthlyOrder";

        ResultSet res = Connection.executeQueryWithResult(query);

        returnData[0] = Controller.resultSetToArray(res);
        returnData[1] = Controller.getColumnNames(res);

        return returnData;

    }
}
