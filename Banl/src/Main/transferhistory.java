package Main;

import Database.connectSQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class transferhistory {

    public static String getTransferHistory(String cardNumber) {
        StringBuilder historyText = new StringBuilder();

        try {
            connectSQL connection = new connectSQL();
            String query = "SELECT date, trade_code, amount, receiver FROM transfer WHERE card_no = ? OR receiver = ?";
            PreparedStatement preparedStatement = connection.connection.prepareStatement(query);
            preparedStatement.setString(1, cardNumber);
            preparedStatement.setString(2, cardNumber);

            ResultSet resultSet = preparedStatement.executeQuery();

            historyText.append(String.format("%-20s%-20s%-20s%-20s\n", "Date", "Trade Code", "Amount", "Receiver"));
            while (resultSet.next()) {
                String date = resultSet.getString("date");
                String tradeCode = resultSet.getString("trade_code");
                String amount = resultSet.getString("amount");
                String receiver = resultSet.getString("receiver");

                historyText.append(String.format("%-20s%-20s%-20s%-20s\n", date, tradeCode, amount, receiver));
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return historyText.toString();
    }
}
