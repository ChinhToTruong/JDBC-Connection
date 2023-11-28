package Services.and;


import Utils.JDBCConnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AndService {
    public static AndService getInstance(){
        return new AndService();
    }
    public void And(){
        List<AndData> list = new ArrayList<>();
        try{
            // Buoc 1: tao connection
            Connection connection = JDBCConnect.connect();

            // Buoc 2: tao doi tuong Statement
            Statement statement = connection.createStatement();

            // Buoc 3: thuc thi cau len SQL
            String query = "SELECT \n" +
                    "    customername, \n" +
                    "    country, \n" +
                    "    state\n" +
                    " FROM\n" +
                    "    customers\n" +
                    " WHERE\n" +
                    "    country = 'USA' AND \n" +
                    "    state = 'CA';";

            ResultSet reuslt = statement.executeQuery(query);

            while (reuslt.next()){
                String state = reuslt.getString("state");
                String country = reuslt.getString("country");
                String customername = reuslt.getString("customername");

                AndData obj = new AndData(state, country, customername);
                list.add(obj);
            }
            // Buoc 5: ngat ket noi
            JDBCConnect.close(connection);

        }catch(SQLException e){
            System.out.println(e);
        }
        for (AndData obj : list) {
            System.out.println("customername - country - state: " + obj.getCustomername() + " - " + obj.getCountry() + " - " + obj.getState() );
        }
    }
}
