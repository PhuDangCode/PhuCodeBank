package Main;

import Database.connectSQL;

import java.sql.PreparedStatement;

public class employeesignup {
    private String response = null;

    public employeesignup(String name, String dob, String gender, String address, String phone, String identity,
            String account, String password, String emp_id, String position, String salary) {
        if (isEmpty(name, dob, gender, address, phone, identity, account, password, emp_id, position, salary)) {
            response = "Please fill all fields.";
        } else {
            connectSQL connection = new connectSQL();

            try {
                // Insert data into the people table
                String peopleQuery = "INSERT INTO people (identity_number, name, gender, DoB, Address, Phone) VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement peopleStatement = connection.connection.prepareStatement(peopleQuery);
                peopleStatement.setString(1, identity);
                peopleStatement.setString(2, name);
                peopleStatement.setString(3, gender);
                peopleStatement.setString(4, dob);
                peopleStatement.setString(5, address);
                peopleStatement.setString(6, phone);
                peopleStatement.executeUpdate();

                // Insert data into the employee table
                String employeeQuery = "INSERT INTO employee (account, password, emp_id, position, salary, identity_number) VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement employeeStatement = connection.connection.prepareStatement(employeeQuery);
                employeeStatement.setString(1, account);
                employeeStatement.setString(2, password);
                employeeStatement.setString(3, emp_id);
                employeeStatement.setString(4, position);
                employeeStatement.setString(5, salary);
                employeeStatement.setString(6, identity);
                employeeStatement.executeUpdate();

                response = "Signup successful.";

                peopleStatement.close();
                employeeStatement.close();
            } catch (Exception e) {
                e.printStackTrace();
                response = "Error occurred during signup.";
            }
        }
    }

    private boolean isEmpty(String... fields) {
        for (String field : fields) {
            if (field == null || field.trim().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public String getResponse() {
        return response;
    }
}
