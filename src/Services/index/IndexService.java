package Services.index;

import Services.insert.InsertData;
import Utils.JDBCConnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class IndexService {
    public static IndexService getInstance(){
        return new IndexService();
    }
    public void createIndex(){
        List<IndexData> list = new ArrayList<>();
        try{
            // Buoc 1: tao connection
            Connection connection = JDBCConnect.connect();

            // Buoc 2: tao doi tuong Statement
            Statement statement = connection.createStatement();

            // Buoc 3: thuc thi cau len SQL
            String query = "CREATE INDEX jobTitle \n" +
                    "ON employees(jobTitle);";
            statement.execute(query);

            String query2 = "SHOW INDEXES FROM employees;";
            ResultSet result = statement.executeQuery(query2);

            while (result.next()){
                String tableName = result.getString("table");
                int nonUnique = result.getInt("non_unique");
                String keyName = result.getString("key_name");
                int seqInIndex = result.getInt("seq_in_index");
                String colunmName = result.getString("colunm_name");

                IndexData obj = new IndexData(tableName, nonUnique, keyName, seqInIndex, colunmName);
                list.add(obj);
            }
            // Buoc 5: ngat ket noi
            JDBCConnect.close(connection);

        }catch(SQLException e){
            System.out.println(e);
        }
        for (IndexData obj : list) {
            System.out.println("table - non_unique - key_name - seq_in_index - colunm_name: " + obj.getTableName() + " - " + obj.getNonUnique() + " - " + obj.getKeyName() +  " - " + obj.getSeqInIndex()  + " - " + obj.getColunmName()  );
        }
    }
    public void dropIndexWithLock(){
        List<IndexData> list = new ArrayList<>();
        try{
            // Buoc 1: tao connection
            Connection connection = JDBCConnect.connect();

            // Buoc 2: tao doi tuong Statement
            Statement statement = connection.createStatement();

            // Buoc 3: thuc thi cau len SQL
            String query = "CREATE TABLE leads2(\n" +
                    "    lead_id INT AUTO_INCREMENT,\n" +
                    "    first_name VARCHAR(100) NOT NULL,\n" +
                    "    last_name VARCHAR(100) NOT NULL,\n" +
                    "    email VARCHAR(255) NOT NULL,\n" +
                    "    information_source VARCHAR(255),\n" +
                    "    INDEX name(first_name,last_name),\n" +
                    "    UNIQUE email(email),\n" +
                    "    PRIMARY KEY(lead_id)\n" +
                    ");";
            statement.execute(query);

            String query2 = "DROP INDEX email ON leads2\n" +
                    " ALGORITHM = INPLACE \n" +
                    " LOCK = DEFAULT;";

            statement.execute(query2);

            String query3 = "SHOW INDEXES FROM employees;";
            ResultSet result = statement.executeQuery(query2);

            while (result.next()){
                String tableName = result.getString("table");
                int nonUnique = result.getInt("non_unique");
                String keyName = result.getString("key_name");
                int seqInIndex = result.getInt("seq_in_index");
                String colunmName = result.getString("colunm_name");

                IndexData obj = new IndexData(tableName, nonUnique, keyName, seqInIndex, colunmName);
                list.add(obj);
            }
            // Buoc 5: ngat ket noi
            JDBCConnect.close(connection);

        }catch(SQLException e){
            System.out.println(e);
        }
        for (IndexData obj : list) {
            System.out.println("table - non_unique - key_name - seq_in_index - colunm_name: " + obj.getTableName() + " - " + obj.getNonUnique() + " - " + obj.getKeyName() +  " - " + obj.getSeqInIndex()  + " - " + obj.getColunmName()  );
        }
    }
    public void dropPrimaryIndex(){
        List<IndexData> list = new ArrayList<>();
        try{
            // Buoc 1: tao connection
            Connection connection = JDBCConnect.connect();

            // Buoc 2: tao doi tuong Statement
            Statement statement = connection.createStatement();

            // Buoc 3: thuc thi cau len SQL
            String query = "CREATE TABLE t(\n" +
                    "    pk INT PRIMARY KEY,\n" +
                    "    c VARCHAR(10)\n" +
                    ");";
            statement.execute(query);

            String query2 = "DROP INDEX `PRIMARY` ON t;";

            statement.execute(query2);

            String query3 = "SHOW INDEXES FROM t";
            ResultSet result = statement.executeQuery(query3);

            while (result.next()){
                String tableName = result.getString("table");
                int nonUnique = result.getInt("non_unique");
                String keyName = result.getString("key_name");
                int seqInIndex = result.getInt("seq_in_index");
                String colunmName = result.getString("colunm_name");

                IndexData obj = new IndexData(tableName, nonUnique, keyName, seqInIndex, colunmName);
                list.add(obj);
            }
            // Buoc 5: ngat ket noi
            JDBCConnect.close(connection);

        }catch(SQLException e){
            System.out.println(e);
        }
        for (IndexData obj : list) {
            System.out.println("table - non_unique - key_name - seq_in_index - colunm_name: " + obj.getTableName() + " - " + obj.getNonUnique() + " - " + obj.getKeyName() +  " - " + obj.getSeqInIndex()  + " - " + obj.getColunmName()  );
        }
    }
}
