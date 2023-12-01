package Services.storedProcedure;

public class StoredProcedureData {
    public String customerName;
    public String city;
    public String state;
    public String postalCode;
    public String country;

    public StoredProcedureData(String customerName, String city, String state, String postalCode, String country) {
        this.customerName = customerName;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
    }
}
