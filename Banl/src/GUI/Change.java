package GUI;

import javax.swing.*;

import Main.customer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.*;

public class Change extends JFrame {

    private JPasswordField p1, p2;
    private JLabel label1, label2, label3;
    private JButton changeButton, backButton;

    public Change(customer loggedInCustomer) {
        getContentPane().setBackground(new Color(255, 204, 204));
        setSize(500, 550);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel bankLabel = new JLabel("426 Bank");
        bankLabel.setFont(new Font("Arial", Font.BOLD, 30));
        bankLabel.setHorizontalAlignment(SwingConstants.CENTER);
        bankLabel.setBounds(120, 30, 300, 50);
        add(bankLabel);

        label1 = new JLabel("CHANGE YOUR PIN");
        label1.setForeground(Color.BLACK); 
        label1.setFont(new Font("System", Font.BOLD, 20));
        label1.setBounds(150, 100, 400, 35);
        add(label1);

        label2 = new JLabel("New PIN: ");
        label2.setForeground(Color.BLACK); 
        label2.setFont(new Font("System", Font.BOLD, 16));
        label2.setBounds(50, 200, 150, 35);
        add(label2);

        p1 = new JPasswordField();
        p1.setBackground(new Color(65, 125, 128));
        p1.setForeground(Color.WHITE);
        p1.setBounds(200, 200, 180, 25);
        p1.setFont(new Font("Raleway", Font.BOLD, 22));
        add(p1);

        label3 = new JLabel("Re-Enter New PIN: ");
        label3.setForeground(Color.BLACK); 
        label3.setFont(new Font("System", Font.BOLD, 16));
        label3.setBounds(50, 250, 400, 35);
        add(label3);

        p2 = new JPasswordField();
        p2.setBackground(new Color(65, 125, 128));
        p2.setForeground(Color.WHITE);
        p2.setBounds(200, 255, 180, 25);
        p2.setFont(new Font("Raleway", Font.BOLD, 22));
        add(p2);

        changeButton = new JButton("CHANGE");
        changeButton.setBounds(100, 350, 150, 35);
        changeButton.setBackground(new Color(65, 125, 128));
        changeButton.setForeground(Color.BLACK); 
        add(changeButton);

        changeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char[] newPINChars = p1.getPassword();
                char[] reEnterNewPINChars = p2.getPassword();
        
                String newPIN = new String(newPINChars);
                String reEnterNewPIN = new String(reEnterNewPINChars);
        
                if (!newPIN.isEmpty() && !reEnterNewPIN.isEmpty()) {
                    if (newPIN.equals(reEnterNewPIN)) {
                        loggedInCustomer.customerChangePIN(loggedInCustomer, loggedInCustomer.getPin(), newPIN);
                        dispose();
                        new Bank(loggedInCustomer);
                    } else {
                        JOptionPane.showMessageDialog(null, "New PINs do not match. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter both new PINs.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        

        backButton = new JButton("BACK");
        backButton.setBounds(300, 350, 150, 35);
        backButton.setBackground(new Color(65, 125, 128));
        backButton.setForeground(Color.BLACK); 
        add(backButton);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Bank(loggedInCustomer);
            }
        });

        ImageIcon backgroundIcon = new ImageIcon(ClassLoader.getSystemResource("back2.png"));
        Image backgroundImage = backgroundIcon.getImage().getScaledInstance(500, 600, Image.SCALE_DEFAULT);
        backgroundIcon = new ImageIcon(backgroundImage);
        JLabel backgroundLabel = new JLabel(backgroundIcon);
        backgroundLabel.setBounds(0, 0, 500, 550);
        add(backgroundLabel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Change(null);
    }
}
