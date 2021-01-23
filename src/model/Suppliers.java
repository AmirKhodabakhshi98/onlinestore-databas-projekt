package model;

import database.Connection;

public class Suppliers {
    /*
    private String name;
    private int phonenbr;
    private String address;


    public Suppliers(String name, int phonenbr, String address){
        this.name=name;
        this.address=address;
        this.phonenbr=phonenbr;
    }

     */


    private static String query;

    //Sends query to add new supplier to db
    public static void addSupplier(String name, int phonenbr, String address){
        query = "Insert into Supplier (Name, Phone_number, Address) " +
                " values('" + name + "', " + phonenbr + ", '" + address + "');" ;

        Connection.executeQueryNoResult(query);

    }





}
