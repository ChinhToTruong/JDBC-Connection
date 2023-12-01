package Services.storedFunction;

import Services.storedFunction.StoredFunctionService;
import Utils.JDBCConnect;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class StoredFunctionService {
    public static StoredFunctionService getInstance(){
        return new StoredFunctionService();
    }
    public void testFunction(){
        try{
            // Buoc 1: tao connection
            Connection connection = JDBCConnect.connect();

            // Buoc 2: tao doi tuong Statement
            // Chuẩn bị câu lệnh gọi thủ tục lưu trữ
            // Chuẩn bị câu lệnh gọi function
            String callFunction = "{? = CALL CalculateTotalAmount()}";

            // Tạo đối tượng CallableStatement
            CallableStatement statement = connection.prepareCall(callFunction);

            // Đăng ký tham số đầu ra total
            statement.registerOutParameter(1, Types.DECIMAL);

            // Thực thi function
            statement.execute();

            // Lấy giá trị của tham số đầu ra total
            double total = statement.getDouble(1);

            // In ra kết quả
            System.out.println("Total amount: " + total);
            // Buoc 5: ngat ket noi
            JDBCConnect.close(connection);

        }catch(SQLException e){
            System.out.println(e);
        }

    }
}
