package GUI;

import javax.swing.*;

import Main.customer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.*;

public class Bank extends JFrame {

   public Bank(customer loggedInCustomer) {
        getContentPane().setBackground(new Color(255, 204, 204));
        setSize(500, 600);
        setLocationRelativeTo(null);
        setLayout(null);

      
        JLabel bankLabel = new JLabel("426 Bank");
        bankLabel.setFont(new Font("Arial", Font.BOLD, 30));
        bankLabel.setHorizontalAlignment(SwingConstants.CENTER);
        bankLabel.setBounds(100, 30, 300, 50);
        add(bankLabel);

        JLabel helloLabel = new JLabel("Hello " + loggedInCustomer.getName());
        helloLabel.setFont(new Font("Arial", Font.BOLD, 15));
        helloLabel.setBounds(50, 100, 400, 30);
        add(helloLabel);

        JLabel nameLabel = new JLabel("Card number: " + loggedInCustomer.getCardNumber());
        nameLabel.setFont(new Font("Arial", Font.BOLD, 15));
        nameLabel.setBounds(50, 130, 400, 30);
        add(nameLabel);

        JLabel balanceLabel = new JLabel("Balance Inquiry: " + loggedInCustomer.getAmount());
        balanceLabel.setFont(new Font("Arial", Font.BOLD, 15));
        balanceLabel.setBounds(50, 160, 420, 30);
        add(balanceLabel);

        JButton transferButton = new JButton("Transfer");
        transferButton.setFont(new Font("Arital",Font.BOLD,14));
        transferButton.setBounds(50, 250, 100, 30);
        add(transferButton);

        JButton depositButton = new JButton("Deposit");
        depositButton.setFont(new Font("Arital",Font.BOLD,14));
        depositButton.setBounds(200, 250, 100, 30);
        add(depositButton);

        JButton fastCashButton = new JButton("FastCash");
        fastCashButton.setFont(new Font("Arital",Font.BOLD,14));
        fastCashButton.setBounds(50, 310, 100, 30);
        add(fastCashButton);

        JButton withdrawalButton = new JButton("Widrawal");
        withdrawalButton.setFont(new Font("Arital",Font.BOLD,14));
        withdrawalButton.setBounds(200, 310, 100, 30);
        add(withdrawalButton);

        JButton statementButton = new JButton("History");
        statementButton.setFont(new Font("Arital",Font.BOLD,14));
        statementButton.setBounds(350, 380, 100, 30);
        add(statementButton);

        
        JButton changePinButton = new JButton("Change Pin");
        changePinButton.setFont(new Font("Arital",Font.BOLD,14));
        changePinButton.setBounds(350, 440, 100, 30);
        add(changePinButton);

        JButton exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Arital",Font.BOLD,14));
        exitButton.setBounds(350, 500, 100, 30);
        add(exitButton);

    
        transferButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); 
                new Transfer(loggedInCustomer); 
            }
        });

        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); 
                new Deposit(loggedInCustomer); 
            }
        });

       
        fastCashButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); 
                new Fastcash(loggedInCustomer); 
            }
        });

        withdrawalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); 
                new Withdrawal(loggedInCustomer); 
            }
        });

       
        changePinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); 
                new Change(loggedInCustomer); 
            }
        });

        statementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); 
                new Mini(loggedInCustomer); 
            }
        });
       
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 dispose(); 
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
        new Bank(null);
    }
}
