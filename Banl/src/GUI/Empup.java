package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import Main.employeesignup;
import javax.swing.JOptionPane;
import com.toedter.calendar.JDateChooser;


public class Empup extends JFrame {
    Random ran = new Random();
    long first4 = (ran.nextLong() % 9000L) + 1000L;
    String first = " " + Math.abs(first4);

    JLabel label1, labelname, labelfname, labelDOB, labelgender, labelemail, labeladdress, labelPhone, labelidentity,
            labelcn, labelxx, label16, labelmes, labelpin, labelpinxx, label4digit, labelAmount, labelposition,labelid;

    JTextField textName, textFname, textEmail, textAddress, textPhone, textIdentity, textAccount, textPassword,textEmpid,
            textAmount;

    JDateChooser dateChooser;

    JRadioButton r1, r2, m1, m2, m3;

    JButton next, s, c, g;

    JComboBox<String> roleComboBox;

    Empup() {
        super("APPLICATION FORM");
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(25, 10, 100, 100);
        add(image);

        label1 = new JLabel("APPLICATION FORM NO." + first);
        label1.setBounds(160, 20, 600, 40);
        label1.setFont(new Font("Raleway", Font.BOLD, 38));
        add(label1);

        labelid = new JLabel("Emp_Id:");
        labelid.setBounds(100, 120, 100, 30);
        labelid.setFont(new Font("Raleway", Font.BOLD, 20));
        add(labelid);

        textEmpid = new JTextField();
        textEmpid.setEditable(false);
        textEmpid.setBounds(300, 120, 250, 30);
        textEmpid.setFont(new Font("Raleway", Font.BOLD, 14));
        add(textEmpid);

        labelname = new JLabel("Name:");
        labelname.setBounds(100, 170, 100, 30);
        labelname.setFont(new Font("Raleway", Font.BOLD, 20));
        add(labelname);

        textName = new JTextField();
        textName.setFont(new Font("Raleway", Font.BOLD, 14));
        textName.setBounds(300, 170, 250, 30);
        add(textName);

        labelDOB = new JLabel("Date Of Birth:");
        labelDOB.setFont(new Font("Raleway", Font.BOLD, 20));
        labelDOB.setBounds(100, 220, 200, 30);
        add(labelDOB);

        dateChooser = new JDateChooser();
        dateChooser.setForeground(Color.BLACK);
        dateChooser.setBounds(300, 220, 248, 30);
        add(dateChooser);

        labelgender = new JLabel("Gender:");
        labelgender.setBounds(100, 270, 200, 30);
        labelgender.setFont(new Font("Raleway", Font.BOLD, 20));
        add(labelgender);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Raleway", Font.BOLD, 14));
        r1.setBounds(300, 270, 60, 30);
        add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Raleway", Font.BOLD, 14));
        r2.setBounds(450, 270, 90, 30);
        add(r2);

        labeladdress = new JLabel("Address:");
        labeladdress.setBounds(100, 320, 100, 30);
        labeladdress.setFont(new Font("Raleway", Font.BOLD, 20));
        add(labeladdress);

        textAddress = new JTextField();
        textAddress.setFont(new Font("Raleway", Font.BOLD, 14));
        textAddress.setBounds(300, 320, 250, 30);
        add(textAddress);

        labelPhone = new JLabel("Phone:");
        labelPhone.setBounds(100, 370, 100, 30);
        labelPhone.setFont(new Font("Raleway", Font.BOLD, 20));
        add(labelPhone);

        textPhone = new JTextField();
        textPhone.setBounds(300, 370, 250, 30);
        textPhone.setFont(new Font("Raleway", Font.BOLD, 20));
        add(textPhone);

        labelidentity = new JLabel("Identity Number: ");
        labelidentity.setBounds(100, 420, 100, 30);
        labelidentity.setFont(new Font("Raleway", Font.BOLD, 20));
        add(labelidentity);

        textIdentity = new JTextField();
        textIdentity.setBounds(300, 420, 250, 30);
        textIdentity.setFont(new Font("Raleway", Font.BOLD, 14));
        add(textIdentity);

        labelcn = new JLabel("Account:");
        labelcn.setFont(new Font("Raleway", Font.BOLD, 20));
        labelcn.setBounds(100, 470, 200, 30);
        add(labelcn);

        textAccount = new JTextField();
        textAccount.setEditable(false);
        textAccount.setFont(new Font("Raleway", Font.BOLD, 18));
        textAccount.setBounds(300, 470, 250, 30);
        add(textAccount);

        labelpin = new JLabel("Password:");
        labelpin.setFont(new Font("Raleway", Font.BOLD, 20));
        labelpin.setBounds(100, 520, 200, 30);
        add(labelpin);

        textPassword = new JTextField();
        textPassword.setFont(new Font("Raleway", Font.BOLD, 18));
        textPassword.setBounds(300, 520, 250, 30);
        add(textPassword);

        labelAmount = new JLabel("Salary:");
        labelAmount.setFont(new Font("Raleway", Font.BOLD, 20));
        labelAmount.setBounds(100, 570, 200, 30);
        add(labelAmount);

        textAmount = new JTextField();
        textAmount.setEditable(false);
        textAmount.setFont(new Font("Raleway", Font.BOLD, 18));
        textAmount.setBounds(300, 570, 250, 30);
        add(textAmount);

        labelposition = new JLabel("Position:");
        labelposition.setFont(new Font("Raleway", Font.BOLD, 20));
        labelposition.setBounds(100, 620, 200, 30);
        add(labelposition);

        String[] roles = {"Admin", "Manager", "Bank Teller"};
        roleComboBox = new JComboBox<>(roles);
        roleComboBox.setBounds(300, 620, 150, 30);
        roleComboBox.setForeground(Color.BLACK);
        roleComboBox.setBackground(Color.WHITE);
        roleComboBox.setFont(new Font("Arial", Font.BOLD, 14));
        add(roleComboBox);

        g = new JButton("Get Account");
        g.setFont(new Font("Raleway", Font.BOLD, 14));
        g.setBackground(Color.BLACK);
        g.setForeground(Color.WHITE);
        g.setBounds(600, 545, 150, 30);
        add(g);

        s = new JButton("Submit");
        s.setFont(new Font("Raleway", Font.BOLD, 14));
        s.setBackground(Color.BLACK);
        s.setForeground(Color.WHITE);
        s.setBounds(250, 690, 100, 30);
        add(s);

        c = new JButton("Cancel");
        c.setFont(new Font("Raleway", Font.BOLD, 14));
        c.setBackground(Color.BLACK);
        c.setForeground(Color.WHITE);
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
                String account = textAccount.getText();
                String password = textPassword.getText();
                String emp_id = textEmpid.getText();
                String position = (String) roleComboBox.getSelectedItem();
                String salary = textAmount.getText();


                employeesignup signup = new employeesignup(name, dob, gender, address, phone, identity, account, password,
                        emp_id, position, salary);
                String signupResponse = signup.getResponse();

                JOptionPane.showMessageDialog(null, signupResponse);
                dispose();
                new Empin();

            }
        });

        g.addActionListener(e -> getAccount());
        c.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Empin();
            }
        });

        

        ImageIcon iii1 = new ImageIcon(ClassLoader.getSystemResource("back2.png"));
        Image iii2 = iii1.getImage().getScaledInstance(850, 800, Image.SCALE_DEFAULT);
        ImageIcon iii3 = new ImageIcon(iii2);
        JLabel iiimage = new JLabel(iii3);
        iiimage.setBounds(0, 0, 850, 800);
        add(iiimage);

        setLayout(null);
        setSize(850, 800);
        setLocation(360, 40);
        setVisible(true);
    }

    private void getAccount() {
        String selectedRole = (String) roleComboBox.getSelectedItem();
        double salary;
        String accountPrefix;

        switch (selectedRole) {
            case "Admin":
                salary = 5000;
                accountPrefix = "AD";
                break;
            case "Manager":
                salary = 6000;
                accountPrefix = "MN";
                break;
            case "Bank Teller":
                salary = 3000;
                accountPrefix = "BT";
                break;
            default:
                salary = 0;
                accountPrefix = "";
        }

        textAmount.setText(String.valueOf(salary));
        textAccount.setText(generateAccountNumber(accountPrefix));
        textEmpid.setText(generateID(accountPrefix));
    }

    private String generateAccountNumber(String prefix) {
        int random4Digit = (int) (Math.random() * 9000) + 1000;
        return prefix + random4Digit;
    }

    private String generateID(String prefix) {
        int random4Digit = (int) (Math.random() * 90000) + 10000;
        return prefix + random4Digit;
    }

    public static void main(String[] args) {
        new Empup();
    }
}
