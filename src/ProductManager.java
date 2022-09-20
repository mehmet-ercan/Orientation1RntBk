
public class ProductManager {
    private Products products;

    public ProductManager(Products products) {
        this.products = products;
    }

    public void Yazdir(){
        System.out.println("Ürün Adı:" +products.getProductName());
        System.out.println("Ürün Miktarı:" +products.getProductQuantity() + products.getProductQuantityUnit());
        System.out.println("Ürün SKT:" +products.getProductED());
    }

}
