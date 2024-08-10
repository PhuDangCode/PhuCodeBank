package GUI;

import Main.customer;
import Main.transferhistory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TransferHistory extends JFrame {

    private JLabel cardNoLabel;
    private JTextArea historyTextArea;

    public TransferHistory(customer loggedInCustomer) {
        getContentPane().setBackground(new Color(255, 204, 204));
        setSize(500, 600);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel bankLabel = new JLabel("426 Bank");
        bankLabel.setFont(new Font("Arial", Font.BOLD, 30));
        bankLabel.setHorizontalAlignment(SwingConstants.CENTER);
        bankLabel.setBounds(120, 30, 300, 50);
        add(bankLabel);

        cardNoLabel = new JLabel("Card_no: " + loggedInCustomer.getCardNumber());
        cardNoLabel.setBounds(50, 100, 100, 20);
        add(cardNoLabel);

        historyTextArea = new JTextArea();
        historyTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(historyTextArea);
        scrollPane.setBounds(50, 150, 400, 300);
        add(scrollPane);

        JButton backButton = new JButton("Back");
        backButton.setBounds(350, 500, 100, 30);
        add(backButton);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Bank(loggedInCustomer);
            }
        });

        String transferHistory = transferhistory.getTransferHistory(loggedInCustomer.getCardNumber());
        historyTextArea.setText(transferHistory);

        ImageIcon backgroundIcon = new ImageIcon(ClassLoader.getSystemResource("back2.png"));
        Image backgroundImage = backgroundIcon.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
        backgroundIcon = new ImageIcon(backgroundImage);
        JLabel backgroundLabel = new JLabel(backgroundIcon);
        backgroundLabel.setBounds(0, 0, 800, 600);
        add(backgroundLabel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new TransferHistory(null);
    }
}
