package Services.insert;

import Services.between.BetweenData;
import Utils.JDBCConnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class InsertService {
    public static InsertService getInstance(){
        return new InsertService();
    }
    public void insert(){
        List<InsertData> list = new ArrayList<>();
        try{
            // Buoc 1: tao connection
            Connection connection = JDBCConnect.connect();

            // Buoc 2: tao doi tuong Statement
            Statement statement = connection.createStatement();

            // Buoc 3: thuc thi cau len SQL
            String query = "CREATE TABLE IF NOT EXISTS tasks (\n" +
                    "    task_id INT AUTO_INCREMENT,\n" +
                    "    title VARCHAR(255) NOT NULL,\n" +
                    "    priority TINYINT NOT NULL DEFAULT 3,\n" +
                    "    description TEXT,\n" +
                    "    PRIMARY KEY (task_id)\n" +
                    ");";
            statement.execute(query);

            String query1 = "INSERT INTO tasks(title,priority)\n" +
                    " VALUES('Learn MySQL INSERT Statement',1);";
            statement.execute(query1);

            String query2 = "SELECT * FROM tasks;";
            ResultSet result = statement.executeQuery(query2);

            while (result.next()){
                int task_id = result.getInt("task_id");
                String title = result.getString("title");
                int priority = result.getInt("priority");
                String decription = result.getString("description");

                InsertData obj = new InsertData(task_id, title, priority, decription);
                list.add(obj);
            }
            // Buoc 5: ngat ket noi
            JDBCConnect.close(connection);

        }catch(SQLException e){
            System.out.println(e);
        }
        for (InsertData obj : list) {
            System.out.println("task_id - title - priority - decription: " + obj.getTask_id() + " - " + obj.getTitle() + " - " + obj.getPriority() +  " - " + obj.getDecription()  );
        }
    }
}
