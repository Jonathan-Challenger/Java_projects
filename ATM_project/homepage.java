package com.JonathanATM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class homepage {

    private JFrame frame;
    private JPanel panel;
    private JLabel card;
    private JLabel pin;
    private JTextField cardt;
    private JTextField pint;
    private JLabel welcome;

    public static void homescreen() {

        JPanel panel = new JPanel();
        JFrame frame = new JFrame();
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("AUTOMATED TELLER MACHINE");
        frame.add(panel);

        panel.setLayout(null);

        JLabel welcome = new JLabel("WELCOME TO ATM");
        welcome.setBounds(120, 100, 300, 50);
        welcome.setFont(new Font("Arial", Font.BOLD, 28));
        panel.add(welcome);

        JLabel card = new JLabel("Card no. :");
        card.setBounds(100,175,100,50 );
        card.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(card);

        JTextField cardt = new JTextField();
        cardt.setBounds(200,190,175,25);
        panel.add(cardt);

        JLabel pin = new JLabel("PIN :");
        pin.setBounds(100,225,100,50 );
        pin.setFont(new Font("Arial", Font.BOLD, 18));
        panel.add(pin);

        JPasswordField pint = new JPasswordField();
        pint.setBounds(200, 240, 175, 25);
        panel.add(pint);

        JButton sign_in = new JButton("SIGN IN");
        sign_in.setBounds(100, 300, 125, 30);
        panel.add(sign_in);

        JButton cancel = new JButton("CANCEL");
        cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                pint.setText("");
                cardt.setText("");

            }
        });
        cancel.setBounds(250, 300, 125, 30);
        panel.add(cancel);

        JButton sign_up = new JButton("SIGN UP");
        sign_up.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                frame.setVisible(false);
                SignUp reg = new SignUp();
                reg.register();
            }
        });
        sign_up.setBounds(100, 350, 275, 30);
        panel.add(sign_up);

        frame.setVisible(true);

    }

    public static void main(String[] args) {
        homescreen();
    }
}
