import java.util.Date;

public class Frozens extends Products{


    private String thawingType; // Çözme Yöntemi - in the refrigerator, in cold water, and in the microwave vs.

    public Frozens(String productName, float productQuantity, Date productED, String productQuantityUnit, String productType) {
        super(productName, productQuantity, productED, productQuantityUnit, productType);
    }
}
