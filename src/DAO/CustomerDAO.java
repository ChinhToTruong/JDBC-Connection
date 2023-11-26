package DAO;

import Models.Customer;
import Utils.JDBCConnect;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CustomerDAO implements DAOInterface<Customer>{
    public static CustomerDAO getInstance(){
        return new CustomerDAO();
    }

    @Override
    public void createTable() {
        try{
            // Buoc 1: tao connection
            Connection connection = JDBCConnect.connect();

            // Buoc 2: tao doi tuong Statement
            Statement statement = connection.createStatement();

            // Buoc 3: thuc thi cau len SQL
            String query = "Create Table Customer("+
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "name VARCHAR(255)," +
                    "address VARCHAR(255)," +
                    "dayOfBirth DATE)";
            System.out.println("Tao thanh cong Cutomer table");
            statement.execute(query);
            // Buoc 5: ngat ket noi
            JDBCConnect.close(connection);

        }catch(SQLException e){
            System.out.println(e);
        }
    }

    @Override
    public void add(Customer customer) {
        try{
            // Buoc 1: tao connection
            Connection connection = JDBCConnect.connect();

            // Buoc 2: tao doi tuong Statement
            Statement statement = connection.createStatement();

            // Buoc 3: thuc thi cau len SQL
            String query = "INSERT INTO Customer (name, address, dayOfBirth)"+
                    "Values(" + "'"+ customer.getName() + "'" + "," + "'"+ customer.getAddress() + "'"+ "," + "'" +customer.getDayOfBirth() +"'" + ")";
            statement.execute(query);

            System.out.println("Them thanh cong");
            // Buoc 5: ngat ket noi
            JDBCConnect.close(connection);

        }catch(SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public void delete(Customer customer) {
        try{
            // Buoc 1: tao connection
            Connection connection = JDBCConnect.connect();

            // Buoc 2: tao doi tuong Statement
            Statement statement = connection.createStatement();

            // Buoc 3: thuc thi cau len SQL
            String query = "Delete From Customer Where name ="+ "'" +customer.getName() + "'";
            statement.execute(query);

            System.out.println("Xoa thanh cong Cutomer table");
            // Buoc 5: ngat ket noi
            JDBCConnect.close(connection);

        }catch(SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public void update(Customer customer) {
        try{
            // Buoc 1: tao connection
            Connection connection = JDBCConnect.connect();

            // Buoc 2: tao doi tuong Statement
            Statement statement = connection.createStatement();

            // Buoc 3: thuc thi cau len SQL
            String query = "Update Book" +
                    "Set address = " + "' new" + customer.getAddress() + "'" +
                    "Where name =" + "'" + customer.getName() +"'";
            statement.execute(query);

            System.out.println("Update thanh cong Book table");
            // Buoc 5: ngat ket noi
            JDBCConnect.close(connection);

        }catch(SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public ArrayList<Customer> selectAll() {
        return null;
    }

    @Override
    public Customer selectById(int id) {
        return null;
    }

    @Override
    public ArrayList<Customer> selectByCondition(String condition) {
        return null;
    }
}
