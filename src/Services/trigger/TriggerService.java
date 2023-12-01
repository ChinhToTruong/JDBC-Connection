package Services.trigger;

import Services.index.IndexData;
import Utils.JDBCConnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TriggerService {
    public static TriggerService getInstance(){
        return new TriggerService();
    }
    public void createTrigger(){
        List<TriggerData> list = new ArrayList<>();
        try{
            // Buoc 1: tao connection
            Connection connection = JDBCConnect.connect();

            // Buoc 2: tao doi tuong Statement
            Statement statement = connection.createStatement();

            // Buoc 3: thuc thi cau len SQL
            String query = "CREATE TABLE if not exists employees_audit (" +
                    "    id INT AUTO_INCREMENT PRIMARY KEY," +
                    "    employeeNumber INT NOT NULL," +
                    "    lastname VARCHAR(50) NOT NULL," +
                    "    changedat DATETIME DEFAULT NULL," +
                    "    action VARCHAR(50) DEFAULT NULL" +
                    ");";
            statement.execute(query);

            String query2 = "CREATE TRIGGER if not exists before_employee_update " +
                    "    BEFORE UPDATE ON employees" +
                    "    FOR EACH ROW " +
                    " INSERT INTO employees_audit" +
                    " SET action = 'update'," +
                    "     employeeNumber = OLD.employeeNumber," +
                    "     lastname = OLD.lastname," +
                    "     changedat = NOW();";

            statement.execute(query2);

            String query3 = "SHOW TRIGGERS;";
            ResultSet result = statement.executeQuery(query3);

            while (result.next()){
                String name = result.getString("trigger");
                String event = result.getString("event");
                String tableName = result.getString("table");
                String statementTrigger = result.getString("statement");
                String timing = result.getString("timing");

                TriggerData obj = new TriggerData(name, event, tableName, statementTrigger, timing);
                list.add(obj);
            }
            // Buoc 5: ngat ket noi
            JDBCConnect.close(connection);

        }catch(SQLException e){
            System.out.println(e);
        }
        for (TriggerData obj : list) {
            System.out.println("trigger - event - table - statement - timing: " + obj.name+ " - " + obj.event + " - " + obj.tableName +  " - " + obj.statementTrigger  + " - " + obj.timing  );
        }
    }

    public void activeTrigger(){
        try{
            // Buoc 1: tao connection
            Connection connection = JDBCConnect.connect();

            // Buoc 2: tao doi tuong Statement
            Statement statement = connection.createStatement();

            // Buoc 3: thuc thi cau len SQL
            String query = "UPDATE employees " +
                    " SET " +
                    "    lastName = 'Phan'" +
                    " WHERE" +
                    "    employeeNumber = 1056;";
            statement.execute(query);


            // Buoc 5: ngat ket noi
            JDBCConnect.close(connection);

        }catch(SQLException e){
            System.out.println(e);
        }

    }

    public void createMultiTrigger(){
        List<TriggerData> list = new ArrayList<>();
        try{
            // Buoc 1: tao connection
            Connection connection = JDBCConnect.connect();

            // Buoc 2: tao doi tuong Statement
            Statement statement = connection.createStatement();

            // Buoc 3: thuc thi cau len SQL
            String query = "CREATE TABLE PriceLogs (" +
                    "    id INT AUTO_INCREMENT," +
                    "    productCode VARCHAR(15) NOT NULL," +
                    "    price DECIMAL(10,2) NOT NULL," +
                    "    updated_at TIMESTAMP NOT NULL " +
                    " DEFAULT CURRENT_TIMESTAMP " +
                    "            ON UPDATE CURRENT_TIMESTAMP," +
                    "    PRIMARY KEY (id)," +
                    "    FOREIGN KEY (productCode)" +
                    "        REFERENCES products (productCode)" +
                    "        ON DELETE CASCADE " +
                    "        ON UPDATE CASCADE" +
                    ");";
            statement.execute(query);

            String query2 = "DELIMITER $$" +
                    "" +
                    " CREATE TRIGGER before_products_update " +
                    "   BEFORE UPDATE ON products " +
                    "   FOR EACH ROW " +
                    " BEGIN" +
                    "     IF OLD.msrp <> NEW.msrp THEN" +
                    "         INSERT INTO PriceLOgs(productCode,price)" +
                    "         VALUES(old.productCode,old.msrp);" +
                    "     END IF;" +
                    " END$$" +
                    " DELIMITER ;";

            statement.execute(query2);

            String query3 = "SHOW TRIGGERS;";
            ResultSet result = statement.executeQuery(query3);

            while (result.next()){
                String name = result.getString("trigger");
                String event = result.getString("event");
                String tableName = result.getString("table");
                String statementTrigger = result.getString("statement");
                String timing = result.getString("timing");

                TriggerData obj = new TriggerData(name, event, tableName, statementTrigger, timing);
                list.add(obj);
            }
            // Buoc 5: ngat ket noi
            JDBCConnect.close(connection);

        }catch(SQLException e){
            System.out.println(e);
        }
        for (TriggerData obj : list) {
            System.out.println("trigger - event - table - statement - timing: " + obj.name+ " - " + obj.event + " - " + obj.tableName +  " - " + obj.statementTrigger  + " - " + obj.timing  );
        }
    }
    public void activeMultiTrigger(){
        try{
            // Buoc 1: tao connection
            Connection connection = JDBCConnect.connect();

            // Buoc 2: tao doi tuong Statement
            Statement statement = connection.createStatement();

            // Buoc 3: thuc thi cau len SQL
            String query = "UPDATE products" +
                    " SET msrp = 200" +
                    " WHERE productCode = 'S12_1099';";
            statement.execute(query);


            // Buoc 5: ngat ket noi
            JDBCConnect.close(connection);

        }catch(SQLException e){
            System.out.println(e);
        }
    }
}
