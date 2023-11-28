package Services.and;

public class AndData {
    private String customername;
    private String country;
    private String state;

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCustomername() {
        return customername;
    }

    public String getCountry() {
        return country;
    }

    public String getState() {
        return state;
    }

    public AndData(String customername, String country, String state) {
        this.customername = customername;
        this.country = country;
        this.state = state;
    }
}
