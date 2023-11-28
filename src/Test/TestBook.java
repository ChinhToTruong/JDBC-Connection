package Test;

import Service.BookService;
import Models.Book;

public class TestBook {
    public static void main(String[] args) {
        // tao bang
        BookService.getInstance().createTable();

        // insert 100 ban ghi
        for (int i = 0; i < 100; i++){
            Book book = new Book("Book"+i, i, i + 1900);
            BookService.getInstance().add(book);
        }

        // them 1 book
        BookService.getInstance().add(new Book("Tuoi tre dang gia bao nhieu", 10, 2016));

        // xoa 1 book
        BookService.getInstance().delete(new Book("Tuoi tre dang gia bao nhieu", 10, 2016));

        // select  all
        BookService.getInstance().selectAll();
    }
}
