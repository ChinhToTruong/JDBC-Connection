package Service;

import Models.Employee;
import Utils.JDBCConnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    public static EmployeeDAO getInstance() {
        return new EmployeeDAO();
    }
    public List<Employee> searchEmployeeByKey(String key){
        List<Employee> listEmployee = new ArrayList<>();

        try{
            // Buoc 1: tao connection
            Connection connection = JDBCConnect.connect();

            // Buoc 2: tao doi tuong Statement
            Statement statement = connection.createStatement();

            // Buoc 3: thuc thi cau len SQL
            String query = "SELECT " +
                    "    firstName, " +
                    "    lastName " +
                    "FROM " +
                    "employees " +
                    "WHERE " +
                    "lastName LIKE '%" + key +"'"+
                    " ORDER BY firstName;";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                String lastName = resultSet.getString("contactLastname");
                String firstName = resultSet.getString("contactFirstname");
            }
            // Buoc 5: ngat ket noi
            JDBCConnect.close(connection);

        }catch(SQLException e){
            System.out.println(e);
        }
        return listEmployee;
    }



    public List<Employee> searchEmployeeLeftJoinOffices(){
        List<Employee> listEmployee = new ArrayList<>();

        try{
            // Buoc 1: tao connection
            Connection connection = JDBCConnect.connect();

            // Buoc 2: tao doi tuong Statement
            Statement statement = connection.createStatement();

            // Buoc 3: thuc thi cau len SQL
            String query = "select e.*, o.* from employees e left join offices o on e.officeCode = o.officeCode";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                int employeeNumber = resultSet.getInt("employeeNumber");
                String lastName = resultSet.getString("lastName");
                String firstName = resultSet.getString("firstName");
                String extension = resultSet.getString("extension");
                String email = resultSet.getString("email");
                String officeCode = resultSet.getString("officeCode");
                int reportsTo = resultSet.getInt("reportsTo");
                String jobTitle = resultSet.getString("jobTitle");

                Employee employee = new Employee( employeeNumber,  lastName,  firstName,  extension,  email, officeCode, reportsTo, jobTitle);
                listEmployee.add(employee);
            }
            // Buoc 5: ngat ket noi
            JDBCConnect.close(connection);

        }catch(SQLException e){
            System.out.println(e);
        }
        return listEmployee;
    }

    public List<Employee> searchEmployeeRightJoinOffices(){
        List<Employee> listEmployee = new ArrayList<>();

        try{
            // Buoc 1: tao connection
            Connection connection = JDBCConnect.connect();

            // Buoc 2: tao doi tuong Statement
            Statement statement = connection.createStatement();

            // Buoc 3: thuc thi cau len SQL
            String query = "select e.*, o.* from employees e " +
                    "join offices o " +
                    "on e.officeCode = o.officeCode;";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                int employeeNumber = resultSet.getInt("employeeNumber");
                String lastName = resultSet.getString("lastName");
                String firstName = resultSet.getString("firstName");
                String extension = resultSet.getString("extension");
                String email = resultSet.getString("email");
                String officeCode = resultSet.getString("officeCode");
                int reportsTo = resultSet.getInt("reportsTo");
                String jobTitle = resultSet.getString("jobTitle");

                Employee employee = new Employee( employeeNumber,  lastName,  firstName,  extension,  email, officeCode, reportsTo, jobTitle);
                listEmployee.add(employee);
            }
            // Buoc 5: ngat ket noi
            JDBCConnect.close(connection);

        }catch(SQLException e){
            System.out.println(e);
        }
        return listEmployee;
    }

    public List<Employee> searchEmployeeInnerJoinOffices(){
        List<Employee> listEmployee = new ArrayList<>();

        try{
            // Buoc 1: tao connection
            Connection connection = JDBCConnect.connect();

            // Buoc 2: tao doi tuong Statement
            Statement statement = connection.createStatement();

            // Buoc 3: thuc thi cau len SQL
            String query = "select e.*, o.* from employees e " +
                    "inner join offices o " +
                    "on e.officeCode = o.officeCode;";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                int employeeNumber = resultSet.getInt("employeeNumber");
                String lastName = resultSet.getString("lastName");
                String firstName = resultSet.getString("firstName");
                String extension = resultSet.getString("extension");
                String email = resultSet.getString("email");
                String officeCode = resultSet.getString("officeCode");
                int reportsTo = resultSet.getInt("reportsTo");
                String jobTitle = resultSet.getString("jobTitle");

                Employee employee = new Employee( employeeNumber,  lastName,  firstName,  extension,  email, officeCode, reportsTo, jobTitle);
                listEmployee.add(employee);
            }
            // Buoc 5: ngat ket noi
            JDBCConnect.close(connection);

        }catch(SQLException e){
            System.out.println(e);
        }
        return listEmployee;
    }


}
