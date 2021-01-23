package view;

import controllers.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogIn extends JFrame {
    private JPanel mainPnl = new JPanel();
    private   JPanel logInPnl = new JPanel();
    private   ImageIcon onlineStore = new ImageIcon("image/Online store.PNG");
    private   JLabel onlineLbl = new JLabel(onlineStore);
    private   JButton custBtn = new JButton("Customer");
    private  JButton adminBtn = new JButton("Admin");
    private  JLabel logInLbl = new JLabel("Username: ");
    private  JLabel pswrdLbl = new JLabel("Password: ");
    private  JTextField logInTxt = new JTextField();
    private  JTextField passwordTxt = new JTextField();
    private  Controller controller;


    public LogIn(Controller controller){
        this.controller=controller;
    setSize(350,320);
    setVisible(true);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
    add(mainPnl);
    mainPnl.setLayout(null);
    logInPnl.setLayout(null);
    setPanelSize();


    actionListener al = new actionListener();
    custBtn.addActionListener(al);
    adminBtn.addActionListener(al);

    mainPnl.setBackground(Color.white);
    mainPnl.add(logInPnl);
    logInPnl.setBounds(30,60, 280,180);
    logInPnl.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "User login"));
    logInPnl.setBackground(Color.white);
    onlineLbl.setBounds(70,10,210,30);
    logInLbl.setBounds(20,50,130,20);
    pswrdLbl.setBounds(20,80,130,20);
    logInTxt.setBounds(100,50,160,20);
    passwordTxt.setBounds(100,80,160,20);
    custBtn.setBounds(70,120, 91,20);
    adminBtn.setBounds(168,120, 91,20);
    mainPnl.add(onlineLbl);
    logInPnl.add(logInLbl);
    logInPnl.add(pswrdLbl);
    logInPnl.add(logInTxt);
    logInPnl.add(passwordTxt);
    logInPnl.add(custBtn);
    logInPnl.add(adminBtn);
    mainPnl.validate();



}

    private  void setPanelSize(){
        mainPnl.setPreferredSize(new Dimension(350,430));
}



    //Sends input data to controller to perform customer login validation
    private void customerLogin(){

        controller.customerLogin(logInTxt.getText(), passwordTxt.getText());
        this.dispose();

    }

    //Sends input data to controller to perform admin login validation
    private void adminLogin(){

        controller.adminLogin(logInTxt.getText(), passwordTxt.getText());
        this.dispose();

    }


    private class actionListener implements ActionListener {


        public void actionPerformed(ActionEvent e) {

            if (e.getSource()==custBtn){
                customerLogin();

            }

            if (e.getSource()==adminBtn){
                adminLogin();
            }



        }
    }


}
