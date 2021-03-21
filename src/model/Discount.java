package model;

import database.Connection;

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



    //See discount history for a product
    public static void seeDiscountHistory(int id){
        String  query = "EXEC seeDiscountHistoryForAProduct @Product_id = " + id;

                Connection.executeQueryWithResult(query);
    }


}
