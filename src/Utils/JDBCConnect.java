package Utils;

import java.sql.*;

public class JDBCConnect {
    public static Connection connect(){
        Connection connection = null;
        try{
            // info
            String url = "jdbc:mysql://localhost:3306/classicmodels";
            String usename = "root";
            String password = "root";
            // regist driver
            connection = DriverManager.getConnection(url, usename, password);

        }
        catch (Exception e){
            System.out.println(e);
        }
        return connection;
    }

    public static void close(Connection c){
        try{
            c.close();
        }
        catch (SQLException e)
        {
            System.out.println(e);
        }

    }


}
