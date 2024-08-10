package GUI;

import Main.customer;
import Main.checkmini;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Mini extends JFrame {

    JLabel cardNoLabel;
    JTextField cardNoTextField;
    JLabel label1, label2, label3, label4;

    public Mini(customer loggedInCustomer) {
        getContentPane().setBackground(new Color(255, 204, 204));
        setSize(500, 600);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel bankLabel = new JLabel("426 Bank");
        bankLabel.setFont(new Font("Arial", Font.BOLD, 30));
        bankLabel.setHorizontalAlignment(SwingConstants.CENTER);
        bankLabel.setBounds(150, 30, 200, 50);
        add(bankLabel);

        cardNoLabel = new JLabel("Card_no: " +loggedInCustomer.getCardNumber());
        cardNoLabel.setBounds(50, 100, 100, 20);
        add(cardNoLabel);

        label1 = new JLabel();
        label1.setBounds(50, 180, 400, 345);
        add(label1);

        label2 = new JLabel("History");
        label2.setFont(new Font("System", Font.BOLD, 15));
        label2.setBounds(150, 140, 200, 20);
        add(label2);

        label3 = new JLabel();
        label3.setBounds(250, 180, 300, 345);
        add(label3);

        label4 = new JLabel();
        label4.setBounds(320, 180, 300, 345);
        add(label4);

        JButton exitButton = new JButton("Back");
        exitButton.setBounds(350, 500, 100, 30);
        add(exitButton);
        

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Bank(loggedInCustomer);
            }
        });

        List<String> dates = checkmini.getTransactionDates(loggedInCustomer.getCardNumber());
        List<String> types = checkmini.getTransactionTypes(loggedInCustomer.getCardNumber());
        List<String> amounts = checkmini.getTransactionAmounts(loggedInCustomer.getCardNumber());

        displayTransactionHistory(label1, dates);
        displayTransactionHistory(label3, types);
        displayTransactionHistory(label4, amounts);

        ImageIcon backgroundIcon = new ImageIcon(ClassLoader.getSystemResource("back2.png"));
        Image backgroundImage = backgroundIcon.getImage().getScaledInstance(500, 600, Image.SCALE_DEFAULT);
        backgroundIcon = new ImageIcon(backgroundImage);
        JLabel backgroundLabel = new JLabel(backgroundIcon);
        backgroundLabel.setBounds(0, 0, 500, 600);
        add(backgroundLabel);

        setVisible(true);
    }

    private void displayTransactionHistory(JLabel label, List<String> historyList) {
        StringBuilder resultText = new StringBuilder("<html>");

        for (String entry : historyList) {
            resultText.append(entry).append("<br>");
        }

        resultText.append("</html>");
        label.setText(resultText.toString());
    }

    public static void main(String[] args) {
        new Mini(null);
    }
}
