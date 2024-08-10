package GUI;

import Main.customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Deposit extends JFrame {

    public Deposit(customer loggedInCustomer) {
        getContentPane().setBackground(new Color(255, 204, 204));
        setSize(500, 600);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel bankLabel = new JLabel("426 Bank");
        bankLabel.setFont(new Font("Arial", Font.BOLD, 30));
        bankLabel.setHorizontalAlignment(SwingConstants.CENTER);
        bankLabel.setBounds(120, 30, 300, 50);
        add(bankLabel);

        JLabel enterAmountLabel = new JLabel("Enter the Depositing Amount");
        enterAmountLabel.setFont(new Font("Arial", Font.BOLD, 22));
        enterAmountLabel.setBounds(80, 170, 300, 30);
        add(enterAmountLabel);

        JTextField amountTextField = new JTextField();
        amountTextField.setBounds(80, 220, 300, 30);
        add(amountTextField);

        JButton okButton = new JButton("OK");
        okButton.setBounds(350, 440, 100, 30);
        add(okButton);

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String amountText = amountTextField.getText();
                if (!amountText.isEmpty()) {
                    try {
                        int amount = Integer.parseInt(amountText);

                        loggedInCustomer.customerDeposit(loggedInCustomer, amount);

                        Object[] options = {"OK", "Cancel"};

                        int result = JOptionPane.showOptionDialog(
                                Deposit.this,
                                "Finish...",
                                "Message",
                                JOptionPane.YES_NO_OPTION,
                                JOptionPane.INFORMATION_MESSAGE,
                                null,
                                options,
                                options[0]);

                        if (result == JOptionPane.YES_OPTION) {
                            JOptionPane.showMessageDialog(null, "Deposit successful.", "Success", JOptionPane.INFORMATION_MESSAGE);
                            new Bank(loggedInCustomer);
                            dispose();

                        } else if (result == JOptionPane.NO_OPTION) {
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Please enter a valid amount.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a valid amount.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JButton exitButton = new JButton("BACK");
        exitButton.setBounds(350, 500, 100, 30);
        add(exitButton);

        exitButton.addActionListener(new ActionListener() {
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
        new Deposit(null);
    }
}
