package GUI;

import Main.*;
import com.sun.net.httpserver.Authenticator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin extends JFrame {

    JButton add, update, delete, search, exit;
    JLabel heading, card, identifier, name, birth, gender, address, phone, pin, amount;
    JTextField fcard, fidentifier, fname, fbirth, fgender, faddress, fphone, fpin, famount;
    int corner = 30, width = 920, height = 530,
            Bwidth = 140, Bheight = 30, Bgap = 30,
            Lwidth = 150, Lheight = 30, Tgap = 35, Ttop = 80,
            Fwidth = 250, Fheight = 22, Fgap = 13;

    public Admin(admin loggedInAdmin) {

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("back2.png"));
        Image i2 = i1.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, width, height);
        add(image);

        heading = new JLabel("Customer Management System");
        heading.setBounds(250, 20, 600, 40);
        heading.setFont(new Font("Raleway", Font.BOLD, Bheight));
        image.add(heading);

        JLabel textField = new JLabel(loggedInAdmin.getEmpID());
        textField.setBounds(width - corner - Bwidth+100, 0, Bwidth, Bheight);
        image.add(textField);

        card = new JLabel("Card no:");
        card.setBounds(corner, Ttop, Lwidth, Lheight);
        card.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        image.add(card);

        search = new JButton("Search");
        search.setBounds(corner + Fwidth + Lwidth + 13, Ttop, Bwidth - 30, Fheight);
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cardNumber = fcard.getText();

                String response = loggedInAdmin.searchAdminInfo(cardNumber, fcard, fpin, famount, fidentifier, fname, fgender, fbirth, faddress, fphone);
        
                JOptionPane.showMessageDialog(null, response);
            }
        });
        image.add(search);

        identifier = new JLabel("Identifier number:");
        identifier.setBounds(corner, Ttop + Tgap, Lwidth, Lheight);
        identifier.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        image.add(identifier);

        name = new JLabel("Name:");
        name.setBounds(corner, Ttop + 2 * Tgap, Lwidth, Lheight);
        name.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        image.add(name);

        gender = new JLabel("Gender:");
        gender.setBounds(corner, Ttop + 3 * Tgap, Lwidth, Lheight);
        gender.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        image.add(gender);

        birth = new JLabel("Birth:");
        birth.setBounds(corner, Ttop + 4 * Tgap, Lwidth, Lheight);
        birth.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        image.add(birth);

        address = new JLabel("Address:");
        address.setBounds(corner, Ttop + 5 * Tgap, Lwidth, Lheight);
        address.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        image.add(address);

        phone = new JLabel("Phone:");
        phone.setBounds(corner, Ttop + 6 * Tgap, Lwidth, Lheight);
        phone.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        image.add(phone);

        pin = new JLabel("Pin:");
        pin.setBounds(corner, Ttop + 7 * Tgap, Lwidth, Lheight);
        pin.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        image.add(pin);

        amount = new JLabel("Amount:");
        amount.setBounds(corner, Ttop + 8 * Tgap, Lwidth, Lheight);
        amount.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        image.add(amount);

        fcard = new JTextField();
        fcard.setBounds(corner + Lwidth, Ttop, Fwidth, Fheight);
        add(fcard);

        fidentifier = new JTextField();
        fidentifier.setBounds(corner + Lwidth, Ttop + Fheight + Fgap, Fwidth, Fheight);
        add(fidentifier);

        fname = new JTextField();
        fname.setBounds(corner + Lwidth, Ttop + (Fheight + Fgap) * 2, Fwidth, Fheight);
        add(fname);

        fgender = new JTextField();
        fgender.setBounds(corner + Lwidth, Ttop + (Fheight + Fgap) * 3, Fwidth, Fheight);
        add(fgender);

        fbirth = new JTextField();
        fbirth.setBounds(corner + Lwidth, Ttop + (Fheight + Fgap) * 4, Fwidth, Fheight);
        add(fbirth);

        faddress = new JTextField();
        faddress.setBounds(corner + Lwidth, Ttop + (Fheight + Fgap) * 5, Fwidth, Fheight);
        add(faddress);

        fphone = new JTextField();
        fphone.setBounds(corner + Lwidth, Ttop + (Fheight + Fgap) * 6, Fwidth, Fheight);
        add(fphone);

        fpin = new JTextField();
        fpin.setBounds(corner + Lwidth, Ttop + (Fheight + Fgap) * 7, Fwidth, Fheight);
        add(fpin);

        famount = new JTextField();
        famount.setBounds(corner + Lwidth, Ttop + (Fheight + Fgap) * 8, Fwidth, Fheight);
        add(famount);

        add = new JButton("Add");
        add.setBounds(corner, height - Bheight * 2 - corner, Bwidth, Bheight);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cardNo = fcard.getText();
                String pin = fpin.getText();
                String amount = famount.getText();
                String identityNumber = fidentifier.getText();
                String name = fname.getText();
                String gender = fgender.getText();
                String birth = fbirth.getText();
                String address = faddress.getText();
                String phone = fphone.getText();

                String response = loggedInAdmin.addNewAdmin(cardNo, pin, amount, identityNumber,
                        name, gender, birth, address, phone);

                JOptionPane.showMessageDialog(null, response);
                if(response.contains("success")) {
                    fcard.setText("");
                    fidentifier.setText("");
                    fname.setText("");
                    fgender.setText("");
                    fbirth.setText("");
                    faddress.setText("");
                    fphone.setText("");
                    fpin.setText("");
                    famount.setText("");
                }
            }   
        });
        image.add(add);

        update = new JButton("Update");
        update.setBounds(corner + Bwidth + Bgap, height - Bheight * 2 - corner, Bwidth, Bheight);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cardNo = fcard.getText();
                String pin = fpin.getText();
                String amount = famount.getText();
                String identityNumber = fidentifier.getText();
                String name = fname.getText();
                String gender = fgender.getText();
                String birth = fbirth.getText();
                String address = faddress.getText();
                String phone = fphone.getText();


                String response = loggedInAdmin.updateAdminInfo(cardNo, pin, amount, identityNumber,
                        name, gender, birth, address, phone);

                JOptionPane.showMessageDialog(null, response);
            }
        });
        image.add(update);

        delete = new JButton("Remove");
        delete.setBounds(corner + (Bwidth + Bgap) * 2, height - Bheight * 2 - corner, Bwidth, Bheight);
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cardNo = fcard.getText();

                String response = loggedInAdmin.removeAdmin(cardNo);

                JOptionPane.showMessageDialog(null, response);

                // Clear text fields after removing
                fcard.setText("");
                fidentifier.setText("");
                fname.setText("");
                fgender.setText("");
                fbirth.setText("");
                faddress.setText("");
                fphone.setText("");
                fpin.setText("");
                famount.setText("");
            }
        });
        image.add(delete);

        //make a clear button
        JButton clear = new JButton("Clear");
        clear.setBounds(corner + (Bwidth + Bgap) * 3, height - Bheight * 2 - corner, Bwidth, Bheight);
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fcard.setText("");
                fidentifier.setText("");
                fname.setText("");
                fgender.setText("");
                fbirth.setText("");
                faddress.setText("");
                fphone.setText("");
                fpin.setText("");
                famount.setText("");
            }
        });
        image.add(clear);

        exit = new JButton("Exit");
        exit.setBounds(width - corner - Bwidth, height - Bheight * 2 - corner, Bwidth, Bheight);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        image.add(exit);

        setSize(width, height);
        setLocation(400, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Admin(null);
    }
}
