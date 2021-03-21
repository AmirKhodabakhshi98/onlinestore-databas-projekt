package model;

import controllers.Controller;
import database.Connection;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Discount {
    private Product product;
    private int percentage;
    private int date;
    private String discountName;

    //product_id, discount_id, start_date, end_date

    public Discount(){

    }

    public static void addProductDiscount(int product_id, int discount_id, String start_date, String end_date){
    String query = "EXEC addProductDiscount @Discount_id = " + discount_id + ", @Product_id = " + product_id +
                ", @Start_date = '" + start_date + "', @End_date = '" + end_date + "'";

        Connection.executeQueryNoResult(query);

    }

    public static void addDiscounts(String description, int percentage){
        String  query = "EXEC addDiscount @Description = '" + description + "', @Percentage = " + percentage;


        Connection.executeQueryNoResult(query);
    }


    public static String[][] seeAllDiscounts(){

        String query = "select * from Discount";
        ResultSet res = Connection.executeQueryWithResult(query);
        return Controller.resultSetToArray(res);

    }


    //See discount history for a product INCLUDING FINAL PRICE
    public static String[][] seeSpecificProductDiscountHistory(int id){
        String  query = "EXEC seeDiscountHistoryForAProduct @Product_id = " + id;


        ResultSet res = Connection.executeQueryWithResult(query);

        String[][] resultArray = Controller.resultSetToArray(res);

        String[][] resultWithPriceArray = new String[resultArray.length][8];

        //copy contents of result array to a new array with calculated final price
        for (int i=0; i< resultArray.length; i++){

            String prodID = resultArray[i][0];
            String discID = resultArray[i][1];
            String startDate = resultArray[i][2];
            String endDate = resultArray[i][3];
            String description = resultArray[i][4];
            String percentage = resultArray[i][5];

            //final price is calculated here using the method in orders.
            String finalPrice = String.valueOf(Orders.calculateDiscountedPrice(Integer.parseInt(prodID),1,startDate));


            //copy to new array to be returned.
            resultWithPriceArray[i][0] = prodID;
            resultWithPriceArray[i][1] = discID;
            resultWithPriceArray[i][2] = startDate;
            resultWithPriceArray[i][3] = endDate;
            resultWithPriceArray[i][4] = description;
            resultWithPriceArray[i][5] = percentage;
            resultWithPriceArray[i][6] = finalPrice;

        }

        return resultWithPriceArray;

    }

    public static String[][] seeAllProductDiscountHistory(){
        String query = "EXEC seeDiscountHistoryForAll";
        ResultSet res = Connection.executeQueryWithResult(query); //gets all of product discount
        return Controller.resultSetToArray(res);

    }


}
