package com.JonathanATM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class check_bal extends JFrame implements ActionListener {

    JLabel title, user, name, bal2, bal;
    JButton back;

    check_bal() {
        String pinn = JOptionPane.showInputDialog("Enter PIN");

        String f = "";
        String l = "";
        String balance = "";

        try {
            conn c1 = new conn();

            ResultSet rs = c1.s.executeQuery("select * from login where pin = '" + pinn + "'");
            while (rs.next()) {
                f = rs.getString("first_name");
                l = rs.getString("last_name");
                balance = rs.getString("balance");
            }

            setLayout(null);

            title = new JLabel("CURRENT BALANCE");
            title.setFont(new Font("Arial", Font.BOLD, 24));
            title.setBounds(120, 40, 300, 50);
            add(title);

            user = new JLabel("User: ");
            user.setFont(new Font("Arial", Font.BOLD, 18));
            user.setBounds(120, 100, 150, 40);
            add(user);

            name = new JLabel(f + " " + l);
            name.setFont(new Font("Arial", Font.PLAIN, 18));
            name.setBounds(120, 150, 250, 40);
            add(name);

            bal = new JLabel("Balance: ");
            bal.setFont(new Font("Arial", Font.BOLD, 18));
            bal.setBounds(120, 200, 150, 40);
            add(bal);

            bal2 = new JLabel(balance);
            bal2.setFont(new Font("Arial", Font.PLAIN, 18));
            bal2.setBounds(120, 250, 150, 40);
            add(bal2);

            back = new JButton("BACK");
            back.setFocusable(false);
            back.setFont(new Font("Arial", Font.PLAIN, 14));
            back.setBounds(100, 360, 280, 40);
            add(back);

            setTitle("CHECK BALANCE");
            setSize(500, 500);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocation(500, 100);

            back.addActionListener(this);

            setVisible(true);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back){
            setVisible(false);
            new menu().setVisible(true);
        }
    }


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new check_bal().setVisible(true);

    }
}
