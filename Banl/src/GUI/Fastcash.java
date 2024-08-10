package GUI;

import javax.swing.*;

import Main.customer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Fastcash extends JFrame {

    JButton b1, b2, b3, b4, b5, b6, b7;

    public Fastcash(customer loggedInCustomer) {
        getContentPane().setBackground(new Color(255, 204, 204));
        setSize(500, 600);
        setLocationRelativeTo(null);
        setLayout(null);

         
        JLabel bankLabel = new JLabel("426 Bank");
        bankLabel.setFont(new Font("Arial", Font.BOLD, 30));
        bankLabel.setHorizontalAlignment(SwingConstants.CENTER);
        bankLabel.setBounds(120, 30, 300, 50);
        add(bankLabel);

        b1 = new JButton("$ 100");
        b1.setBounds(50, 150, 150, 35);
        add(b1);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loggedInCustomer.customerFastCash(loggedInCustomer, 100);
                JOptionPane.showMessageDialog(null, "Transaction successful.", "Success", JOptionPane.INFORMATION_MESSAGE);
                new Bank(loggedInCustomer);
                dispose();
            }
        });


        b2 = new JButton("$ 500");
        b2.setBounds(300, 150, 150, 35);
        add(b2);

         b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loggedInCustomer.customerFastCash(loggedInCustomer, 500);
                JOptionPane.showMessageDialog(null, "Transaction successful.", "Success", JOptionPane.INFORMATION_MESSAGE);
                new Bank(loggedInCustomer);
                dispose();
            }
        });


        b3 = new JButton("$ 1000");
        b3.setBounds(50, 250, 150, 35);
        add(b3);

         b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loggedInCustomer.customerFastCash(loggedInCustomer, 1000);
                JOptionPane.showMessageDialog(null, "Transaction successful.", "Success", JOptionPane.INFORMATION_MESSAGE);
                new Bank(loggedInCustomer);
                dispose();
            }
        });


        b4 = new JButton("$ 2000");
        b4.setBounds(300, 250, 150, 35);
        add(b4);

         b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loggedInCustomer.customerFastCash(loggedInCustomer, 2000);
                JOptionPane.showMessageDialog(null, "Transaction successful.", "Success", JOptionPane.INFORMATION_MESSAGE);
                new Bank(loggedInCustomer);
                dispose();
            }
        });

        b5 = new JButton("$ 5000");
        b5.setBounds(50, 350, 150, 35);
        add(b5);
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loggedInCustomer.customerFastCash(loggedInCustomer, 5000);
                JOptionPane.showMessageDialog(null, "Transaction successful.", "Success", JOptionPane.INFORMATION_MESSAGE);
                new Bank(loggedInCustomer);
                dispose();
            }
        });


        b6 = new JButton("$ 10000");
        b6.setBounds(300, 350, 150, 35);
        add(b6);
         b6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loggedInCustomer.customerFastCash(loggedInCustomer, 10000);
                JOptionPane.showMessageDialog(null, "Transaction successful.", "Success", JOptionPane.INFORMATION_MESSAGE);
                new Bank(loggedInCustomer);
                dispose();

            }
        });


        b7 = new JButton("BACK");
        b7.setBounds(350, 500, 100, 30);
        add(b7);
        b7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Bank(loggedInCustomer);
            }
        });

        setLayout(new BorderLayout());

        ImageIcon backgroundIcon = new ImageIcon(ClassLoader.getSystemResource("back2.png"));
        Image backgroundImage = backgroundIcon.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
        backgroundIcon = new ImageIcon(backgroundImage);
        JLabel backgroundLabel = new JLabel(backgroundIcon);
        add(backgroundLabel);

        setVisible(true);
    }


    public static void main(String[] args) {
        new Fastcash(null);
    }
}
