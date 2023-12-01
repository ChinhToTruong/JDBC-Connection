package Services.storedProcedure;

import Services.union.UnionData;
import Utils.JDBCConnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StoredProcedureService {
    public static StoredProcedureService getInstance(){
        return new StoredProcedureService();
    }
    public void testProcedure(){
        try{
            // Buoc 1: tao connection
            Connection connection = JDBCConnect.connect();

            // Buoc 2: tao doi tuong Statement
            // Chuẩn bị câu lệnh gọi thủ tục lưu trữ
            String callProcedure = "{CALL GetOrderCountByStatus(?, ?)}";
            CallableStatement statement = connection.prepareCall(callProcedure);
            // Buoc 3: thuc thi cau len SQL

            // Đặt giá trị cho tham số đầu vào orderStatus
            statement.setString(1, "Shipped");

            // Đăng ký tham số đầu ra total
            statement.registerOutParameter(2, Types.INTEGER);

            // Thực thi thủ tục lưu trữ
            statement.execute();

            // Lấy giá trị của tham số đầu ra total
            int total = statement.getInt(2);

            // In ra kết quả
            System.out.println("Total orders with status 'Shipped': " + total);
            // Buoc 5: ngat ket noi
            JDBCConnect.close(connection);

        }catch(SQLException e){
            System.out.println(e);
        }

    }


}
