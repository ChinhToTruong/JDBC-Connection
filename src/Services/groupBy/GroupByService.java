package Services.groupBy;

import Utils.JDBCConnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GroupByService {
    public static GroupByService getInstance(){
        return new GroupByService();
    }
    public void groupBy(){
        List<GroupByData> list = new ArrayList<>();
        try{
            // Buoc 1: tao connection
            Connection connection = JDBCConnect.connect();

            // Buoc 2: tao doi tuong Statement
            Statement statement = connection.createStatement();

            // Buoc 3: thuc thi cau len SQL
            String query = "SELECT \n" +
                    "  YEAR(orderDate) AS year, \n" +
                    "  SUM(quantityOrdered * priceEach) AS total \n" +
                    " FROM \n" +
                    "  orders \n" +
                    "  INNER JOIN orderdetails USING (orderNumber) \n" +
                    " WHERE \n" +
                    "  status = 'Shipped' \n" +
                    " GROUP BY \n" +
                    "  year \n" +
                    " HAVING \n" +
                    "  year > 2003;";

            ResultSet result = statement.executeQuery(query);

            while (result.next()){
                Long year = result.getLong("year");
                double total = result.getDouble("total");

                GroupByData obj = new GroupByData(year, total);
                list.add(obj);
            }
            // Buoc 5: ngat ket noi
            JDBCConnect.close(connection);

        }catch(SQLException e){
            System.out.println(e);
        }
        for (GroupByData obj : list) {
            System.out.println("year - total: " + obj.getYear() + " - " + obj.getTotal());
        }
    }
}
