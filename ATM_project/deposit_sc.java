package com.JonathanATM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class deposit_sc extends JFrame implements ActionListener {

    JButton deposit, back;
    JLabel title, l1, l2, pinl;
    JTextField dep, pin;

    deposit_sc() {
        setLayout(null);

        // Labels

        title = new JLabel("DEPOSIT");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setBounds(180, 40, 150, 50);
        add(title);

        l1 = new JLabel("Please enter the amount you would like");
        l1.setFont(new Font("Arial", Font.PLAIN, 14));
        l1.setBounds(100, 100, 300, 50);
        add(l1);

        l2 = new JLabel("to deposit: ");
        l2.setFont(new Font("Arial", Font.PLAIN, 14));
        l2.setBounds(100, 120, 300, 50);
        add(l2);

        pinl = new JLabel("Enter PIN: ");
        pinl.setFont(new Font("Arial", Font.PLAIN, 14));
        pinl.setBounds(100, 200, 150, 30);
        add(pinl);

        // Textfields

        dep = new JTextField();
        dep.setBounds(100, 160, 280, 40);
        dep.setFont(new Font("Arial", Font.PLAIN, 16));
        add(dep);
        dep.setColumns(10);

        pin = new JTextField();
        pin.setBounds(100, 230, 280, 40);
        pin.setFont(new Font("Arial", Font.PLAIN, 16));
        add(pin);
        pin.setColumns(10);

        // Buttons

        deposit = new JButton("DEPOSIT");
        deposit.setFocusable(false);
        deposit.setFont(new Font("Arial", Font.PLAIN, 14));
        deposit.setBounds(100, 300, 280, 40);
        add(deposit);

        back = new JButton("BACK");
        back.setFocusable(false);
        back.setFont(new Font("Arial", Font.PLAIN, 14));
        back.setBounds(100, 360, 280, 40);
        add(back);

        deposit.addActionListener(this);
        back.addActionListener(this);

        setTitle("DEPOSIT");
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(500,100);

        setVisible(true);
    }


    public void actionPerformed(ActionEvent ae) {
        try{
            String depo = dep.getText();
            String pinn = pin.getText();

            conn c1 = new conn();

            ResultSet pins = c1.s.executeQuery("select pin from login where pin = '"+pinn+"'");

            String p = "";
            while (pins.next()) {
                p = pins.getString("pin");
            }

            if (ae.getSource() == back) {
                setVisible(false);
                new menu().setVisible(true);
            }
            else if (ae.getSource() == deposit){
                if (dep.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter the amount you would like to deposit.");
                }
                else if (pin.getText().equals(p)){
                    double i = Double.parseDouble(depo);

                    c1 = new conn();

                    ResultSet rs = c1.s.executeQuery("select balance from login where pin = '"+pinn+"'");

                    double d = 0;
                    while (rs.next()) {
                        d = rs.getDouble("balance");
                    }


                    String q3 = "update login set balance = '"+d+"' + '"+i+"' where pin = '"+pinn+"'";
                    c1.s.executeUpdate(q3);

                    JOptionPane.showMessageDialog(null, "Deposit successful.");

                    setVisible(false);
                    new menu().setVisible(true);

                }
                else {
                    JOptionPane.showMessageDialog(null, "Please enter the correct pin.");
                }
            }
        } catch (HeadlessException | SQLException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new deposit_sc().setVisible(true);

    }
}
