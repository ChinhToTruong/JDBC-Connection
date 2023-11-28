package Services.join;

import Services.insert.InsertData;
import Utils.JDBCConnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JoinService {
    public static JoinService getInstance(){
        return new JoinService();
    }

    public void innerJoin(){
        List<JoinData> list = new ArrayList<>();
        try{
            // Buoc 1: tao connection
            Connection connection = JDBCConnect.connect();

            // Buoc 2: tao doi tuong Statement
            Statement statement = connection.createStatement();

            // Buoc 3: thuc thi cau len SQL
            String query2 = "SELECT \n" +
                    "    productCode, \n" +
                    "    productName, \n" +
                    "    textDescription\n" +
                    " FROM\n" +
                    "    products t1\n" +
                    " INNER JOIN productlines t2 \n" +
                    "    ON t1.productline = t2.productline;";
            ResultSet result = statement.executeQuery(query2);

            while (result.next()){
                String productCode = result.getString("productCode");
                String productName = result.getString("productName");
                String textDescription = result.getString("textDescription");

                JoinData obj = new JoinData(productCode, productName, textDescription);
                list.add(obj);
            }
            // Buoc 5: ngat ket noi
            JDBCConnect.close(connection);

        }catch(SQLException e){
            System.out.println(e);
        }
        for (JoinData obj : list) {
            System.out.println("productCode - productName - textDescription: " + obj.getProductCode() + " - " + obj.getProductName() + " - " + obj.getTextDescription()  );
        }
    }
    public void leftJoin(){
        List<JoinData> list = new ArrayList<>();
        try{
            // Buoc 1: tao connection
            Connection connection = JDBCConnect.connect();

            // Buoc 2: tao doi tuong Statement
            Statement statement = connection.createStatement();

            // Buoc 3: thuc thi cau len SQL
            String query2 = "SELECT \n" +
                    "    productCode, \n" +
                    "    productName, \n" +
                    "    textDescription\n" +
                    " FROM\n" +
                    "    products t1\n" +
                    " left JOIN productlines t2 \n" +
                    "    ON t1.productline = t2.productline;";
            ResultSet result = statement.executeQuery(query2);

            while (result.next()){
                String productCode = result.getString("productCode");
                String productName = result.getString("productName");
                String textDescription = result.getString("textDescription");

                JoinData obj = new JoinData(productCode, productName, textDescription);
                list.add(obj);
            }
            // Buoc 5: ngat ket noi
            JDBCConnect.close(connection);

        }catch(SQLException e){
            System.out.println(e);
        }
        for (JoinData obj : list) {
            System.out.println("productCode - productName - textDescription: " + obj.getProductCode() + " - " + obj.getProductName() + " - " + obj.getTextDescription()  );
        }
    }
    public void rightJoin(){
        List<JoinData> list = new ArrayList<>();
        try{
            // Buoc 1: tao connection
            Connection connection = JDBCConnect.connect();

            // Buoc 2: tao doi tuong Statement
            Statement statement = connection.createStatement();

            // Buoc 3: thuc thi cau len SQL
            String query2 = "SELECT \n" +
                    "    productCode, \n" +
                    "    productName, \n" +
                    "    textDescription\n" +
                    " FROM\n" +
                    "    products t1\n" +
                    " right JOIN productlines t2 \n" +
                    "    ON t1.productline = t2.productline;";
            ResultSet result = statement.executeQuery(query2);

            while (result.next()){
                String productCode = result.getString("productCode");
                String productName = result.getString("productName");
                String textDescription = result.getString("textDescription");

                JoinData obj = new JoinData(productCode, productName, textDescription);
                list.add(obj);
            }
            // Buoc 5: ngat ket noi
            JDBCConnect.close(connection);

        }catch(SQLException e){
            System.out.println(e);
        }
        for (JoinData obj : list) {
            System.out.println("productCode - productName - textDescription: " + obj.getProductCode() + " - " + obj.getProductName() + " - " + obj.getTextDescription()  );
        }
    }
}
