import java.util.Date;

public class Canneds extends Products {

    private String cannedMaterial;

    public Canneds(String productName, float productQuantity, Date productED, String productQuantityUnit, String productType) {
        super(productName, productQuantity, productED, productQuantityUnit, productType);
    }
}
