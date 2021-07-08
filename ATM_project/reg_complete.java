package com.JonATM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class reg_complete extends JFrame implements ActionListener{

    JButton retToHome;
    JLabel regMsg, regMsg2;



    reg_complete() {

        regMsg = new JLabel("Thank you for creating an account please return to the");
        regMsg.setHorizontalAlignment(SwingConstants.CENTER);
        regMsg.setFont(new Font("Arial", Font.BOLD, 13));

        regMsg2 = new JLabel(" homepage to login.");
        regMsg2.setHorizontalAlignment(SwingConstants.CENTER);
        regMsg2.setFont(new Font("Arial", Font.BOLD, 13));

        retToHome = new JButton("RETURN TO HOME");
        retToHome.setFocusable(false);
        retToHome.setFont(new Font("Arial", Font.PLAIN, 13));

        setLayout(null);

        regMsg.setBounds(50, 10, 350, 30);
        add(regMsg);

        regMsg2.setBounds(150, 30, 150, 30);
        add(regMsg2);

        retToHome.setBounds(125,80,225,30);
        add(retToHome);



        retToHome.addActionListener(this);


        setTitle("REGISTRATION COMPLETE");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(475,200);
        setLocation(500,100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new homepage().setVisible(true);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new reg_complete().setVisible(true);

    }
}
