package Services.where;

public class WhereData {
    private String lastname;
    private String firstname;
    private String jobtitle;
    private String officeCode;

    public String getOfficeCode() {
        return officeCode;
    }

    public void setOfficeCode(String officeCode) {
        this.officeCode = officeCode;
    }

    public WhereData(String lastname, String firstname, String jobtitle, String officeCode) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.jobtitle = jobtitle;
        this.officeCode = officeCode;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getJobtitle() {
        return jobtitle;
    }

    public void setJobtitle(String jobtitle) {
        this.jobtitle = jobtitle;
    }

    public WhereData(String lastname, String firstname, String jobtitle) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.jobtitle = jobtitle;
    }

}
