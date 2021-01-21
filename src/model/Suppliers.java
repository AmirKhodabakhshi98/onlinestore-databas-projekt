package model;

import database.Connection;

public class Suppliers {
    String query;

    //Add a supplier
    public void addSupplier(String name, int phonenbr, String address){
        query = "Insert into Supplier (Name, Phone_number, Address) " +
                " (" + name + ", " + phonenbr + ", " + address + ");" ;

        Connection.executeQuery(query);

    }





}
