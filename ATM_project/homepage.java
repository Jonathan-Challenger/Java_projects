package com.JonATM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class homepage extends JFrame implements ActionListener {

    JLabel welcome, card, pin;
    JButton sign_up, sign_in, cancel;
    JTextField cardt, pint;


    homepage() {

        setLayout(null);

        welcome = new JLabel("WELCOME TO ATM");
        welcome.setBounds(120, 50, 300, 50);
        welcome.setFont(new Font("Arial", Font.BOLD, 28));
        add(welcome);

        card = new JLabel("Card no. :");
        card.setBounds(100,175,100,50 );
        card.setFont(new Font("Arial", Font.BOLD, 18));
        add(card);

        pin = new JLabel("PIN :");
        pin.setBounds(100,225,100,50 );
        pin.setFont(new Font("Arial", Font.BOLD, 18));
        add(pin);

        cardt = new JTextField();
        cardt.setBounds(200,190,175,25);
        add(cardt);

        pint = new JTextField();
        pint.setBounds(200, 240, 175, 25);
        add(pint);

        sign_in = new JButton("SIGN IN");
        sign_in.setBounds(100, 300, 125, 30);
        add(sign_in);

        cancel = new JButton("CLEAR");
        cancel.setBounds(250, 300, 125, 30);
        add(cancel);

        sign_up = new JButton("CREATE ACCOUNT");
        sign_up.setBounds(100, 350, 275, 30);
        add(sign_up);

        sign_in.addActionListener(this);
        sign_up.addActionListener(this);
        cancel.addActionListener(this);

        setSize(500,500);
        setTitle("AUTOMATED TELLER MACHINE");
        setLocation(500,100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){

        try {

            conn c1 = new conn();
            String a = cardt.getText();
            String b = pint.getText();
            String q = "select * from login where cardno = '"+a+"' and pin = '"+b+"'";
            ResultSet rs = c1.s.executeQuery(q);

            if (ae.getSource() == sign_in){
                if (rs.next()) {
                    setVisible(false);
                    new menu().setVisible(true);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Incorrect card number or pin.");
                }
            }
            else if (ae.getSource() == cancel){
                pint.setText("");
                cardt.setText("");
            }
            else if (ae.getSource() == sign_up){
                setVisible(false);
                new SignUp().setVisible(true);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        new homepage().setVisible(true);
    }


}