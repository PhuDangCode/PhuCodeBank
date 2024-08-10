package Database;

import java.sql.*;

public class connectSQL {
    public Connection connection;
    Statement statement;
    public connectSQL(){
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankSystem","root","0905657088");
            statement = connection.createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public void close() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
