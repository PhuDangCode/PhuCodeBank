package Main;

import Database.connectSQL;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class admin extends employee implements adminInterface{

    public admin(String identityNumber, String name, String gender, String address, String phone, String DOB,
                 String account, String password,String emp_id,String positon ,String salary) {
    super(identityNumber, name, gender, address, phone, DOB, account, password, emp_id, positon, salary);
    }

    public String searchAdminInfo(String cardNo, JTextField cardField, JTextField pinField,
                                  JTextField amountField, JTextField identifierField, JTextField nameField,
                                  JTextField genderField, JTextField birthField, JTextField addressField,
                                  JTextField phoneField) {
        connectSQL connection = new connectSQL();
        Connection con = connection.connection;

        try {
            String searchQuery = "SELECT * FROM customer WHERE card_no = ?";
            PreparedStatement searchStatement = con.prepareStatement(searchQuery);
            searchStatement.setString(1, cardNo);

            ResultSet resultSet = searchStatement.executeQuery();

            if (resultSet.next()) {
                String identityNumber = resultSet.getString("identity_number");
                String getInfoQuery = "SELECT * FROM people WHERE identity_number = ?";
                PreparedStatement getInfoStatement = con.prepareStatement(getInfoQuery);
                getInfoStatement.setString(1, identityNumber);

                ResultSet infoResultSet = getInfoStatement.executeQuery();
                if (infoResultSet.next()) {
                    cardField.setText(cardNo);
                    pinField.setText(resultSet.getString("pin"));
                    amountField.setText(resultSet.getString("amount"));
                    identifierField.setText(identityNumber);
                    nameField.setText(infoResultSet.getString("name"));
                    genderField.setText(infoResultSet.getString("gender"));
                    birthField.setText(infoResultSet.getString("DoB"));
                    addressField.setText(infoResultSet.getString("Address"));
                    phoneField.setText(infoResultSet.getString("Phone"));
                    return "Customer found.";
                }
            }

            // Clear text fields if admin is not found
            cardField.setText("");
            pinField.setText("");
            amountField.setText("");
            identifierField.setText("");
            nameField.setText("");
            genderField.setText("");
            birthField.setText("");
            addressField.setText("");
            phoneField.setText("");
            return "Customer does not exist.";

        } catch (SQLException e) {
            e.printStackTrace();
            return "Error occurred while searching for customer.";
        }
    }
    public String addNewAdmin(String cardNo, String pin, String amount,
                              String identityNumber, String name, String gender,
                              String birth, String address, String phone) {
        String response = null;
        if (cardNo.isEmpty() || pin.isEmpty() || amount.isEmpty() || identityNumber.isEmpty() ||
                name.isEmpty() || gender.isEmpty() || birth.isEmpty() ||
                address.isEmpty() || phone.isEmpty()) {
            response = "Please fill all fields.";
            return response;
        }

        connectSQL connection = new connectSQL();
        Connection con = connection.connection;

        try {
            String insertPeopleQuery = "INSERT INTO people (identity_number, name, gender, DoB, Address, Phone) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement insertPeopleStatement = con.prepareStatement(insertPeopleQuery);
            insertPeopleStatement.setString(1, identityNumber);
            insertPeopleStatement.setString(2, name);
            insertPeopleStatement.setString(3, gender);
            insertPeopleStatement.setString(4, birth);
            insertPeopleStatement.setString(5, address);
            insertPeopleStatement.setString(6, phone);
            insertPeopleStatement.executeUpdate();

            // Insert new admin into the customer table
            String insertAdminQuery = "INSERT INTO customer (card_no, pin, amount, identity_number) VALUES (?, ?, ?, ?)";
            PreparedStatement insertAdminStatement = con.prepareStatement(insertAdminQuery);
            insertAdminStatement.setString(1, cardNo);
            insertAdminStatement.setString(2, pin);
            insertAdminStatement.setString(3, amount);
            insertAdminStatement.setString(4, identityNumber);
            insertAdminStatement.executeUpdate();

            response = "New customer added successfully.";

            insertPeopleStatement.close();
            insertAdminStatement.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            response = "Error occurred while adding a new customer.";
        }

        return response;
    }
    public String removeAdmin(String cardNo) {
        connectSQL connection = new connectSQL();
        Connection con = connection.connection;

        String response = null;

        try {

            String getIdentityQuery = "SELECT identity_number FROM customer WHERE card_no = ?";
            PreparedStatement getIdentityStatement = con.prepareStatement(getIdentityQuery);
            getIdentityStatement.setString(1, cardNo);

            String identityNumber = null;
            var resultSet = getIdentityStatement.executeQuery();
            if (resultSet.next()) {
                identityNumber = resultSet.getString("identity_number");

                String removeAdminQuery = "DELETE FROM customer WHERE card_no = ?";
                PreparedStatement removeAdminStatement = con.prepareStatement(removeAdminQuery);
                removeAdminStatement.setString(1, cardNo);
                removeAdminStatement.executeUpdate();

                String removePeopleQuery = "DELETE FROM people WHERE identity_number = ?";
                PreparedStatement removePeopleStatement = con.prepareStatement(removePeopleQuery);
                removePeopleStatement.setString(1, identityNumber);
                removePeopleStatement.executeUpdate();

                response = "Customer removed successfully.";
            } else {
                response = "Customer not found with card number: " + cardNo;
            }

            getIdentityStatement.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            response = "Error occurred while removing Customer.";
        }

        return response;
    }

    public String updateAdminInfo(String cardNo, String newPin, String newAmount,
                                  String identityNumber, String newName,
                                  String newGender, String newDoB, String newAddress, String newPhone) {
        connectSQL connection = new connectSQL();
        Connection con = connection.connection;

        try {
            String updatePeopleQuery = "UPDATE people SET name=?, gender=?, DoB=?, Address=?, Phone=? WHERE identity_number=?";
            PreparedStatement updatePeopleStatement = con.prepareStatement(updatePeopleQuery);
            updatePeopleStatement.setString(1, newName);
            updatePeopleStatement.setString(2, newGender);
            updatePeopleStatement.setString(3, newDoB);
            updatePeopleStatement.setString(4, newAddress);
            updatePeopleStatement.setString(5, newPhone);
            updatePeopleStatement.setString(6, identityNumber);
            updatePeopleStatement.executeUpdate();

            String updateAdminQuery = "UPDATE customer SET pin=?, amount=? WHERE card_no=?";
            PreparedStatement updateAdminStatement = con.prepareStatement(updateAdminQuery);
            updateAdminStatement.setString(1, newPin);
            updateAdminStatement.setString(2, newAmount);
            updateAdminStatement.setString(3, cardNo);
            updateAdminStatement.executeUpdate();

            updatePeopleStatement.close();
            updateAdminStatement.close();
            con.close();

            return "Customer information updated successfully.";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error occurred while updating customer information: " + e.getMessage();
        }

    }
}
