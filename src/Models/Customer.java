package Models;

import java.util.Date;

public class Customer {
    private int id;
    private String name;
    private String address;
    private Date dayOfBirth;

    public Customer( String name, String address, Date dayOfBirth) {
        this.name = name;
        this.address = address;
        this.dayOfBirth = dayOfBirth;
    }

    public Customer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(Date dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }


}
