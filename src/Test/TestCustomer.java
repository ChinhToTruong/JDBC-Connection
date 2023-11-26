package Test;


import DAO.CustomerDAO;
import Models.Customer;
import java.sql.Date;

public class TestCustomer {
    public static void main(String[] args) {
        //tao bang
//        CustomerDAO.getInstance().createTable();

        // insert 100 ban ghi
//        for (int i = 0; i < 100; i++){
//            Customer customer = new Customer("Customer" + i, "customer " + i + "address", new Date(new java.util.Date().getTime()));
//            CustomerDAO.getInstance().add(customer);
//        }

        // them 1 book
//        CustomerDAO.getInstance().add(new Customer("Customer" , "customer " + "address", new Date(new java.util.Date().getTime())));

        // xoa 1 book
//       CustomerDAO.getInstance().delete(new Customer("Customer" , "customer " + "address", new Date(new java.util.Date().getTime())));

        // select  all
        CustomerDAO.getInstance().selectAll();
    }
}
