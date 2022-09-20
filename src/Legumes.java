import java.util.*;

public class Legumes extends Products implements IYenilebilenler {

    public float proteinRatioOf100Gr;
    private boolean containsGluten;

    public Legumes(String productName, float productQuantity, Date productED, String productQuantityUnit, String productType) {
        super(productName, productQuantity, productED, productQuantityUnit, productType);

    }

    @Override
    public void Eat(float eatQuantity) {
        System.out.println("\n" + eatQuantity + getProductQuantityUnit() + " kadar " + getProductName() + " yenildi.");
        setProductQuantity(getProductQuantity() - eatQuantity);
        System.out.println("Yenildikten sonra kalan stok:" + getProductQuantity() + getProductQuantityUnit());
    }
}
