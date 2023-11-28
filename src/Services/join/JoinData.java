package Services.join;

public class JoinData {
    private String productCode;
    private String productName;
    private String textDescription;

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTextDescription() {
        return textDescription;
    }

    public void setTextDescription(String textDescription) {
        this.textDescription = textDescription;
    }

    public JoinData(String productCode, String productName, String textDescription) {
        this.productCode = productCode;
        this.productName = productName;
        this.textDescription = textDescription;
    }
}
