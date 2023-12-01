package Services.storedProcedure;

import Services.union.UnionData;
import Utils.JDBCConnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StoredProcedureService {
    public static StoredProcedureService getInstance(){
        return new StoredProcedureService();
    }
    public void createProcedure(){
        List<StoredProcedureData> list = new ArrayList<>();
        try{
            // Buoc 1: tao connection
            Connection connection = JDBCConnect.connect();

            // Buoc 2: tao doi tuong Statement
            Statement statement = connection.createStatement();

            // Buoc 3: thuc thi cau len SQL
            String query2 = "DELIMITER $$" +
                    " CREATE PROCEDURE GetCustomers()" +
                    " BEGIN" +
                    " SELECT " +
                    " customerName, " +
                    " city, " +
                    " state, " +
                    " postalCode, " +
                    " country" +
                    " FROM" +
                    " customers" +
                    " ORDER BY customerName;    " +
                    " END$$" +
                    " DELIMITER ;";
            statement.execute(query2);

            String query = "CALL GetCustomers();";

            ResultSet result = statement.executeQuery(query);

            while (result.next()){
                String customerName = result.getString("customerName");
                String city = result.getString("city");
                String state = result.getString("state");
                String postalCode = result.getString("postalCode");
                String country = result.getString("country");

                StoredProcedureData obj = new StoredProcedureData(customerName, city, state, postalCode, country);
                list.add(obj);
            }
            // Buoc 5: ngat ket noi
            JDBCConnect.close(connection);

        }catch(SQLException e){
            System.out.println(e);
        }
        for (StoredProcedureData obj : list) {
            System.out.println("firstName - lastName: " + obj.customerName + " - " + obj.city + " - " + obj.state + " - " + obj.postalCode+ " - " + obj.country );
        }
    }
    public void createProcedureWithParameterIN(){
        List<StoredProcedureData> list = new ArrayList<>();
        try{
            // Buoc 1: tao connection
            Connection connection = JDBCConnect.connect();

            // Buoc 2: tao doi tuong Statement
            Statement statement = connection.createStatement();

            // Buoc 3: thuc thi cau len SQL
            String query2 = "DELIMITER //\n" +
                    "\n" +
                    " CREATE PROCEDURE GetOfficeByCountry(\n" +
                    " \tIN countryName VARCHAR(255)\n" +
                    " )\n" +
                    " BEGIN\n" +
                    " \tSELECT * \n" +
                    " \tFROM offices\n" +
                    " \tWHERE country = countryName;\n" +
                    " END //\n" +
                    "\n" +
                    " DELIMITER ;";
            statement.execute(query2);

            String query = "CALL GetOfficeByCountry('USA');";

            ResultSet result = statement.executeQuery(query);

            while (result.next()){
                String customerName = result.getString("customerName");
                String city = result.getString("city");
                String state = result.getString("state");
                String postalCode = result.getString("postalCode");
                String country = result.getString("country");

                StoredProcedureData obj = new StoredProcedureData(customerName, city, state, postalCode, country);
                list.add(obj);
            }
            // Buoc 5: ngat ket noi
            JDBCConnect.close(connection);

        }catch(SQLException e){
            System.out.println(e);
        }
        for (StoredProcedureData obj : list) {
            System.out.println("firstName - lastName: " + obj.customerName + " - " + obj.city + " - " + obj.state + " - " + obj.postalCode+ " - " + obj.country );
        }
    }
    public void createProcedureWithParameterOut(){
        List<StoredProcedureData> list = new ArrayList<>();
        try{
            // Buoc 1: tao connection
            Connection connection = JDBCConnect.connect();

            // Buoc 2: tao doi tuong Statement
            Statement statement = connection.createStatement();

            // Buoc 3: thuc thi cau len SQL
            String query2 = "DELIMITER $$\n" +
                    "\n" +
                    "CREATE PROCEDURE GetOrderCountByStatus (\n" +
                    "\tIN  orderStatus VARCHAR(25),\n" +
                    "\tOUT total INT\n" +
                    ")\n" +
                    "BEGIN\n" +
                    "\tSELECT COUNT(orderNumber)\n" +
                    "\tINTO total\n" +
                    "\tFROM orders\n" +
                    "\tWHERE status = orderStatus;\n" +
                    "END$$\n" +
                    "\n" +
                    "DELIMITER ;";
            statement.execute(query2);

            String query = "CALL GetOrderCountByStatus('Shipped',@total);";

            ResultSet result = statement.executeQuery(query);

            while (result.next()){
                String customerName = result.getString("customerName");
                String city = result.getString("city");
                String state = result.getString("state");
                String postalCode = result.getString("postalCode");
                String country = result.getString("country");

                StoredProcedureData obj = new StoredProcedureData(customerName, city, state, postalCode, country);
                list.add(obj);
            }
            // Buoc 5: ngat ket noi
            JDBCConnect.close(connection);

        }catch(SQLException e){
            System.out.println(e);
        }
        for (StoredProcedureData obj : list) {
            System.out.println("firstName - lastName: " + obj.customerName + " - " + obj.city + " - " + obj.state + " - " + obj.postalCode+ " - " + obj.country );
        }
    }

}
