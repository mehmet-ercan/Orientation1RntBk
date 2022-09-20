import java.time.DateTimeException;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        System.out.println("### Bu bir stok takibi uygulamasıdır ### \n");

        System.out.println("Girilen Ürün Bilgileri Yazılıyor ... \n");
        Legumes wheat = new Legumes("Buğday", 5, new Date("25/10/2023"), "kg", "Siyez");
        ProductManager pm = new ProductManager(wheat);
        pm.Yazdir();

        wheat.productReduce(0.3f);
        System.out.println("\nÜrün kullanıldıktan sonra yeni stok. ");
        pm.Yazdir();

        wheat.Eat(0.35f);

    }
}