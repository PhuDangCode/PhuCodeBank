package GUI;

import Main.checkmini;
import Main.employee;
import Main.teller;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Teller extends JFrame {
    String pin;
    JButton button;
    JLabel cardNoLabel, employeeLabel;
    JTextField cardNoTextField;
    JTable table;

    public Teller(teller loggedInTeller) {
        getContentPane().setBackground(new Color(255, 204, 204));
        setSize(920, 530);
        setLocation(20, 20);
        setLayout(null);

        cardNoLabel = new JLabel("Card_no:");
        cardNoLabel.setBounds(20, 50, 100, 20);
        add(cardNoLabel);

        cardNoTextField = new JTextField();
        cardNoTextField.setBounds(120, 50, 150, 20);
        add(cardNoTextField);

        employeeLabel = new JLabel("Employee_id:");
        employeeLabel.setBounds(600, 50, 100, 20);
        add(employeeLabel);

        JLabel employeeTextField = new JLabel(loggedInTeller.getEmpID());
        employeeTextField.setBounds(850, 0, 140, 30);
        add(employeeTextField);

        button = new JButton("Search");
        button.setBounds(300, 50, 80, 20);
        add(button);

        JButton clearButton = new JButton("Clear");
        clearButton.setBounds(700, 450, 80, 20);
        add(clearButton);

        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(820, 450, 80, 20);
        add(exitButton);

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cardNumber = cardNoTextField.getText();
                if (!cardNumber.isEmpty()) {
                    displayTransactionHistory(cardNumber);
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter Card_no.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardNoTextField.setText("");
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.setRowCount(0);
            }
        });

        table = new JTable();
        table.setBounds(50, 80, 800, 350);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 80, 800, 350);
        add(scrollPane);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("back2.png"));
        Image i2 = i1.getImage().getScaledInstance(920, 530, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 920, 530);
        add(image);

        setSize(920, 530);
        setLocation(400, 200);
        setVisible(true);
    }

    private void displayTransactionHistory(String cardNumber) {
        List<String> dates = checkmini.getTransactionDates(cardNumber);
        List<String> types = checkmini.getTransactionTypes(cardNumber);
        List<String> amounts = checkmini.getTransactionAmounts(cardNumber);

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Date");
        model.addColumn("Type");
        model.addColumn("Amount");

        for (int i = 0; i < dates.size(); i++) {
            String[] row = {dates.get(i), types.get(i), amounts.get(i)};
            model.addRow(row);
        }

        table.setModel(model);
    }

    public static void main(String[] args) {
        new Teller(null);
    }
}
