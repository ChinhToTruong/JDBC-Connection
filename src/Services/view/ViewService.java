package Services.view;

import Services.union.UnionData;
import Utils.JDBCConnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ViewService {
    public static ViewService getInstance(){
        return new ViewService();
    }

    public void view(){
        List<ViewData> list = new ArrayList<>();
        try{
            // Buoc 1: tao connection
            Connection connection = JDBCConnect.connect();

            // Buoc 2: tao doi tuong Statement
            Statement statement = connection.createStatement();

            // Buoc 3: thuc thi cau len SQL
            String query1 = "CREATE VIEW customerPayments\n" +
                    " AS \n" +
                    " SELECT \n" +
                    "    customerName, \n" +
                    "    checkNumber, \n" +
                    "    paymentDate, \n" +
                    "    amount\n" +
                    " FROM\n" +
                    "    customers\n" +
                    " INNER JOIN\n" +
                    "    payments USING (customerNumber);";
            statement.execute(query1);

            String query2 = "SELECT * FROM customerPayments;";
            ResultSet result = statement.executeQuery(query2);


            while (result.next()){
                String customerName = result.getString("customerName");
                String checkNumber = result.getString("checkNumber");
                Date paymentDate = result.getDate("paymentDate");
                double amount = result.getDouble("amount");

                ViewData obj = new ViewData(customerName, checkNumber, paymentDate , amount);
                list.add(obj);
            }
            // Buoc 5: ngat ket noi
            JDBCConnect.close(connection);

        }catch(SQLException e){
            System.out.println(e);
        }
        for (ViewData obj : list) {
            System.out.println("customerName - checkNumber - paymentDate - amount: " + obj.getCustomerName() + " - " + obj.getCheckNumber() + " - " + obj.getPaymentDate() + " - " + obj.getAmount() );
        }
    }
}
