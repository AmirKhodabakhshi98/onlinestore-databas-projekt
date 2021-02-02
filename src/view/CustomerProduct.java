package view;

import controllers.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerProduct extends JFrame implements ActionListener {


    private JPanel northPanel = new JPanel();
    private JPanel southPnl = new JPanel();
    private JPanel centerPnl = new JPanel();
    private String[] columnNames = {"ID", "Supplier", "Name", "Base Price", "Quantity"};
    private JTable prodTable;
    private JRadioButton radioBtnName = new JRadioButton("Name");
    private JRadioButton radioBtnSpl = new JRadioButton("Supplier");
    private JRadioButton radioBtnPrice = new JRadioButton("Price");
    private JLabel keyLbl = new JLabel("Keyword");
    private JTextField keyWrdTxf = new JTextField();
    private JButton searchBtn = new JButton("Search");
    private ButtonGroup group;

    private Controller controller;

    public CustomerProduct(Controller controller){
        this.controller=controller;
        setSize(475,240);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        northPanel.setBackground(Color.white);
        //northPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        centerPnl.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        centerPnl.setBackground(Color.white);
        northPanel.setPreferredSize(new Dimension(450,150));
        centerPnl.setPreferredSize(new Dimension(450,50));
        northPanel.setBackground(Color.white);
        searchBtn.setBounds(20,60,110,30);
        keyWrdTxf.setPreferredSize(new Dimension(110,20));
        prodTable = new JTable(controller.getProducts(), columnNames);
        prodTable.setEnabled(false);
        add(northPanel, BorderLayout.NORTH);
        add(centerPnl, BorderLayout.CENTER);
        northPanel.add(prodTable);
        northPanel.add(new JScrollPane(prodTable), BorderLayout.NORTH);
        radioBtnName.setBackground(Color.WHITE);
        radioBtnPrice.setBackground(Color.WHITE);
        radioBtnSpl.setBackground(Color.WHITE);
        group = new ButtonGroup();
        centerPnl.add(searchBtn);
        centerPnl.add(keyLbl);
        centerPnl.add(keyWrdTxf);
        centerPnl.add(radioBtnName);
        centerPnl.add(radioBtnPrice);
        centerPnl.add(radioBtnSpl);

        group.add(radioBtnName);
        group.add(radioBtnPrice);
        group.add(radioBtnSpl);

        northPanel.validate();
        centerPnl.validate();

    }


    @Override
    public void actionPerformed(ActionEvent e) {
    if (e.getSource()==searchBtn){
        if (radioBtnPrice.isSelected()){
            keyWrdTxf.getText();
            
        }
    }
    }

    public void updateTable(){
        this.getContentPane().remove(prodTable);

    }

}
