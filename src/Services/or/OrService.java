package Services.or;


import Utils.JDBCConnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrService {
    public static OrService getInstance(){
        return new OrService();
    }

    public void or(){
        List<OrData> list = new ArrayList<>();
        try{
            // Buoc 1: tao connection
            Connection connection = JDBCConnect.connect();

            // Buoc 2: tao doi tuong Statement
            Statement statement = connection.createStatement();

            // Buoc 3: thuc thi cau len SQL
            String query = "SELECT    \n" +
                    "    customername, \n" +
                    "    country, \n" +
                    "    creditLimit\n" +
                    " FROM    \n" +
                    "    customers\n" +
                    " WHERE \n" +
                    "    country = 'USA'\n" +
                    "    OR country = 'France'\n" +
                    "    AND creditlimit > 100000;";

            ResultSet reuslt = statement.executeQuery(query);

            while (reuslt.next()){
                String customername = reuslt.getString("customername");
                String country = reuslt.getString("country");
                double creditLimit = reuslt.getDouble("creditLimit");

                OrData obj = new OrData(customername, country, creditLimit);
                list.add(obj);
            }
            // Buoc 5: ngat ket noi
            JDBCConnect.close(connection);

        }catch(SQLException e){
            System.out.println(e);
        }
        for (OrData obj : list) {
            System.out.println("customername - country - creditLimit: " + obj.getCustomername() + " - " + obj.getCountry() + " - " + obj.getCreditLimit() );
        }
    }
    public void orWithIn(){
        List<OrData> list = new ArrayList<>();
        try{
            // Buoc 1: tao connection
            Connection connection = JDBCConnect.connect();

            // Buoc 2: tao doi tuong Statement
            Statement statement = connection.createStatement();

            // Buoc 3: thuc thi cau len SQL
            String query = "SELECT    \n" +
                    "    customername, \n" +
                    "    country, \n" +
                    "    creditLimit\n" +
                    " FROM    \n" +
                    "    customers\n" +
                    " WHERE \n" +
                    "     country IN ('USA' , 'France')";

            ResultSet reuslt = statement.executeQuery(query);

            while (reuslt.next()){
                String customername = reuslt.getString("customername");
                String country = reuslt.getString("country");
                double creditLimit = reuslt.getDouble("creditLimit");

                OrData obj = new OrData(customername, country, creditLimit);
                list.add(obj);
            }
            // Buoc 5: ngat ket noi
            JDBCConnect.close(connection);

        }catch(SQLException e){
            System.out.println(e);
        }
        for (OrData obj : list) {
            System.out.println("customername - country - creditLimit: " + obj.getCustomername() + " - " + obj.getCountry() + " - " + obj.getCreditLimit() );
        }
    }
}
