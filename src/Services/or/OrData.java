package Services.or;

public class OrData {
    private String customername;
    private String country;

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public OrData(String customername, String country, double creditLimit) {
        this.customername = customername;
        this.country = country;
        this.creditLimit = creditLimit;
    }

    private double creditLimit;
}
