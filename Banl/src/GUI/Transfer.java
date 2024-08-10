package GUI;

import javax.swing.*;

import Database.connectSQL;
import Main.customer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;
import java.awt.*;

public class Transfer extends JFrame {

    Random ran = new Random();

    long first4 = (ran.nextLong() %9000L)+1000L;

    String first = " " + Math.abs(first4);

    private JTextField cardNoTextField, nameTextField, amountTextField;
    private JLabel cardNoLabel, nameLabel, amountLabel;
    private JButton transferButton, backupButton,checkButton;

    public Transfer(customer loggedInCustomer) {
        getContentPane().setBackground(new Color(255, 204, 204));
        setSize(500, 600);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel bankLabel = new JLabel("426 Bank");
        bankLabel.setFont(new Font("Arial", Font.BOLD, 30));
        bankLabel.setHorizontalAlignment(SwingConstants.CENTER);
        bankLabel.setBounds(120, 30, 300, 50);
        add(bankLabel);

        cardNoLabel = new JLabel("Choose Card_No");
        cardNoLabel.setBounds(160, 100, 200, 30);
        cardNoLabel.setFont(new Font("Arial", Font.BOLD,20));
        add(cardNoLabel);

        cardNoTextField = new JTextField();
        cardNoTextField.setBounds(50, 150, 400, 30);
        add(cardNoTextField);

        nameLabel = new JLabel("Name");
        nameLabel.setBounds(160, 200, 200, 30);
        nameLabel.setFont(new Font("Arial", Font.BOLD,20));
        add(nameLabel);

        nameTextField = new JTextField();
        nameTextField.setBounds(50, 250, 400, 30);
        nameTextField.setEditable(false);
        add(nameTextField);

        amountLabel = new JLabel("Enter Amount");
        amountLabel.setBounds(160, 300, 150, 30);
        amountLabel.setFont(new Font("Arial", Font.BOLD,20));
        add(amountLabel);

        amountTextField = new JTextField();
        amountTextField.setBounds(50, 350, 400, 30);
        add(amountTextField);

        transferButton = new JButton("Transfer");
        transferButton.setBounds(100, 420, 100, 40);
        add(transferButton);


        checkButton = new JButton("Check");
        checkButton.setBounds(300, 420, 100, 40);
        add(checkButton);

        JButton transferHistoryButton = new JButton("Transfer History");
        transferHistoryButton.setBounds(50, 500, 100, 40);
        add(transferHistoryButton);
        transferHistoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new TransferHistory(loggedInCustomer);
            }
        });

        backupButton = new JButton("Back");
        backupButton.setBounds(350, 500, 100, 40);
        add(backupButton);

        transferButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String acc1 = cardNoTextField.getText();
                String amount = amountTextField.getText();

                Object[] options = {"OK", "Cancel"};

                
                int result2 = JOptionPane.showOptionDialog(
                        Transfer.this,
                        "Confirm?",
                        "Confirm",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        options,
                        options[0]);

           
                if (result2 == JOptionPane.YES_OPTION) {
                } else if (result2 == JOptionPane.NO_OPTION) {
                    return;
                }

                if (!amount.isEmpty()) {
                    try {
                        loggedInCustomer.customerTrans(loggedInCustomer, acc1, amount);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Please enter a valid amount.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a valid amount.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                int result = JOptionPane.showOptionDialog(
                        Transfer.this,
                        "Finish...",
                        "Message",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        options,
                        options[0]);

                if (result == JOptionPane.YES_OPTION) {
                    new Bank(loggedInCustomer);
                    dispose();

                } else if (result == JOptionPane.NO_OPTION) {
                }
            }
        });

        checkButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String card = cardNoTextField.getText();
                try {
                    connectSQL con = new connectSQL();

                    PreparedStatement getName = con.connection.prepareStatement("SELECT name FROM customer C join people P on C.identity_number = P.identity_number where C.card_no = ?");
                    getName.setString(1, card);

                    ResultSet resultSet = getName.executeQuery();

                    while (resultSet.next()) {
                        String name = resultSet.getString("name");
                        nameTextField.setText(name);
                    }


                } catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });
        backupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Bank(loggedInCustomer);
            }
        });


        ImageIcon backgroundIcon = new ImageIcon(ClassLoader.getSystemResource("back2.png"));
        Image backgroundImage = backgroundIcon.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
        backgroundIcon = new ImageIcon(backgroundImage);
        JLabel backgroundLabel = new JLabel(backgroundIcon);
        backgroundLabel.setBounds(0, 0, 800, 600);
        add(backgroundLabel);

        setVisible(true);
    }


    public static void main(String[] args) {
        new Transfer(null);
    }
}
