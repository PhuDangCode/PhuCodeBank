    package GUI;

    import javax.swing.*;
    import java.awt.*;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;

    public class Choose extends JFrame {

        private JButton employeeButton, customerButton;

        public Choose() {
            getContentPane().setBackground(new Color(255, 204, 204));
            setSize(500, 500);
            setLocationRelativeTo(null);
            setLayout(null);

            JLabel bankLabel = new JLabel("426 Bank");
            bankLabel.setFont(new Font("Arial", Font.BOLD, 30));
            bankLabel.setHorizontalAlignment(SwingConstants.CENTER);
            bankLabel.setBounds(100, 30, 300, 50);
            add(bankLabel);

            JLabel label = new JLabel("Please choose role");
            label.setFont(new Font("Arial", Font.BOLD, 24));
            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setBounds(50, 150, 400, 50);
            add(label);

            employeeButton = new JButton("Employee");
            employeeButton.setBounds(50, 250, 150, 50);
            add(employeeButton);

            customerButton = new JButton("Customer");
            customerButton.setBounds(300, 250, 150, 50);
            add(customerButton);


            ImageIcon backgroundIcon = new ImageIcon(ClassLoader.getSystemResource("back2.png"));
            Image backgroundImage = backgroundIcon.getImage().getScaledInstance(500, 600, Image.SCALE_DEFAULT);
            backgroundIcon = new ImageIcon(backgroundImage);
            JLabel backgroundLabel = new JLabel(backgroundIcon);
            backgroundLabel.setBounds(0, 0, 500, 500);
            add(backgroundLabel);

            setVisible(true);

            employeeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose(); 
                    new Empin();
                }
            });

            customerButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose(); 
                    new Login(); 
                }
            });
            setTitle("426 Bank");
            setVisible(true);
        }

        public static void main(String[] args) {
            new Choose();
        }
    }
