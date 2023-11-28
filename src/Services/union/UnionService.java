package Services.union;

import Services.join.JoinData;
import Utils.JDBCConnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UnionService {
    public static UnionService getInstance(){
        return new UnionService();
    }
    public void union(){
        List<UnionData> list = new ArrayList<>();
        try{
            // Buoc 1: tao connection
            Connection connection = JDBCConnect.connect();

            // Buoc 2: tao doi tuong Statement
            Statement statement = connection.createStatement();

            // Buoc 3: thuc thi cau len SQL
            String query2 = "SELECT \n" +
                    "    firstName, \n" +
                    "    lastName\n" +
                    " FROM\n" +
                    "    employees \n" +
                    " UNION \n" +
                    " SELECT \n" +
                    "    contactFirstName, \n" +
                    "    contactLastName\n" +
                    " FROM\n" +
                    "    customers;";
            ResultSet result = statement.executeQuery(query2);

            while (result.next()){
                String firstName = result.getString("firstName");
                String lastName = result.getString("lastName");

                UnionData obj = new UnionData(firstName, lastName);
                list.add(obj);
            }
            // Buoc 5: ngat ket noi
            JDBCConnect.close(connection);

        }catch(SQLException e){
            System.out.println(e);
        }
        for (UnionData obj : list) {
            System.out.println("firstName - lastName: " + obj.getFirstName() + " - " + obj.getLastName() );
        }
    }
}
