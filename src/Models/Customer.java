package Models;

public class Customer {
    private int customerNumber;
    private String customerName;
    private String contactLastName;
    private String getContactFirstName;
    private String phone;
    private String addressLine1;
    private String getAddressLine2;
    private String city;
    private String state;

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getContactLastName() {
        return contactLastName;
    }

    public void setContactLastName(String contactLastName) {
        this.contactLastName = contactLastName;
    }

    public String getGetContactFirstName() {
        return getContactFirstName;
    }

    public void setGetContactFirstName(String getContactFirstName) {
        this.getContactFirstName = getContactFirstName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getGetAddressLine2() {
        return getAddressLine2;
    }

    public void setGetAddressLine2(String getAddressLine2) {
        this.getAddressLine2 = getAddressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getSalesRepEmployeeNumber() {
        return salesRepEmployeeNumber;
    }

    public void setSalesRepEmployeeNumber(int salesRepEmployeeNumber) {
        this.salesRepEmployeeNumber = salesRepEmployeeNumber;
    }

    public Double getCreditlimit() {
        return creditlimit;
    }

    public void setCreditlimit(Double creditlimit) {
        this.creditlimit = creditlimit;
    }

    private String postalCode;
    private String country;
    private int salesRepEmployeeNumber;
    private Double creditlimit;

    public Customer() {
    }

    public Customer(int customerNumber, String customerName, String contactLastName, String getContactFirstName, String phone, String addressLine1, String getAddressLine2, String city, String state, String postalCode, String country, int salesRepEmployeeNumber, Double creditlimit) {
        this.customerNumber = customerNumber;
        this.customerName = customerName;
        this.contactLastName = contactLastName;
        this.getContactFirstName = getContactFirstName;
        this.phone = phone;
        this.addressLine1 = addressLine1;
        this.getAddressLine2 = getAddressLine2;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
        this.salesRepEmployeeNumber = salesRepEmployeeNumber;
        this.creditlimit = creditlimit;
    }
}
