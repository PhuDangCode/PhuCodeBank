package Main;

import Database.connectSQL;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class manager extends employee implements managerInterface{

    public manager(String identityNumber, String name, String gender, String address, String phone, String DOB,
                 String account, String password,String emp_id,String positon ,String salary) {
        super(identityNumber, name, gender, address, phone, DOB, account, password, emp_id, positon, salary);
    }

    public String addNewManager(String account, String password, String emp_id, String position,
                                String salary, String identityNumber, String name, String gender,
                                String address, String phone) {
        String response = null;
        if (account.isEmpty() || password.isEmpty() || emp_id.isEmpty() || position.isEmpty() ||
                salary.isEmpty() || identityNumber.isEmpty() || name.isEmpty() || gender.isEmpty() ||
                address.isEmpty() || phone.isEmpty()) {
            response = "Please fill all fields.";
            return response;
        }

        connectSQL connection = new connectSQL();
        Connection con = connection.connection;

        try {
            String insertPeopleQuery = "INSERT INTO people (identity_number, name, gender, Address, Phone) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement insertPeopleStatement = con.prepareStatement(insertPeopleQuery);
            insertPeopleStatement.setString(1, identityNumber);
            insertPeopleStatement.setString(2, name);
            insertPeopleStatement.setString(3, gender);
            insertPeopleStatement.setString(4, address);
            insertPeopleStatement.setString(5, phone);
            insertPeopleStatement.executeUpdate();

            // Insert new manager into the employee table
            String insertManagerQuery = "INSERT INTO employee (account, password, emp_id, position, salary, identity_number) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement insertManagerStatement = con.prepareStatement(insertManagerQuery);
            insertManagerStatement.setString(1, account);
            insertManagerStatement.setString(2, password);
            insertManagerStatement.setString(3, emp_id);
            insertManagerStatement.setString(4, position);
            insertManagerStatement.setString(5, salary);
            insertManagerStatement.setString(6, identityNumber);
            insertManagerStatement.executeUpdate();

            response = "New employee added successfully.";

            insertPeopleStatement.close();
            insertManagerStatement.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            response = "Error occurred while adding a new manager.";
        }

        return response;
    }
    public String searchManagerInfo(String account, JTextField accField, JTextField passField,
                                    JTextField identifierField, JTextField nameField,
                                    JTextField genderField, JTextField birthField,
                                    JTextField addressField, JTextField phoneField,
                                    JTextField positionField, JTextField empIdField,
                                    JTextField salaryField) {
        connectSQL connection = new connectSQL();
        Connection con = connection.connection;

        try {
            String searchQuery = "SELECT * FROM employee WHERE account = ?";
            PreparedStatement searchStatement = con.prepareStatement(searchQuery);
            searchStatement.setString(1, account);

            ResultSet resultSet = searchStatement.executeQuery();

            if (resultSet.next()) {
                String identityNumber = resultSet.getString("identity_number");
                String getInfoQuery = "SELECT * FROM people WHERE identity_number = ?";
                PreparedStatement getInfoStatement = con.prepareStatement(getInfoQuery);
                getInfoStatement.setString(1, identityNumber);

                ResultSet infoResultSet = getInfoStatement.executeQuery();
                if (infoResultSet.next()) {
                    accField.setText(account);
                    passField.setText(resultSet.getString("password"));
                    identifierField.setText(identityNumber);
                    nameField.setText(infoResultSet.getString("name"));
                    genderField.setText(infoResultSet.getString("gender"));
                    birthField.setText(infoResultSet.getString("DoB"));
                    addressField.setText(infoResultSet.getString("Address"));
                    phoneField.setText(infoResultSet.getString("Phone"));
                    positionField.setText(resultSet.getString("position"));
                    empIdField.setText(resultSet.getString("emp_id"));
                    salaryField.setText(resultSet.getString("salary"));
                    return "Employee  information found.";
                }
            } else {
                accField.setText("");
                passField.setText("");
                identifierField.setText("");
                nameField.setText("");
                genderField.setText("");
                birthField.setText("");
                addressField.setText("");
                phoneField.setText("");
                positionField.setText("");
                empIdField.setText("");
                salaryField.setText("");
                return "Employee  not found.";
            }

            searchStatement.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error in searching Employee  information.";
        }

        return "Error in searching Employee  information.";
    }
    public String removeManager(String account) {
        connectSQL connection = new connectSQL();
        Connection con = connection.connection;
        String response = null;

        try {

            String getIdentityQuery = "SELECT identity_number FROM employee WHERE account = ?";
            PreparedStatement getIdentityStatement = con.prepareStatement(getIdentityQuery);
            getIdentityStatement.setString(1, account);

            String identityNumber = null;
            var resultSet = getIdentityStatement.executeQuery();
            if (resultSet.next()) {
                identityNumber = resultSet.getString("identity_number");


                String removeEmployeeQuery = "DELETE FROM employee WHERE account = ?";
                PreparedStatement removeEmployeeStatement = con.prepareStatement(removeEmployeeQuery);
                removeEmployeeStatement.setString(1, account);
                removeEmployeeStatement.executeUpdate();

                String removePeopleQuery = "DELETE FROM people WHERE identity_number = ?";
                PreparedStatement removePeopleStatement = con.prepareStatement(removePeopleQuery);
                removePeopleStatement.setString(1, identityNumber);
                removePeopleStatement.executeUpdate();

                response = "Employee removed successfully.";
            } else {
                response = "Employee not found with account: " + account;
            }

            getIdentityStatement.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            response = "Error occurred while removing Employee.";
        }

        return response;
    }

    public String updateManagerInfo(String account, String newPassword, String emp_id, String newPosition,
                                    String newSalary, String identityNumber, String newName,
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

            String updateManagerQuery = "UPDATE employee SET password=?, emp_id=?, position=?, salary=? WHERE account=?";
            PreparedStatement updateManagerStatement = con.prepareStatement(updateManagerQuery);
            updateManagerStatement.setString(1, newPassword);
            updateManagerStatement.setString(2, emp_id);
            updateManagerStatement.setString(3, newPosition);
            updateManagerStatement.setString(4, newSalary);
            updateManagerStatement.setString(5, account);
            updateManagerStatement.executeUpdate();

            updatePeopleStatement.close();
            updateManagerStatement.close();
            con.close();

            return "Employee  information updated successfully.";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Error occurred while updating Employee  information: " + e.getMessage();
        }

    }
}
