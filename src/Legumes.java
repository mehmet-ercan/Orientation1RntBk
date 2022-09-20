import java.util.*;

public class Legumes extends Products {

    public float proteinRatioOf100Gr;
    private boolean containsGluten;


    public Legumes(String productName, float productQuantity, Date productED, String productQuantityUnit, String productType) {
        super(productName, productQuantity, productED, productQuantityUnit, productType);

    }

}
