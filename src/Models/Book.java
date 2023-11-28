package Models;

public class Book {
    private int id;     
    private String name;
    private int price;
    private Integer publishedYear;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public Integer getPublishedYear() {
        return publishedYear;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setPublishedYear(Integer publishedYear) {
        this.publishedYear = publishedYear;
    }
    public Book(){

    }
    public Book(String name, int price, Integer publishedYear){
        this.name = name;
        this.price = price;
        this.publishedYear = publishedYear;
    }
    public Book(int id, String name, int price, Integer publishedYear){
        this.id = id;
        this.name = name;
        this.price = price;
        this.publishedYear = publishedYear;
    }
}
