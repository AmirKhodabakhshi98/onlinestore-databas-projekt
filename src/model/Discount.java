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
    seeDiscountHistory();

    }

    public void addProductDiscounts(int product_id, int discount_id, int start_date, int end_date){
    query = "Insert into Product_Discount (product_id, discount_id, start_id, end_date) " +
            "values (" + product_id + ", " + discount_id + ", " + start_date + "," + end_date + ");" ;

        Connection.executeQueryNoResult(query);

    }

    public void addDiscounts(int discount_id, String description, int percentage){
        query = "Insert into Discount (discount_id, description, percentage)" +
                "values (" + discount_id + ", '" + description + "', " + percentage + ");" ;

        Connection.executeQueryNoResult(query);
    }

    public void seeDiscountHistory(){
        query = "Select * from Product_discount p " +
                "join Discount d on d.Discount_id = p.Discount_id " +
                "where p.Product_id = d.percentage";

                Connection.executeQueryWithResult(query);
    }

    public void discountToProductDate(Product product, int date){
    this.product = product;
    this.date = date;
    }

    public void discountHistory(){

    }


}
