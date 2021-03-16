package view;

import model.Orders;

import javax.swing.*;
import java.awt.*;

public class MaxMonthlyOrders extends JFrame {



    public MaxMonthlyOrders(){

        JTable table = new JTable( (String[][])Orders.maxMonthlyOrder()[0], (String[])Orders.maxMonthlyOrder()[1]);



        setTitle("Max Monthly Orders");
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setSize(600,400);
        add(new JScrollPane(table), BorderLayout.CENTER);

        setVisible(true);
    }

}
