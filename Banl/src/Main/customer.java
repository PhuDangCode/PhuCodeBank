package Main;

import Database.connectSQL;
import GUI.Transfer;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class customer extends people implements cusInterface {
    private String card_no;
    private String pin;
    private String amount;
    public customer(){};
    public customer(String card, String pin) {
        this.card_no = card;
        this.pin = pin;
    };
    public customer(String identityNumber, String name, String gender, String address, String phone, String DOB,
                    String cardNumber, String pin, String amount) {
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
        this.DOB = DOB;
        this.identityNumber = identityNumber;
        this.card_no = cardNumber;
        this.pin = pin;
        this.amount = amount;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber =identityNumber;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String setGender) {
        this.gender = setGender;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public void setPhone(String setPhone) {
        this.phone = setPhone;
    }
    public void setDOB(String setDOB) {
        this.DOB = setDOB;
    }
    public void setCardNumber(String setCardNumber) {
        this.card_no = setCardNumber;
    }
    public void setPin(String Pin) {
        this.pin = Pin;
    }
    public void setAmount(String setAmount) {
        this.amount = setAmount;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getDOB() {
        return DOB;
    }

    public String getCardNumber() {
        return card_no;
    }

    public String getPin() {
        return pin;
    }

    public String getAmount() {
        return amount;
    }

    public customer customerlogin(customer loggedInCustomer) {
        connectSQL connection = new connectSQL();

        try {
            String query = "SELECT * FROM customer C join people P on C.identity_number = P.identity_number WHERE card_no = ? AND pin = ?";
            PreparedStatement preparedStatement = connection.connection.prepareStatement(query);
            preparedStatement.setString(1, loggedInCustomer.getCardNumber());
            preparedStatement.setString(2, loggedInCustomer.getPin());

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                loggedInCustomer = new customer(resultSet.getString("identity_number"),
                        resultSet.getString("name"),
                        resultSet.getString("gender"),
                        resultSet.getString("Address"),
                        resultSet.getString("Phone"),
                        resultSet.getString("DoB"),
                        resultSet.getString("card_no"),
                        resultSet.getString("pin"),
                        resultSet.getString("amount"));
            } else {
                loggedInCustomer = null;
            }

            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
            loggedInCustomer = null;
        }
        return loggedInCustomer;
    }
    public void customerTrans(customer loggedInCustomer, String tacc, String amount) {
        try {
            int currentAmount = Integer.parseInt(loggedInCustomer.getAmount());
            int intamount = Integer.parseInt(amount);
            if (intamount > currentAmount) {
                JOptionPane.showMessageDialog(null, "Insufficient funds.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                processTrans(loggedInCustomer, tacc,amount);
                insertTransactionRecord(loggedInCustomer.getCardNumber(), "Tranfer", String.valueOf(amount));
                insertTransferRecord(loggedInCustomer.getCardNumber(), tacc,amount);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(
                    null,
                    "Error processing transfering. Please try again. Error Details: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
    public void customerDeposit(customer loggedInCustomer, int amount) {
        try {
            int currentAmount = Integer.parseInt(loggedInCustomer.getAmount());
            int newAmount = currentAmount + amount;

            updateCustomerAmount(loggedInCustomer.getCardNumber(), String.valueOf(newAmount));
            updateCurrentAmount(loggedInCustomer);
            insertTransactionRecord(loggedInCustomer.getCardNumber(), "Deposit", String.valueOf(amount));
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(
                    null,
                    "Error processing deposit. Please try again. Error Details: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
    public void customerFastCash(customer loggedInCustomer, int amount) {
        try {
            int newAmount = Integer.parseInt(loggedInCustomer.getAmount()) + amount;
            loggedInCustomer.setAmount(String.valueOf(newAmount));

            updateCustomerAmount(loggedInCustomer.getCardNumber(), String.valueOf(newAmount));

            insertTransactionRecord(loggedInCustomer.getCardNumber(), "FastCash", String.valueOf(amount));
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error processing FastCash. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void customerWithdrawal(customer loggedInCustomer, int amount) {
        try {
            int currentAmount = Integer.parseInt(loggedInCustomer.getAmount());
            if (amount > currentAmount) {
                JOptionPane.showMessageDialog(null, "Insufficient funds.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                int newAmount = currentAmount - amount;
                updateCustomerAmount(loggedInCustomer.getCardNumber(), String.valueOf(newAmount));
                updateCurrentAmount(loggedInCustomer);
                insertTransactionRecord(loggedInCustomer.getCardNumber(), "Withdrawal", String.valueOf(amount));

            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(
                    null,
                    "Error processing withdrawal. Please try again. Error Details: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
    public void customerChangePIN(customer loggedInCustomer, String oldPIN, String newPIN) {
        try {
            if (oldPIN.equals(loggedInCustomer.getPin())) {
                updatePIN(loggedInCustomer.getCardNumber(), newPIN);
                JOptionPane.showMessageDialog(null, "PIN changed successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Incorrect old PIN. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(
                    null,
                    "Error changing PIN. Please try again. Error Details: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
    private void updatePIN(String cardNumber, String newPIN) {
        try {
            connectSQL connection = new connectSQL();
            String query = "UPDATE customer SET pin = ? WHERE card_no = ?";
            PreparedStatement preparedStatement = connection.connection.prepareStatement(query);
            preparedStatement.setString(1, newPIN);
            preparedStatement.setString(2, cardNumber);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void updateCustomerAmount(String cardNumber, String newAmount) {
        try {
            connectSQL connection = new connectSQL();
            String query = "UPDATE customer SET amount = ? WHERE card_no = ?";
            PreparedStatement preparedStatement = connection.connection.prepareStatement(query);
            preparedStatement.setString(1, newAmount);
            preparedStatement.setString(2, cardNumber);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void updateCurrentAmount(customer loggedInCustomer) {
        try {

            connectSQL con = new connectSQL();
            con.connection.setAutoCommit(false);

            String query = "SELECT * FROM customer  WHERE card_no = ?";
            PreparedStatement preparedStatement = con.connection.prepareStatement(query);
            preparedStatement.setString(1, loggedInCustomer.getCardNumber());

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                loggedInCustomer.setAmount(resultSet.getString("amount"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void processTrans(customer loggedInCustomer, String tacc, String amount) {
        try {

            connectSQL con = new connectSQL();
            con.connection.setAutoCommit(false);

            PreparedStatement rec = con.connection.prepareStatement("update customer set amount = amount + ? where card_no = ?");
            rec.setString(1, amount);
            rec.setString(2, tacc);
            rec.execute();

            PreparedStatement send = con.connection.prepareStatement("update customer set amount = amount - ? where card_no = ?");
            send.setString(1, amount);
            send.setString(2, loggedInCustomer.getCardNumber());
            send.execute();

            con.connection.commit();
            loggedInCustomer.updateCurrentAmount(loggedInCustomer);
        } catch (SQLException ex) {
            connectSQL con = new connectSQL();
            try {
                con.connection.rollback();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    private void insertTransactionRecord(String cardNumber, String type, String amount) {
        try {
            connectSQL connection = new connectSQL();
            String query = "INSERT INTO transaction (card_no, date, type, amount) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.connection.prepareStatement(query);
            preparedStatement.setString(1, cardNumber);
            preparedStatement.setString(2, getCurrentDate());
            preparedStatement.setString(3, type);
            preparedStatement.setString(4, amount);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void insertTransferRecord(String cardNumber, String receiver, String amount) {
        try {
            connectSQL connection = new connectSQL();
            Random random = new Random();

            int min = 100_000_000;
            int max = 999_999_999;
            int randomInt = random.nextInt((max - min) + 1) + min;
            String code = String.valueOf(randomInt);

            String query = "INSERT INTO transfer (trade_code, card_no, date, amount, receiver) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.connection.prepareStatement(query);
            preparedStatement.setString(1, code);
            preparedStatement.setString(2, cardNumber);
            preparedStatement.setString(3, getCurrentDate());
            preparedStatement.setString(4, amount);
            preparedStatement.setString(5, receiver);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private String getCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

}
