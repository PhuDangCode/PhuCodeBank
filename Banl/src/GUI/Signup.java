package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import Main.customersignup;


public class Signup extends JFrame{
    Random ran = new Random();

    long first4 = (ran.nextLong() %9000L)+1000L;

    String first = " " + Math.abs(first4);


    JLabel label1, labelname, labelDOB, labelgender,
            labeladdress,labelPhone,labelidentity,
            labelcn, labelxx, label16, labelmes, labelpin, labelpinxx, label4digit;

    JTextField textName, textAddress, textPhone,textIdentity;

    JDateChooser dateChooser;

    JRadioButton r1,r2;

    JButton s,c;


    Signup(){
        super("APPLICATION FORM");
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(370, 10,100,100);
        add(image);

        label1 = new JLabel("APPLICATION FORM NO."+ first);
        label1.setBounds(160,120,600,40);
        label1.setFont(new Font("Raleway", Font.BOLD,38));
        add(label1);


        labelname = new JLabel("Name:");
        labelname.setBounds(100,220,100,30);
        labelname.setFont(new Font("Raleway", Font.BOLD,20));
        add(labelname);

        textName = new JTextField();
        textName.setFont(new Font("Raleway", Font.BOLD,14));
        textName.setBounds(300,220,250,30);
        add(textName);


        labelDOB = new JLabel("Date Of Birth:");
        labelDOB.setFont(new Font("Raleway",Font.BOLD,20));
        labelDOB.setBounds(100,270,200,30);
        add(labelDOB);

        dateChooser = new JDateChooser();
        dateChooser.setForeground(Color.BLACK);
        dateChooser.setBounds(300,270,273,30);
        add(dateChooser);

        labelgender = new JLabel("Gender:");
        labelgender.setBounds(100,320,200,30);
        labelgender.setFont(new Font("Raleway", Font.BOLD,20));
        add(labelgender);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Raleway", Font.BOLD,14));
        r1.setBounds(300,320,60,30);
        add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Raleway", Font.BOLD,14));
        r2.setBounds(450,320,90,30);
        add(r2);

        labeladdress = new JLabel("Address:");
        labeladdress.setBounds(100,370,100,30);
        labeladdress.setFont(new Font("Raleway", Font.BOLD,20));
        add(labeladdress);

        textAddress = new JTextField();
        textAddress.setFont(new Font("Raleway", Font.BOLD,14));
        textAddress.setBounds(300,370,250,30);
        add(textAddress);

        labelPhone = new JLabel("Phone:");
        labelPhone.setBounds(100,420,100,30);
        labelPhone.setFont(new Font("Raleway", Font.BOLD,20));
        add(labelPhone);

        textPhone = new JTextField();
        textPhone.setBounds(300, 420,250, 30);
        textPhone.setFont(new Font("Raleway",Font.BOLD,20));
        add(textPhone);

        labelidentity = new JLabel("Identity Number: ");
        labelidentity.setBounds(100, 470, 100, 30);
        labelidentity.setFont(new Font("Raleway", Font.BOLD, 20));
        add(labelidentity);

        textIdentity = new JTextField();
        textIdentity.setBounds(300, 470, 250, 30);
        textIdentity.setFont(new Font("Raleway", Font.BOLD, 14));
        add(textIdentity);

        labelcn = new JLabel("Card Number:");
        labelcn.setFont(new Font("Raleway",Font.BOLD,18));
        labelcn.setBounds(100,500,200,30);
        add(labelcn);

        label16 = new JLabel("(Your 16-digit Card Number)");
        label16.setFont(new Font("Raleway",Font.BOLD,12));
        label16.setBounds(100,530,200,20);
        add(label16);

        labelxx = new JLabel("XXXX-XXXX-XXXX-1111");
        labelxx.setFont(new Font("Raleway",Font.BOLD,18));
        labelxx.setBounds(330,500,250,30);
        add(labelxx);

        labelmes = new JLabel("(It would appear on atm card/cheque Book and Statements)");
        labelmes.setFont(new Font("Raleway",Font.BOLD,12));
        labelmes.setBounds(330,530,500,20);
        add(labelmes);

        labelpin = new JLabel("PIN:");
        labelpin.setFont(new Font("Raleway",Font.BOLD,18));
        labelpin.setBounds(100,570,200,30);
        add(labelpin);

        labelpinxx = new JLabel("XXXX");
        labelpinxx.setFont(new Font("Raleway",Font.BOLD,18));
        labelpinxx.setBounds(330,570,200,30);
        add(labelpinxx);

        label4digit = new JLabel("(4-digit Password)");
        label4digit.setFont(new Font("Raleway",Font.BOLD,12));
        label4digit.setBounds(100,600,200,20);
        add(label4digit);

        JCheckBox c7 = new JCheckBox("I here by decleares that the above entered details correct to the best of my knlowledge.",true);
        c7.setBackground(new Color(215,252,252));
        c7.setFont(new Font("Raleway",Font.BOLD,12));
        c7.setOpaque(false);
        c7.setContentAreaFilled(false);
        c7.setBorderPainted(false);
        c7.setBounds(100,630,600,20);
        add(c7);

        s = new JButton("Submit");
        s.setFont(new Font("Raleway", Font.BOLD, 14));
        s.setBounds(250, 690, 100, 30);
        add(s);

        c = new JButton("Cancel");
        c.setFont(new Font("Raleway", Font.BOLD, 14));
        c.setBounds(420, 690, 100, 30);
        add(c);


        s.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String name = textName.getText();
                String dob = new SimpleDateFormat("yyyy-MM-dd").format(dateChooser.getDate());
                String gender = r1.isSelected() ? "Male" : "Female";
                String address = textAddress.getText();
                String phone = textPhone.getText();
                String identity = textIdentity.getText();

                customersignup signup = new customersignup(name, dob, gender, address, phone, identity);
                String signupResponse = signup.getResponse();

                Object[] options = {"OK", "Cancel"};

                int result = JOptionPane.showOptionDialog(
                        Signup.this,
                        "Finish...",
                        "Message",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        options,
                        options[0]);

                if (result == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null, signupResponse);
                    new Login();
                    dispose();

                } else if (result == JOptionPane.NO_OPTION) {
                }

            }
        });

        c.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Login();
                dispose();
            }
        });



        ImageIcon iii1 = new ImageIcon(ClassLoader.getSystemResource("back2.png"));
        Image iii2 = iii1.getImage().getScaledInstance(850, 800, Image.SCALE_DEFAULT);
        ImageIcon iii3 = new ImageIcon(iii2);
        JLabel iiimage = new JLabel(iii3);
        iiimage.setBounds(0, 0,850,800);
        add(iiimage);

        setLayout(null);
        setSize(850,800);
        setLocation(360,40);
        setVisible(true);

    }
    public static void main(String[] args){
        new Signup();
    }
}