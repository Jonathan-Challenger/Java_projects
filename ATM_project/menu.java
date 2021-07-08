package com.JonATM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class menu extends JFrame implements ActionListener {

    JButton deposit, withdraw, logout, bal;
    JLabel title;


    menu() {
        setLayout(null);

        title = new JLabel("Main Menu");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setBounds(170, 40, 150, 50);
        add(title);

        bal = new JButton("CHECK BALANCE");
        bal.setFocusable(false);
        bal.setFont(new Font("Arial", Font.PLAIN, 13));
        bal.setBounds(75, 125, 325, 40);
        add(bal);

        deposit = new JButton("DEPOSIT");
        deposit.setFocusable(false);
        deposit.setFont(new Font("Arial", Font.PLAIN, 13));
        deposit.setBounds(75,200,325,40);
        add(deposit);

        withdraw = new JButton("WITHDRAW");
        withdraw.setFocusable(false);
        withdraw.setFont(new Font("Arial", Font.PLAIN, 13));
        withdraw.setBounds(75,275,325,40);
        add(withdraw);

        logout = new JButton("LOGOUT");
        logout.setFocusable(false);
        logout.setFont(new Font("Arial", Font.PLAIN, 13));
        logout.setBounds(75,350,325,40);
        add(logout);

        bal.addActionListener(this);
        deposit.addActionListener(this);
        withdraw.addActionListener(this);
        logout.addActionListener(this);

        setTitle("MAIN MENU");
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(500,100);
        getContentPane().setBackground(Color.WHITE);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == deposit){
            setVisible(false);
            new deposit_sc().setVisible(true);
        }
        else if (ae.getSource() == withdraw){
            setVisible(false);
            new withdraw_sc().setVisible(true);
        }
        else if (ae.getSource() == logout) {
            setVisible(false);
            new homepage().setVisible(true);
        }
        else if (ae.getSource() == bal){
            setVisible(false);
            new check_bal().setVisible(true);
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new menu().setVisible(true);

    }
}
