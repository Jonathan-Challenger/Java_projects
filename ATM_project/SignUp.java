package com.JonathanATM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class SignUp extends JFrame implements ActionListener{
    private static JTextField emailfield;
    private static JTextField cardNoField;
    private static JTextField pinField;
    private static JTextField balanceField;
    JButton backToHome, createAcc, clearBut;




    SignUp() {

        setLayout(null);

        backToHome = new JButton("BACK");
        backToHome.setBounds(100, 375, 300, 35);
        add(backToHome);

        createAcc = new JButton("CREATE ACCOUNT");
        createAcc.setBounds(100, 275, 300, 35);
        add(createAcc);

        clearBut = new JButton("CLEAR");
        clearBut.setBounds(100, 325, 300, 35);
        add(clearBut);

        JLabel regTitle = new JLabel("REGISTER");
        regTitle.setFont(new Font("Arial", Font.BOLD, 18));
        regTitle.setHorizontalAlignment(SwingConstants.CENTER);
        regTitle.setBounds(168, 26, 150, 50);
        add(regTitle);

        JLabel email = new JLabel("Email :");
        email.setFont(new Font("Arial", Font.BOLD, 12));
        email.setBounds(50, 100, 60, 30);
        add(email);

        JLabel cardNo = new JLabel("Card no. :");
        cardNo.setFont(new Font("Arial", Font.BOLD, 12));
        cardNo.setBounds(50, 140, 125, 30);
        add(cardNo);

        JLabel pin = new JLabel("PIN :");
        pin.setFont(new Font("Arial", Font.BOLD, 12));
        pin.setBounds(50, 180, 125, 30);
        add(pin);

        JLabel balance = new JLabel("Balance :");
        balance.setFont(new Font("Arial", Font.BOLD, 12));
        balance.setBounds(50, 220, 125, 30);
        add(balance);

        emailfield = new JTextField();
        emailfield.setBounds(120, 100, 300, 30);
        add(emailfield);
        emailfield.setColumns(10);

        cardNoField = new JTextField();
        cardNoField.setBounds(120, 140, 300, 30);
        add(cardNoField);
        cardNoField.setColumns(10);

        pinField = new JTextField();
        pinField.setBounds(120, 180, 300, 30);
        add(pinField);
        pinField.setColumns(10);

        balanceField = new JTextField();
        balanceField.setBounds(120, 220, 300, 30);
        add(balanceField);
        balanceField.setColumns(10);

        clearBut.addActionListener(this);
        createAcc.addActionListener(this);
        backToHome.addActionListener(this);

        setTitle("REGISTER");
        setSize(500,500);
        setLocation(500,100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){

        if (ae.getSource()==clearBut) {
            emailfield.setText("");
            pinField.setText("");
            cardNoField.setText("");
            balanceField.setText("");

        }
        else if (ae.getSource()==backToHome){
            setVisible(false);
            new homepage().setVisible(true);
        }
        else if (ae.getSource()==createAcc){
            String a = emailfield.getText();
            String b = cardNoField.getText();
            String c = pinField.getText();
            String d = balanceField.getText();

            try {
                if (emailfield.getText().equals("") || cardNoField.getText().equals("") || pinField.getText().equals("") || balanceField.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please fill all required fields.");
                }
                else {
                    conn c1 = new conn();
                    String q1 = "insert into login values('"+a+"','"+b+"', '"+c+"', '"+d+"')";
                    c1.s.executeUpdate(q1);

                    setVisible(false);
                    new reg_complete().setVisible(true);

                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }



        }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new SignUp().setVisible(true);
    }
}
