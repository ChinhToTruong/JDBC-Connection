package Services.orderBy;

import Utils.JDBCConnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrderByService {
    public static OrderByService getInstance(){
        return new OrderByService();
    }
    public void orderBy(){
        List<OrderByData> list = new ArrayList<>();
        try{
            // Buoc 1: tao connection
            Connection connection = JDBCConnect.connect();

            // Buoc 2: tao doi tuong Statement
            Statement statement = connection.createStatement();

            // Buoc 3: thuc thi cau len SQL
            String query = "SELECT" +
                    " contactLastname," +
                    " contactFirstname" +
                    " FROM" +
                    " customers" +
                    " ORDER BY" +
                    " contactLastname DESC;";

            ResultSet reuslt = statement.executeQuery(query);

            while (reuslt.next()){
                String contactLastname = reuslt.getString("contactLastname");
                String contactFirstname = reuslt.getString("contactFirstname");
                OrderByData obj = new OrderByData(contactLastname, contactFirstname);
                list.add(obj);
            }
            // Buoc 5: ngat ket noi
            JDBCConnect.close(connection);

        }catch(SQLException e){
            System.out.println(e);
        }
        for (OrderByData obj : list) {
            System.out.println("contactLastname - contactFirstname: " + obj.getContactLastname() + " - " + obj.getContactFirstname());
        }
    }
    public void orderByTwo(){
        List<OrderByData> list = new ArrayList<>();
        try{
            // Buoc 1: tao connection
            Connection connection = JDBCConnect.connect();

            // Buoc 2: tao doi tuong Statement
            Statement statement = connection.createStatement();

            // Buoc 3: thuc thi cau len SQL
            String query = "SELECT" +
                    " contactLastname," +
                    " contactFirstname" +
                    " FROM" +
                    " customers" +
                    " ORDER BY" +
                    " contactLastname DESC, contactFirstname ASC;";

            ResultSet reuslt = statement.executeQuery(query);

            while (reuslt.next()){
                String contactLastname = reuslt.getString("contactLastname");
                String contactFirstname = reuslt.getString("contactFirstname");
                OrderByData obj = new OrderByData(contactLastname, contactFirstname);
                list.add(obj);
            }
            // Buoc 5: ngat ket noi
            JDBCConnect.close(connection);

        }catch(SQLException e){
            System.out.println(e);
        }
        for (OrderByData obj : list) {
            System.out.println("contactLastname - contactFirstname: " + obj.getContactLastname() + " - " + obj.getContactFirstname());
        }
    }
}
