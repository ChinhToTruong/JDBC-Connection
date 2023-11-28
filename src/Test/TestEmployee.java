package Test;

import Service.EmployeeDAO;

public class TestEmployee {
    public static void main(String[] args) {
        EmployeeDAO.getInstance().searchEmployeeLeftJoinOffices();
        EmployeeDAO.getInstance().searchEmployeeByKey("a");
        EmployeeDAO.getInstance().searchEmployeeRightJoinOffices();
        EmployeeDAO.getInstance().searchEmployeeInnerJoinOffices();
    }
}
