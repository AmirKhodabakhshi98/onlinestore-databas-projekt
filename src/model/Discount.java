package model;

import database.Connection;

public class Discount {
    private Product product;
    private int percentage;
    private int date;
    private String discountName;
    private String query;

    //product_id, discount_id, start_date, end_date

    public Discount(){

    }

    public void addProductDiscount(int product_id, int discount_id, int start_date, int end_date){
    query = "EXEC addProductDiscount @Discount_id = " + discount_id + ", @Product_id = " + product_id +
                ", @Start_date = " + start_date + ", @End_date = " + end_date;

        Connection.executeQueryNoResult(query);

    }

    public void addDiscounts(String description, int percentage){
        query = "EXEC addDiscount @Description = '" + description + "', @Percentage = " + percentage;


        Connection.executeQueryNoResult(query);
    }

    public void seeDiscountHistory(int id){
        query = "EXEC seeDiscountHistoryForAProduct @Product_id = " + id;

                Connection.executeQueryWithResult(query);
    }






    public void discountToProductDate(Product product, int date){

    this.product = product;
    this.date = date;
    }

    public void discountHistory(){

    }


}
