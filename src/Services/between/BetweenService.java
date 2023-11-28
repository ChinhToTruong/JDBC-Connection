package Services.between;

import Services.or.OrData;
import Utils.JDBCConnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BetweenService {
    public static BetweenService getInstance(){
        return new BetweenService();
    }
    public void Between(){
        List<BetweenData> list = new ArrayList<>();
        try{
            // Buoc 1: tao connection
            Connection connection = JDBCConnect.connect();

            // Buoc 2: tao doi tuong Statement
            Statement statement = connection.createStatement();

            // Buoc 3: thuc thi cau len SQL
            String query = "SELECT \n" +
                    "    productCode, \n" +
                    "    productName, \n" +
                    "    buyPrice\n" +
                    " FROM\n" +
                    "    products\n" +
                    " WHERE\n" +
                    "    buyPrice BETWEEN 90 AND 100;";

            ResultSet reuslt = statement.executeQuery(query);

            while (reuslt.next()){
                String productCode = reuslt.getString("productCode");
                String productName = reuslt.getString("productName");
                double buyPrice = reuslt.getDouble("buyPrice");

                BetweenData obj = new BetweenData(productCode, productName, buyPrice);
                list.add(obj);
            }
            // Buoc 5: ngat ket noi
            JDBCConnect.close(connection);

        }catch(SQLException e){
            System.out.println(e);
        }
        for (BetweenData obj : list) {
            System.out.println("productCode - productName - buyPrice: " + obj.getProductCode() + " - " + obj.getProductName() + " - " + obj.getBuyPrice() );
        }
    }
}
