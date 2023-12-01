package Services.batchProcessing;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels", "root", "root");
            Statement statement = connection.createStatement();

            Statement stmt = connection.createStatement();
            stmt.addBatch("insert into people values('abhi',10)");
            stmt.addBatch("insert into people values('umesh',50)");

            stmt.executeBatch();//executing the batch
            stmt.clearBatch();

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
