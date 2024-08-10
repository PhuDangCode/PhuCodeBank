package GUI;
import Main.customer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame{
    JLabel label1, label2, label3 ;

    JTextField textField2;

    JPasswordField passwordField3;

    JButton button1, button2, button3;

    Login(){
        super("Bank Management System");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380, 10,100,100);
        add(image);     

        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("card.png"));
        Image ii2 = ii1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon ii3 = new ImageIcon(ii2);
        JLabel iimage = new JLabel(ii3);
        iimage.setBounds(210, 350,100,100);
        add(iimage);   

        label1 = new JLabel("WELCOME TO 426BANK");
        label1.setForeground(Color.BLACK);
        label1.setFont(new Font("AvantGrade",Font.BOLD,38));
        label1.setBounds(210,125,450,40);
        add(label1);

        label2 = new JLabel("CARD NO: ");
        label2.setForeground(Color.BLACK);
        label2.setFont(new Font("Ralway",Font.BOLD,28));
        label2.setBounds(150+30,190,375,30);
        add(label2);

        textField2 = new JTextField(15);
        textField2.setBounds(300+30,190,230,30);
        textField2.setFont(new Font("Arital",Font.BOLD,14));
        add(textField2);

        label3 = new JLabel("PIN: ");
        label3.setForeground(Color.BLACK);
        label3.setFont(new Font("Ralway",Font.BOLD,28));
        label3.setBounds(150+30,250,375,30);
        add(label3);

        passwordField3 = new JPasswordField(15);
        passwordField3.setBounds(300+30,250,230,30);
        passwordField3.setFont(new Font("Arital",Font.BOLD,14));
        add(passwordField3);

        button1 = new JButton("SIGN IN");
        button1.setFont(new Font("Arital",Font.BOLD,14));
        button1.setBounds(300+30,300,100,30);
        add(button1);

        button2 = new JButton("CLEAR");
        button2.setFont(new Font("Arital",Font.BOLD,14));
        button2.setBounds(430+30,300,100,30);
        add(button2);

        button3 = new JButton("SIGN UP");
        button3.setFont(new Font("Arital",Font.BOLD,14));
        button3.setBounds(300+30,350,230,30);
        add(button3);

        ImageIcon iii1 = new ImageIcon(ClassLoader.getSystemResource("back2.png"));
        Image iii2 = iii1.getImage().getScaledInstance(850, 480, Image.SCALE_DEFAULT);
        ImageIcon iii3 = new ImageIcon(iii2);
        JLabel iiimage = new JLabel(iii3);
        iiimage.setBounds(0, 0,850,480);
        add(iiimage);   


        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String card = textField2.getText();
                char[] passwordChars = passwordField3.getPassword();
                String pin = new String(passwordChars);

                customer cus = new customer(card, pin);
                customer loggedInCustomer = cus.customerlogin(cus);

                if (loggedInCustomer != null) {

                    JOptionPane.showMessageDialog(null, "Success");
                    new Bank(loggedInCustomer);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Wrong");
                }
            }
        });

        
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textField2.setText("");
                passwordField3.setText("");
            }
        });

        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); 
                new Signup(); 
            }
        });

        setLayout(null);
        setSize(850, 480);
        setLocation(450,200);
        setVisible(true);   
       
    }   
    
    public static void main(String[] args){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        new Login();
    }    
}
