package com.JonathanATM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SignUp2 extends JFrame implements ActionListener {

    JTextField cardno, pintext, balancetext, reemail;
    JLabel cardNo, pin, balance, regTitle, bank, email2;
    JButton createaccount, clear;

    SignUp2() {
        setLayout(null);

        // LABELS

        regTitle = new JLabel("REGISTER");
        regTitle.setFont(new Font("Arial", Font.BOLD, 18));
        regTitle.setHorizontalAlignment(SwingConstants.CENTER);
        regTitle.setBounds(168, 20, 150, 50);
        add(regTitle);

        bank = new JLabel("Bank Details: ");
        bank.setFont(new Font("Arial", Font.PLAIN, 14));
        bank.setHorizontalAlignment(SwingConstants.CENTER);
        bank.setBounds(168, 50, 150, 50);
        add(bank);

        email2 = new JLabel("Re-enter Email: ");
        email2.setFont(new Font("Arial", Font.BOLD, 12));
        email2.setHorizontalAlignment(SwingConstants.CENTER);
        email2.setBounds(20, 100, 150, 30);
        add(email2);

        cardNo = new JLabel("Card No. :");
        cardNo.setFont(new Font("Arial", Font.BOLD, 12));
        cardNo.setBounds(50, 150, 125, 30);
        add(cardNo);

        pin = new JLabel("5 Digit PIN :");
        pin.setFont(new Font("Arial", Font.BOLD, 12));
        pin.setBounds(50, 200, 125, 30);
        add(pin);

        balance = new JLabel("Balance :");
        balance.setFont(new Font("Arial", Font.BOLD, 12));
        balance.setBounds(50, 250, 125, 30);
        add(balance);

        // TEXTFIELDS

        reemail = new JTextField();
        reemail.setBounds(140, 100, 280, 30);
        add(reemail);
        reemail.setColumns(10);

        cardno = new JTextField();
        cardno.setBounds(120, 150, 300, 30);
        add(cardno);
        cardno.setColumns(10);

        pintext = new JTextField();
        pintext.setBounds(120, 200, 300, 30);
        add(pintext);
        pintext.setColumns(10);

        balancetext = new JTextField();
        balancetext.setBounds(120, 250, 300, 30);
        add(balancetext);
        balancetext.setColumns(10);

        // BUTTONS

        createaccount = new JButton("CREATE ACCOUNT");
        createaccount.setBounds(100, 300, 300, 35);
        createaccount.setFocusable(false);
        add(createaccount);

        clear = new JButton("CLEAR");
        clear.setBounds(100, 375, 300, 35);
        clear.setFocusable(false);
        add(clear);

        clear.addActionListener(this);
        createaccount.addActionListener(this);


        setTitle("SIGN UP 2");
        setSize(500, 500);
        setLocation(500, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);


    }

    public void actionPerformed(ActionEvent ae) {
        try {
            String h = reemail.getText();
            String e = cardno.getText();
            String f = pintext.getText();
            String g = balancetext.getText();

            conn c1 = new conn();


            ResultSet res = c1.s.executeQuery("select email from login where email = '" + h + "'");
            String em = "";
            while (res.next()) {
                em = res.getString("email");
            }


            if (ae.getSource() == clear) {
                reemail.setText("");
                cardno.setText("");
                pintext.setText("");
                balancetext.setText("");
            } else if (ae.getSource() == createaccount) {
                if (cardno.getText().equals("") || pintext.getText().equals("") || balance.getText().equals("") || reemail.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill all required fields.");
                } else if (f.length() != 5) {
                    JOptionPane.showMessageDialog(null, "Please create a pin which is 5 digits long.");
                } else if (!reemail.getText().equals(em)) {
                    JOptionPane.showMessageDialog(null, "Please enter the correct email address.");
                } else {
                    c1 = new conn();
                    String q2 = "update login set cardno = '" + e + "', pin = '" + f + "', balance = '" + g + "' where email = '" + h + "'";
                    try {
                        c1.s.executeUpdate(q2);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }

                    setVisible(false);
                    new reg_complete().setVisible(true);
                }

            }
        } catch (HeadlessException | SQLException e) {
            e.printStackTrace();
        }
    }



    public static void main (String[]args){
        // TODO Auto-generated method stub
        new SignUp2().setVisible(true);
    }
}

