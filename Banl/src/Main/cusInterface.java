package Main;

import Database.connectSQL;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public interface cusInterface {
    customer customerlogin(customer loggedInCustomer);
    void customerTrans(customer loggedInCustomer, String tacc, String amount);
    void customerDeposit(customer loggedInCustomer, int amount);
    void customerFastCash(customer loggedInCustomer, int amount);

    void customerWithdrawal(customer loggedInCustomer, int amount);
    void customerChangePIN(customer loggedInCustomer, String oldPIN, String newPIN);

}
