package Service;

import Models.Customer;
import Utils.JDBCConnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    public static CustomerService getInstance(){
        return new CustomerService();
    }
    public List<Customer> sortCustomer(){
        List<Customer> listCustomer = new ArrayList<>();

        try{
            // Buoc 1: tao connection
            Connection connection = JDBCConnect.connect();

            // Buoc 2: tao doi tuong Statement
            Statement statement = connection.createStatement();

            // Buoc 3: thuc thi cau len SQL
            String query = "SELECT " +
                    "    contactLastname, " +
                    "    contactFirstname" +
                    "FROM" +
                    "    customers" +
                    "ORDER BY " +
                    "contactLastname DESC , " +
                    "contactFirstname ASC;";
            System.out.println("Tao thanh cong Book table");
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                String lastName = resultSet.getString("contactLastname");
                String firstName = resultSet.getString("contactFirstname");
            }
            // Buoc 5: ngat ket noi
            JDBCConnect.close(connection);

        }catch(SQLException e){
            System.out.println(e);
        }
        return listCustomer;
    }
}
