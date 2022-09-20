import java.util.Date;

public class Packageds extends Products{

    private String packagedType; // metal, plastic, cardboard, fabric vs
    private boolean packageReCycled;
    private boolean tseBandroled;

    public Packageds(String productName, float productQuantity, Date productED, String productQuantityUnit, String productType) {
        super(productName, productQuantity, productED, productQuantityUnit, productType);
    }
}
