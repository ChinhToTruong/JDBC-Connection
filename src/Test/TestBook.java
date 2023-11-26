package Test;

import DAO.BookDAO;
import Models.Book;

public class TestBook {
    public static void main(String[] args) {
        // tao bang
        BookDAO.getInstance().createTable();

        // insert 100 ban ghi
        for (int i = 0; i < 100; i++){
            Book book = new Book("Book"+i, i, i + 1900);
            BookDAO.getInstance().add(book);
        }

        // them 1 book
        BookDAO.getInstance().add(new Book("Tuoi tre dang gia bao nhieu", 10, 2016));

        // xoa 1 book
        BookDAO.getInstance().delete(new Book("Tuoi tre dang gia bao nhieu", 10, 2016));

        // select  all
        BookDAO.getInstance().selectAll();
    }
}
