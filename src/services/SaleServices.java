package services;

import db.DataBase;
import domain.Book;
import domain.Sale;

import java.time.LocalDateTime;
import java.util.Map;

public class SaleServices {
    private static SaleServices saleServices;
    private DataBase dataBase;

    private SaleServices() {
    }

    public static SaleServices getInstance() {
        if (saleServices == null) {
            saleServices = new SaleServices();
        }
        return saleServices;
    }

    public void setDataBase(DataBase dataBase) {
        this.dataBase = dataBase;
    }



    public void addSale(Sale sale) {
        dataBase.getSalesList().add(sale);
    }

    public float calculateTotal(Sale sale) {

        Map<Book, Integer> map = sale.getSaleListMap();

        float subtotal = 0;

        for (Map.Entry<Book, Integer> entry : map.entrySet()) {
            subtotal += entry.getKey().getBookSpecification().getPrice() * entry.getValue();
        }

        return subtotal;
    }

    public String generateReceiptNumber(String type) { // S051022145509 => domain.Sale 05.10.2022 14:55.09
        String receiptNumber = "S" + LocalDateTime.now();
        return receiptNumber;
    }

}
