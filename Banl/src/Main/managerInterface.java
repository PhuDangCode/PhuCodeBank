package Main;

import Database.connectSQL;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface managerInterface {
    public String addNewManager(String account, String password, String emp_id, String position,
                                String salary, String identityNumber, String name, String gender,
                                String address, String phone);
    String searchManagerInfo(String account, JTextField accField, JTextField passField,
                                    JTextField identifierField, JTextField nameField,
                                    JTextField genderField, JTextField birthField,
                                    JTextField addressField, JTextField phoneField,
                                    JTextField positionField, JTextField empIdField,
                                    JTextField salaryField);
    String removeManager(String account);
    String updateManagerInfo(String account, String newPassword, String emp_id, String newPosition,
                                    String newSalary, String identityNumber, String newName,
                                    String newGender, String newDoB, String newAddress, String newPhone);
}
