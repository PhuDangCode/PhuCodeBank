package Main;

import Database.connectSQL;

import java.sql.PreparedStatement;
import java.util.Random;

public class customersignup {
    private String response = null;

    public customersignup(String name, String dob, String gender, String address, String phone, String identity) {
        if (isEmpty(name, dob, gender, address, phone, identity)) {
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

                // Insert data into the customer table
                String customerQuery = "INSERT INTO customer (card_no, pin, amount, identity_number) VALUES (?, ?, ?, ?)";
                PreparedStatement customerStatement = connection.connection.prepareStatement(customerQuery);
                customerStatement.setString(1, generateCardNumber());
                customerStatement.setString(2, generatePIN());
                customerStatement.setString(3, "0");
                customerStatement.setString(4, identity);
                customerStatement.executeUpdate();

                response = "Signup successful. Your Card Number: " + generateCardNumber() + ", PIN: " + generatePIN();

                peopleStatement.close();
                customerStatement.close();
            } catch (Exception e) {
                e.printStackTrace();
                response = "Error occurred during signup.";
            }
        }
    }

    public String getResponse() {
        return response;
    }

    private boolean isEmpty(String... fields) {
        for (String field : fields) {
            if (field == null || field.trim().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    private String generateCardNumber() {
        Random ran = new Random();
        long first7 = (ran.nextLong() % 900000000000L) + 100000000000L;
        return String.valueOf(Math.abs(first7)) + "1111";
    }

    private String generatePIN() {
        Random ran = new Random();
        long first4 = (ran.nextLong() % 9000L) + 1000L;
        return String.valueOf(Math.abs(first4));
    }
}
