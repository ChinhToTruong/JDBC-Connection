package Services.statement;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels", "root", "root");
            Statement statement = connection.createStatement();

            String sql = "SELECT * FROM people";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                System.out.println("Name: " + name + ", Age: " + age);
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
