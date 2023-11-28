package Services.where;

import Services.orderBy.OrderByData;
import Utils.JDBCConnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class WhereService {
    public static WhereService getInstance(){
        return new WhereService();
    }
    public void where(){
        List<WhereData> list = new ArrayList<>();
        try{
            // Buoc 1: tao connection
            Connection connection = JDBCConnect.connect();

            // Buoc 2: tao doi tuong Statement
            Statement statement = connection.createStatement();

            // Buoc 3: thuc thi cau len SQL
            String query = "SELECT lastname, firstname, jobtitle FROM employees WHERE jobtitle = 'Sales Rep'";

            ResultSet reuslt = statement.executeQuery(query);

            while (reuslt.next()){
                String lastname = reuslt.getString("lastname");
                String firstname = reuslt.getString("firstname");
                String jobtitle = reuslt.getString("jobtitle");

                WhereData obj = new WhereData(lastname, firstname, jobtitle);
                list.add(obj);
            }
            // Buoc 5: ngat ket noi
            JDBCConnect.close(connection);

        }catch(SQLException e){
            System.out.println(e);
        }
        for (WhereData obj : list) {
            System.out.println("lastname - firstname - jobtitle: " + obj.getLastname() + " - " + obj.getFirstname() + " - " + obj.getJobtitle() );
        }
    }

}
