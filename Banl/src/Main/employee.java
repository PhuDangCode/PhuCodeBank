package Main;

import Database.connectSQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class employee extends people {
    private String account;
    private String password;
    private String salary;
    private String emp_id;
    private String position;

    public employee(String identityNumber, String name, String gender, String address, String phone, String DOB,
                    String account, String password,String emp_id,String positon ,String salary) {
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
        this.DOB = DOB;
        this.identityNumber = identityNumber;
        this.account = account;
        this.password = password;
        this.emp_id = emp_id;
        this.position = positon;
        this.salary = salary;
    }
    public employee(String acc, String pass) {
        this.account = acc;
        this.password = pass;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address = address;
    }

    public String getPhone(){
        return phone;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }

    public String getDOB(){
        return DOB;
    }
    public void setDOB(String DOB){
        this.DOB = DOB;
    }

    public String getIdentityNumber(){
        return identityNumber;
    }
    public void setIdentityNumber(String identityNumber){
        this.identityNumber = identityNumber;
    }

    public String getAccount() {
        return account;
    }
    public void setAccount(String account) {
        this.account = account;
    }


    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmpID() {
        return emp_id;
    }
    public void setEmpID(String emp_id) {
        this.emp_id = emp_id;
    }

    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }

    public String getSalary() {
        return salary;
    }
    public void setSalary(String salary) {
        this.salary = salary;
    }

    public static boolean employeelogin(employee loggedInEmployee) {
        connectSQL connection = new connectSQL();
        boolean response = false;

        try {
            String query = "SELECT employee.account, employee.password, employee.emp_id, employee.position, " +
                    "employee.salary, people.identity_number, people.name, people.gender, " +
                    "people.Address, people.Phone, people.DoB " +
                    "FROM employee " +
                    "JOIN people ON employee.identity_number = people.identity_number " +
                    "WHERE employee.account = ? AND employee.password = ?";

            PreparedStatement preparedStatement = connection.connection.prepareStatement(query);
            preparedStatement.setString(1, loggedInEmployee.getAccount());
            preparedStatement.setString(2, loggedInEmployee.getPassword());

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                loggedInEmployee.setName(resultSet.getString("name"));
                loggedInEmployee.setPosition(resultSet.getString("position"));
                loggedInEmployee.setAccount(resultSet.getString("account"));
                loggedInEmployee.setAddress(resultSet.getString("Address"));
                loggedInEmployee.setDOB(resultSet.getString("DoB"));
                loggedInEmployee.setGender(resultSet.getString("gender"));
                loggedInEmployee.setIdentityNumber(resultSet.getString("identity_number"));
                loggedInEmployee.setPhone(resultSet.getString("Phone"));
                loggedInEmployee.setPassword(resultSet.getString("password"));
                loggedInEmployee.setEmpID(resultSet.getString("emp_id"));
                loggedInEmployee.setSalary(resultSet.getString("salary"));

                response = true;
            } else {
                response = false;
            }

            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
            response = false;
        }
        return response;
    }

}
