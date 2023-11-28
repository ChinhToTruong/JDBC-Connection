package Models;

public class ProductLine {
    private String productLine;
    private String textDecription;
    private String htmlDecription;
    private String image;

    public String getProductLine() {
        return productLine;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    public String getTextDecription() {
        return textDecription;
    }

    public void setTextDecription(String textDecription) {
        this.textDecription = textDecription;
    }

    public String getHtmlDecription() {
        return htmlDecription;
    }

    public void setHtmlDecription(String htmlDecription) {
        this.htmlDecription = htmlDecription;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ProductLine() {
    }

    public ProductLine(String productLine, String textDecription, String htmlDecription, String image) {
        this.productLine = productLine;
        this.textDecription = textDecription;
        this.htmlDecription = htmlDecription;
        this.image = image;
    }
}
