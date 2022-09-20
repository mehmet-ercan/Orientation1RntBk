import java.util.*;

public abstract class  Products {

    // Variables
    private String productName; // Ürün Adı
    private float productQuantity; //Ürün Miktarı
    private Date productED; // Expiriation Date - SKT
    private String productQuantityUnit; // Ürün Miktarının Birimi
    private String productType; // Ürün Türü, Tipi veya Çeşidi

    //Getter Setter Methods
    public String getProductName() {
        return productName;
    }

    public float getProductQuantity() {
        return productQuantity;
    }

    public Date getProductED() {
        return productED;
    }

    public String getProductQuantityUnit() {
        return productQuantityUnit;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductQuantity(float productQuantity) {
        this.productQuantity = productQuantity;
    }

    public void setProductED(Date productED) {
        this.productED = productED;
    }

    public void setProductQuantityUnit(String productQuantityUnit) {
        this.productQuantityUnit = productQuantityUnit;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public Products(String productName, float productQuantity, Date productED, String productQuantityUnit, String productType) {
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.productED = productED;
        this.productQuantityUnit = productQuantityUnit;
        this.productType = productType;
    }

    public void productReduce(float reduceProductQuantity)
    {
        this.productQuantity -=reduceProductQuantity;
    }

    public void productIncrease(float increaseProductQuantity)
    {
        this.productQuantity +=increaseProductQuantity;
    }

}
