// Manager.java
package GUI;

import Main.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Manager extends JFrame {

    JButton add, update, delete, search, exit;
    JLabel heading, acc, identifier, name, birth, gender, address, phone, pass, emp_id, salary, position;
    JTextField facc, fidentifier, fname, fbirth, fgender, faddress, fphone, fpass, fsalary, femp_id, fposition;
    int corner = 30, width = 920, height = 530,
            Bwidth = 140, Bheight = 30, Bgap = 30,
            Lwidth = 150, Lheight = 30, Tgap = 35, Ttop = 80,
            Fwidth = 250, Fheight = 22, Fgap = 13;

    public Manager(manager loggedInManager) {

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("back2.png"));
        Image i2 = i1.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, width, height);
        add(image);

        heading = new JLabel("Employee Management System");
        heading.setBounds(250, 20, 600, 40);
        heading.setFont(new Font("Raleway", Font.BOLD, Bheight));
        image.add(heading);

        JLabel textField = new JLabel(loggedInManager.getEmpID());
        textField.setBounds(width - corner - Bwidth+100, 0, Bwidth, Bheight);
        image.add(textField);

        acc = new JLabel("Account:");
        acc.setBounds(corner, Ttop, Lwidth, Lheight);
        acc.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        image.add(acc);

        search = new JButton("Search");
        search.setBounds(corner + Fwidth + Lwidth + 13, Ttop, Bwidth - 30, Fheight);
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

        pass = new JLabel("Pass:");
        pass.setBounds(corner, Ttop + 7 * Tgap, Lwidth, Lheight);
        pass.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        image.add(pass);

        salary = new JLabel("Salary:");
        salary.setBounds(corner, Ttop + 8 * Tgap, Lwidth, Lheight);
        salary.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        image.add(salary);

        emp_id = new JLabel("Employee ID:");
        emp_id.setBounds(corner, Ttop + 9 * Tgap, Lwidth, Lheight);
        emp_id.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        image.add(emp_id);

        position = new JLabel("Position:");
        position.setBounds(corner + 420, Ttop + 9 * Tgap, Lwidth, Lheight);
        position.setFont(new Font("SAN_SERIF", Font.BOLD, 15));
        image.add(position);

        //---------------------------------------------------------

        facc = new JTextField();
        facc.setBounds(corner + Lwidth, Ttop, Fwidth, Fheight);
        add(facc);

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

        fpass = new JTextField();
        fpass.setBounds(corner + Lwidth, Ttop + (Fheight + Fgap) * 7, Fwidth, Fheight);
        add(fpass);

        fsalary = new JTextField();
        fsalary.setBounds(corner + Lwidth, Ttop + (Fheight + Fgap) * 8, Fwidth, Fheight);
        add(fsalary);

        femp_id = new JTextField();
        femp_id.setBounds(corner + Lwidth, Ttop + (Fheight + Fgap) * 9, Fwidth, Fheight);
        add(femp_id);

        fposition = new JTextField();
        fposition.setBounds(corner + Lwidth + 350, Ttop + (Fheight + Fgap) * 9, Fwidth, Fheight);
        add(fposition);

        add = new JButton("Add");
        add.setBounds(corner, height - Bheight * 2 - corner, Bwidth, Bheight);
        image.add(add);

        update = new JButton("Update");
        update.setBounds(corner + Bwidth + Bgap, height - Bheight * 2 - corner, Bwidth, Bheight);
        image.add(update);

        delete = new JButton("Remove");
        delete.setBounds(corner + (Bwidth + Bgap) * 2, height - Bheight * 2 - corner, Bwidth, Bheight);
        image.add(delete);

        
        JButton clear = new JButton("Clear");
        clear.setBounds(corner + (Bwidth + Bgap) * 3, height - Bheight * 2 - corner, Bwidth, Bheight);
        image.add(clear);


        exit = new JButton("Exit");
        exit.setBounds(width - corner - Bwidth, height - Bheight * 2 - corner, Bwidth, Bheight);
        image.add(exit);

        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String account = facc.getText();
                String password = fpass.getText();
                String emp_id = femp_id.getText();
                String position = fposition.getText(); 
                String salary = fsalary.getText();
                String identityNumber = fidentifier.getText();
                String name = fname.getText();
                String gender = fgender.getText();
                String address = faddress.getText();
                String phone = fphone.getText();

                String response = loggedInManager.addNewManager(account, password, emp_id, position, salary, identityNumber, name, gender, address, phone);

                JOptionPane.showMessageDialog(null, response);
                if(response.contains("success")) {
                    facc.setText("");
                    fidentifier.setText("");
                    fname.setText("");
                    fgender.setText("");
                    fbirth.setText("");
                    faddress.setText("");
                    fphone.setText("");
                    fpass.setText("");
                    femp_id.setText("");
                    fposition.setText("");
                    fsalary.setText("");
                }
            }
        });

        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String account = facc.getText();
                String newPassword = fpass.getText();
                String emp_id = femp_id.getText();
                String newPosition = fposition.getText();
                String newSalary = fsalary.getText();
                String identityNumber = fidentifier.getText();
                String newName = fname.getText();
                String newGender = fgender.getText();
                String newDoB = fbirth.getText();
                String newAddress = faddress.getText();
                String newPhone = fphone.getText();

                String response = loggedInManager.updateManagerInfo(account, newPassword, emp_id, newPosition, newSalary,
                        identityNumber, newName, newGender, newDoB, newAddress, newPhone);
        
                JOptionPane.showMessageDialog(null, response);
            }
        });

        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String account = facc.getText();


                String response = loggedInManager.removeManager(account);

                JOptionPane.showMessageDialog(null, response);

                facc.setText("");
                fidentifier.setText("");
                fname.setText("");
                fgender.setText("");
                fbirth.setText("");
                faddress.setText("");
                fphone.setText("");
                fpass.setText("");
                femp_id.setText("");
                fposition.setText("");
                fsalary.setText("");
            
            }
        });
        
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                facc.setText("");
                fidentifier.setText("");
                fname.setText("");
                fgender.setText("");
                fbirth.setText("");
                faddress.setText("");
                fphone.setText("");
                fpass.setText("");
                femp_id.setText("");
                fposition.setText("");
                fsalary.setText("");
            }
        });

        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String account = facc.getText();

                String response = loggedInManager.searchManagerInfo(account, facc, fpass, fidentifier, fname, fgender, fbirth,
                        faddress, fphone, fposition, femp_id, fsalary);
             JOptionPane.showMessageDialog(null, response);
            }
        });
        
        
        setSize(width, height);
        setLocation(400, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Manager(null);
    }
}
