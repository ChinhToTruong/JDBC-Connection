package Services.select;

import Utils.JDBCConnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SelectService {
    public static SelectService getInstance(){
        return new SelectService();
    }

    public void select(){
        List<String> list = new ArrayList<>();
        try{
            // Buoc 1: tao connection
            Connection connection = JDBCConnect.connect();

            // Buoc 2: tao doi tuong Statement
            Statement statement = connection.createStatement();

            // Buoc 3: thuc thi cau len SQL
            String query = "SELECT lastName FROM employees";

            ResultSet reuslt = statement.executeQuery(query);

            while (reuslt.next()){
                String name = reuslt.getString("lastName");
                list.add(name);
            }
            // Buoc 5: ngat ket noi
            JDBCConnect.close(connection);

        }catch(SQLException e){
            System.out.println(e);
        }
        for (String s : list) {
            System.out.println(s);
        }
    }
    public void selectDistinct(){
        List<String> list = new ArrayList<>();
        try{
            // Buoc 1: tao connection
            Connection connection = JDBCConnect.connect();

            // Buoc 2: tao doi tuong Statement
            Statement statement = connection.createStatement();

            // Buoc 3: thuc thi cau len SQL
            String query = "SELECT DISTINCT lastname FROM employees ORDER BY lastname";

            ResultSet reuslt = statement.executeQuery(query);

            while (reuslt.next()){
                String name = reuslt.getString("lastName");
                list.add(name);
            }
            // Buoc 5: ngat ket noi
            JDBCConnect.close(connection);

        }catch(SQLException e){
            System.out.println(e);
        }
        for (String s : list) {
            System.out.println(s);
        }
    }
}
