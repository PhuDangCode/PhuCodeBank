package Main;

import Database.connectSQL;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface adminInterface {
    String searchAdminInfo(String cardNo, JTextField cardField, JTextField pinField,
                                  JTextField amountField, JTextField identifierField, JTextField nameField,
                                  JTextField genderField, JTextField birthField, JTextField addressField,
                                  JTextField phoneField) ;
    String addNewAdmin(String cardNo, String pin, String amount,
                              String identityNumber, String name, String gender,
                              String birth, String address, String phone);
    String removeAdmin(String cardNo);
    String updateAdminInfo(String cardNo, String newPin, String newAmount,
                                  String identityNumber, String newName,
                                  String newGender, String newDoB, String newAddress, String newPhone);
}
