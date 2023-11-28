package Service;

import Models.Supplier;
import Utils.JDBCConnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SupplierService implements ServiceInterface<Supplier> {
    public static SupplierService getInstance(){
        return new SupplierService();
    }

    @Override
    public void createTable() {
        try{
            // Buoc 1: tao connection
            Connection connection = JDBCConnect.connect();

            // Buoc 2: tao doi tuong Statement
            Statement statement = connection.createStatement();

            // Buoc 3: thuc thi cau len SQL
            String query = "CREATE TABLE suppliers (" +
                    "    supplierNumber INT AUTO_INCREMENT," +
                    "    supplierName VARCHAR(50) NOT NULL," +
                    "    phone VARCHAR(50)," +
                    "    addressLine1 VARCHAR(50)," +
                    "    addressLine2 VARCHAR(50)," +
                    "    city VARCHAR(50)," +
                    "    state VARCHAR(50)," +
                    "    postalCode VARCHAR(50)," +
                    "    country VARCHAR(50)," +
                    "    customerNumber INT," +
                    "    PRIMARY KEY (supplierNumber)" +
                    ")";
            System.out.println("Tao thanh cong Suppliers table");
            statement.execute(query);
            // Buoc 5: ngat ket noi
            JDBCConnect.close(connection);

        }catch(SQLException e){
            System.out.println(e);
        }

    }

    @Override
    public void add(Supplier supplier) {
        try{
            // Buoc 1: tao connection
            Connection connection = JDBCConnect.connect();

            // Buoc 2: tao doi tuong Statement
            Statement statement = connection.createStatement();

            // Buoc 3: thuc thi cau len SQL
                String query = "INSERT INTO suppliers (" +
                        "    supplierName, " +
                        "    phone, " +
                        "    addressLine1," +
                        "    addressLine2," +
                        "    city," +
                        "    state," +
                        "    postalCode," +
                        "    country," +
                        "    customerNumber" +
                        ")" +
                        "SELECT " +
                        "    customerName," +
                        "    phone," +
                        "    addressLine1," +
                        "    addressLine2," +
                        "    city," +
                        "    state ," +
                        "    postalCode," +
                        "    country," +
                        "    customerNumber" +
                        "FROM " +
                        "    customers" +
                        "WHERE " +
                        "    country = 'USA' AND " +
                        "    state = 'CA';";
            System.out.println("Them thanh cong Suppliers table");
            statement.execute(query);
            // Buoc 5: ngat ket noi
            JDBCConnect.close(connection);

        }catch(SQLException e){
            System.out.println(e);
        }
    }

    @Override
    public void delete(Supplier supplier) {

    }

    @Override
    public void update(Supplier supplier) {

    }

    @Override
    public List<Supplier> selectAll() {
        List<Supplier>listSupplier = new ArrayList<>();
        try{
            // Buoc 1: tao connection
            Connection connection = JDBCConnect.connect();

            // Buoc 2: tao doi tuong Statement
            Statement statement = connection.createStatement();

            // Buoc 3: thuc thi cau len SQL
            String query = "SELECT * FROM suppliers";
            System.out.println("Chọn tất cả thanh cong Suppliers table");
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                 int supplierNumber = resultSet.getInt("supplierNumber");
                 String supplierName = resultSet.getString("supplierName");
                 String phone = resultSet.getString("phone");
                 String addressLine1 = resultSet.getString("addressLine1");
                 String addressLine2 = resultSet.getString("addressLine2");
                 String city = resultSet.getString("city");
                 String state = resultSet.getString("state");
                 String postalCode = resultSet.getString("postCode");
                 String country = resultSet.getString("country");
                 int customerNumber = resultSet.getInt("customerNumber");

                 Supplier supplier = new Supplier(supplierNumber, supplierName, phone, addressLine1, addressLine2, city, state, postalCode,country, customerNumber);
                 listSupplier.add(supplier);
            }
            // Buoc 5: ngat ket noi
            JDBCConnect.close(connection);

        }catch(SQLException e){
            System.out.println(e);
        }
        return listSupplier;
    }

    @Override
    public Supplier selectById(int id) {
        return null;
    }

    @Override
    public List<Supplier> selectByCondition(String condition) {
        return null;
    }

    public int numberHaveKey(String key){
        int resp = 0;
        try{
            // Buoc 1: tao connection
            Connection connection = JDBCConnect.connect();

            // Buoc 2: tao doi tuong Statement
            Statement statement = connection.createStatement();

            // Buoc 3: thuc thi cau len SQL
            String query = "SHOW VARIABLES LIKE '" + key + "'";
            ResultSet resultSet = statement.executeQuery(query);
            resp = resultSet.getInt("value");
            // Buoc 5: ngat ket noi
            JDBCConnect.close(connection);


        }catch(SQLException e) {
            System.out.println(e);
        }
        return resp;
    }
}
