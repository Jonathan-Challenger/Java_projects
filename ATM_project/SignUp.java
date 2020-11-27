package com.JonathanATM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class SignUp extends JFrame implements ActionListener{
    private static JTextField emailfield, titleField, firstField, lastField;
    JButton backToHome, next, clearBut;
    JLabel regTitle, per, email, title, first, last;




    SignUp() {

        setLayout(null);

        backToHome = new JButton("BACK");
        backToHome.setBounds(100, 375, 300, 35);
        add(backToHome);

        next = new JButton("NEXT");
        next.setBounds(100, 275, 300, 35);
        add(next);

        clearBut = new JButton("CLEAR");
        clearBut.setBounds(100, 325, 300, 35);
        add(clearBut);

        regTitle = new JLabel("REGISTER");
        regTitle.setFont(new Font("Arial", Font.BOLD, 18));
        regTitle.setHorizontalAlignment(SwingConstants.CENTER);
        regTitle.setBounds(168, 20, 150, 50);
        add(regTitle);

        per = new JLabel("Personal Details: ");
        per.setFont(new Font("Arial", Font.PLAIN, 14));
        per.setHorizontalAlignment(SwingConstants.CENTER);
        per.setBounds(168, 50, 150, 50);
        add(per);

        email = new JLabel("Email :");
        email.setFont(new Font("Arial", Font.BOLD, 12));
        email.setBounds(50, 100, 60, 30);
        add(email);

        title = new JLabel("Title :");
        title.setFont(new Font("Arial", Font.BOLD, 12));
        title.setBounds(50, 140, 125, 30);
        add(title);

        first = new JLabel("First Name :");
        first.setFont(new Font("Arial", Font.BOLD, 12));
        first.setBounds(50, 180, 125, 30);
        add(first);

        last = new JLabel("Last Name :");
        last.setFont(new Font("Arial", Font.BOLD, 12));
        last.setBounds(50, 220, 125, 30);
        add(last);

        emailfield = new JTextField();
        emailfield.setBounds(120, 100, 300, 30);
        add(emailfield);
        emailfield.setColumns(10);

        titleField = new JTextField();
        titleField.setBounds(120, 140, 300, 30);
        add(titleField);
        titleField.setColumns(10);

        firstField = new JTextField();
        firstField.setBounds(120, 180, 300, 30);
        add(firstField);
        firstField.setColumns(10);

        lastField = new JTextField();
        lastField.setBounds(120, 220, 300, 30);
        add(lastField);
        lastField.setColumns(10);

        clearBut.addActionListener(this);
        next.addActionListener(this);
        backToHome.addActionListener(this);

        setTitle("SIGN UP");
        setSize(500,500);
        setLocation(500,100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){

        if (ae.getSource()==clearBut) {
            emailfield.setText("");
            firstField.setText("");
            titleField.setText("");
            lastField.setText("");

        }
        else if (ae.getSource()==backToHome){
            setVisible(false);
            new homepage().setVisible(true);
        }
        else if (ae.getSource()==next){
            String a = emailfield.getText();
            String b = titleField.getText();
            String c = firstField.getText();
            String d = lastField.getText();

            try {
                if (emailfield.getText().equals("") || titleField.getText().equals("") || firstField.getText().equals("") || lastField.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please fill all required fields.");
                }
                else {
                    conn c1 = new conn();
                    String q1 = "insert into login values(null, '"+a+"','"+b+"', '"+c+"', '"+d+"', null, null, null)";
                    c1.s.executeUpdate(q1);

                    setVisible(false);
                    new SignUp2().setVisible(true);

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