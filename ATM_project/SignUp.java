package com.JonathanATM;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

public class SignUp {
    private static JTextField emailfield;
    private static JTextField cardNoField;
    private static JTextField pinField;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        register();

    }

    public static void register() {
        JFrame frame = new JFrame("SIGN UP");
        frame.setBounds(100,100,500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JButton backToHome = new JButton("BACK");
        backToHome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                frame.setVisible(false);
                homepage home = new homepage();
                home.homescreen();
            }
        });
        backToHome.setBounds(100, 350, 300, 50);
        frame.getContentPane().add(backToHome);

        JButton createAcc = new JButton("CREATE ACCOUNT");
        createAcc.setBounds(100, 275, 300, 50);
        frame.getContentPane().add(createAcc);

        JLabel regTitle = new JLabel("REGISTER");
        regTitle.setFont(new Font("Arial", Font.BOLD, 18));
        regTitle.setHorizontalAlignment(SwingConstants.CENTER);
        regTitle.setBounds(168, 26, 150, 50);
        frame.getContentPane().add(regTitle);

        JLabel email = new JLabel("Email :");
        email.setFont(new Font("Arial", Font.BOLD, 12));
        email.setBounds(50, 125, 60, 30);
        frame.getContentPane().add(email);

        JLabel cardNo = new JLabel("Card no. :");
        cardNo.setFont(new Font("Arial", Font.BOLD, 12));
        cardNo.setBounds(50, 165, 125, 30);
        frame.getContentPane().add(cardNo);

        JLabel pin = new JLabel("PIN :");
        pin.setFont(new Font("Arial", Font.BOLD, 12));
        pin.setBounds(50, 205, 125, 30);
        frame.getContentPane().add(pin);

        emailfield = new JTextField();
        emailfield.setBounds(120, 125, 300, 30);
        frame.getContentPane().add(emailfield);
        emailfield.setColumns(10);

        cardNoField = new JTextField();
        cardNoField.setBounds(120, 165, 300, 30);
        frame.getContentPane().add(cardNoField);
        cardNoField.setColumns(10);

        pinField = new JTextField();
        pinField.setBounds(120, 205, 300, 30);
        frame.getContentPane().add(pinField);
        pinField.setColumns(10);

        frame.setVisible(true);
    }
}
