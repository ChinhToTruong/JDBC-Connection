package Services.orderBy;

public class OrderByData {
    private String contactLastname;
    private String contactFirstname;

    public String getContactLastname() {
        return contactLastname;
    }

    public void setContactLastname(String contactLastname) {
        this.contactLastname = contactLastname;
    }

    public String getContactFirstname() {
        return contactFirstname;
    }

    public void setContactFirstname(String contactFirstname) {
        this.contactFirstname = contactFirstname;
    }

    public OrderByData(String contactLastname, String contactFirstname) {
        this.contactLastname = contactLastname;
        this.contactFirstname = contactFirstname;
    }
}
