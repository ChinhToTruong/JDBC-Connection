package Service;

import Models.Book;
import Utils.JDBCConnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookService implements ServiceInterface<Book> {
    public static BookService getInstance(){
        return new BookService();
    }

    @Override
    public void createTable(){

        try{
            // Buoc 1: tao connection
            Connection connection = JDBCConnect.connect();

            // Buoc 2: tao doi tuong Statement
            Statement statement = connection.createStatement();

            // Buoc 3: thuc thi cau len SQL
            String query = "Create Table Book("+
                            "id INT AUTO_INCREMENT PRIMARY KEY," +
                            "name VARCHAR(255)," +
                            "price FLOAT," +
                            "publishedYear INT)";
            System.out.println("Tao thanh cong Book table");
            statement.execute(query);
            // Buoc 5: ngat ket noi
            JDBCConnect.close(connection);

        }catch(SQLException e){
            System.out.println(e);
        }

    }

    @Override
    public void add(Book book) {
        try{
            // Buoc 1: tao connection
            Connection connection = JDBCConnect.connect();

            // Buoc 2: tao doi tuong Statement
            Statement statement = connection.createStatement();

            // Buoc 3: thuc thi cau len SQL
            String query = "INSERT INTO Book (name, price, publishedYear)"+
                    "Values(" + "'"+ book.getName() + "'" + "," + book.getPrice() + "," + book.getPublishedYear() + ")";
            statement.execute(query);

            System.out.println("Them thanh cong");
            // Buoc 5: ngat ket noi
            JDBCConnect.close(connection);

        }catch(SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public void delete(Book book) {
        try{
            // Buoc 1: tao connection
            Connection connection = JDBCConnect.connect();

            // Buoc 2: tao doi tuong Statement
            Statement statement = connection.createStatement();

            // Buoc 3: thuc thi cau len SQL
            String query = "Delete From Book Where name ="+ "'" +book.getName() + "'";
            statement.execute(query);

            System.out.println("Xoa thanh cong Book table");
            // Buoc 5: ngat ket noi
            JDBCConnect.close(connection);

        }catch(SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public void update(Book book) {
        try{
            // Buoc 1: tao connection
            Connection connection = JDBCConnect.connect();

            // Buoc 2: tao doi tuong Statement
            Statement statement = connection.createStatement();

            // Buoc 3: thuc thi cau len SQL
            String query = "Update Book" +
                            "Set price = " + book.getPrice() * 2 +
                            "Where name =" + "'" + book.getName() +"'";
            statement.execute(query);

            System.out.println("Update thanh cong Book table");
            // Buoc 5: ngat ket noi
            JDBCConnect.close(connection);

        }catch(SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public List<Book> selectAll() {
        List<Book> listBook = new ArrayList<>();
        try{
            // Buoc 1: tao connection
            Connection connection = JDBCConnect.connect();

            // Buoc 2: tao doi tuong Statement
            Statement statement = connection.createStatement();

            // Buoc 3: thuc thi cau len SQL
            String query = "Select * From Book";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                Integer publishedYear = resultSet.getInt("publishedYear");

                // Xử lý các giá trị như mong muốn
                Book book = new Book(id, name, price, publishedYear);
                listBook.add(book);
            }

            System.out.println("Select all thanh cong Book table");
            // Buoc 5: ngat ket noi
            JDBCConnect.close(connection);

        }catch(SQLException e) {
            System.out.println(e);
        }
        return listBook;
    }

    @Override
    public Book selectById(int id) {
        return null;
    }

    @Override
    public List<Book> selectByCondition(String condition) {
        return null;
    }
}
