package model;

public class Product {
<<<<<<< Updated upstream
}
=======

    String query;

    //Add a new product
    public void addProduct(int id, String supplier, String name, int price, int quantity ){

        query =  "Insert into Product (Product_id, Supplier_name, Name, Base_price, Quantity) " +
                "values (" + id + ", " + supplier + ", " + name + ", " + price + ", " + quantity  + ");";

        Connection.executeQuery(query);
    }

    public void editProductQuantity(int id, int quantity){

        query = "Update product " +
                "Set Quantity = " + quantity +
                "Where Product_id = " + id;
        Connection.executeQuery(query);


    }






    }

>>>>>>> Stashed changes
