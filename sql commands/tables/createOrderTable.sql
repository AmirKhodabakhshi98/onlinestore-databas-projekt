CREATE TABLE Order (
    Order_id int NOT NULL AUTO_INCREMENT,
    Customer_id int NOT NULL,
    Confirmed BOOLEAN NOT NULL,
    Date DATETIME NOT NULL,
    PRIMARY KEY (Order_id)
    FOREIGN KEY (Customer_id REFERENCES Customer(Customer_id))
)