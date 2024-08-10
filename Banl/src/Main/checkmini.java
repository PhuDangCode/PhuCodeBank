package Main;

import Database.connectSQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class checkmini {

    public static List<String> getTransactionDates(String cardNumber) {
        List<String> dates = new ArrayList<>();

        try {
            connectSQL connection = new connectSQL();
            String query = "SELECT date FROM transaction WHERE card_no = ?";
            PreparedStatement preparedStatement = connection.connection.prepareStatement(query);
            preparedStatement.setString(1, cardNumber);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                dates.add(resultSet.getString("date"));
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dates;
    }

    public static List<String> getTransactionTypes(String cardNumber) {
        List<String> types = new ArrayList<>();

        try {
            connectSQL connection = new connectSQL();
            String query = "SELECT type FROM transaction WHERE card_no = ?";
            PreparedStatement preparedStatement = connection.connection.prepareStatement(query);
            preparedStatement.setString(1, cardNumber);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                types.add(resultSet.getString("type"));
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return types;
    }

    public static List<String> getTransactionAmounts(String cardNumber) {
        List<String> amounts = new ArrayList<>();

        try {
            connectSQL connection = new connectSQL();
            String query = "SELECT amount FROM transaction WHERE card_no = ?";
            PreparedStatement preparedStatement = connection.connection.prepareStatement(query);
            preparedStatement.setString(1, cardNumber);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                amounts.add(resultSet.getString("amount"));
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return amounts;
    }
}
