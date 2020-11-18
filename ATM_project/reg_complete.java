package com.JonathanATM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class reg_complete {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        register_complete();

    }

    public static void register_complete() {

        JFrame frame = new JFrame("REGISTRATION COMPLETE");
        frame.setBounds(100,100,450,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel regMsg = new JLabel("Thank you for creating an account please return to the");
        regMsg.setHorizontalAlignment(SwingConstants.CENTER);
        regMsg.setFont(new Font("Arial", Font.BOLD, 13));
        regMsg.setBounds(50, 10, 350, 30);
        frame.getContentPane().add(regMsg);

        JLabel regMsg2 = new JLabel(" homepage to login.");
        regMsg2.setHorizontalAlignment(SwingConstants.CENTER);
        regMsg2.setFont(new Font("Arial", Font.BOLD, 13));
        regMsg2.setBounds(150, 40, 150, 30);
        frame.getContentPane().add(regMsg2);

        JButton retToHome = new JButton("RETURN TO HOME");
        retToHome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                frame.setVisible(false);
                homepage home = new homepage();
                home.homescreen();
            }
        });
        retToHome.setFont(new Font("Arial", Font.PLAIN, 13));
        retToHome.setBounds(125, 100, 200, 30);
        frame.getContentPane().add(retToHome);




        frame.setVisible(true);
    }
}
