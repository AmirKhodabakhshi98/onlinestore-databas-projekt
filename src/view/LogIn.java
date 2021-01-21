package view;

import javax.swing.*;
import java.awt.*;

public class LogIn extends JFrame {
    JPanel mainPnl = new JPanel();
    JPanel logInPnl = new JPanel();
    ImageIcon onlineStore = new ImageIcon("image/Online store.PNG");
    JLabel onlineLbl = new JLabel(onlineStore);
    JButton custBtn = new JButton("Customer");
    JButton adminBtn = new JButton("Admin");
    JLabel logInLbl = new JLabel("Username: ");
    JLabel pswrdLbl = new JLabel("Password: ");
    JTextField logInTxt = new JTextField();
    JTextField passwordTxt = new JTextField();


    public LogIn(){
    setSize(350,320);
    setVisible(true);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
    add(mainPnl);
    mainPnl.setLayout(null);
    logInPnl.setLayout(null);
    setPanelSize();



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

public void setPanelSize(){
        mainPnl.setPreferredSize(new Dimension(350,430));
}

    public static void main(String[] args) {
    LogIn log = new LogIn();


    }

}
