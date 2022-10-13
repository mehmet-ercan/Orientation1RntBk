package service;

import db.DataBase;
import domain.Book;
import domain.Sale;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class SaleService {
    private static SaleService saleService;

    private DataBase dataBase;

    private SaleService() {
    }

    public static SaleService getInstance() {
        if (saleService == null) {
            saleService = new SaleService();
        }
        return saleService;
    }

    public void setDataBase(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public void addSale(Sale sale) {
        dataBase.getSalesList().add(sale);
    }

    public float calculateTotal(Sale sale) {

        Map<Book, Integer> map = sale.getBookAndQuantityMap();

        float subtotal = 0;

        for (Map.Entry<Book, Integer> entry : map.entrySet()) {
            subtotal += entry.getKey().getBookSpecification().getPrice() * entry.getValue();
        }

        return subtotal;
    }

    public String generateSaleNumber(int customerId) { // S051022145509 => domain.Sale 05.10.2022 14:55.09
        String receiptNumber = "S" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("ddMMyyHHmmss")) + customerId;
        return receiptNumber;
    }

    public Sale getSale(String saleNumber) {
        return dataBase.getSalesList().stream().filter(s -> s.getOperationNumber().equals(saleNumber)).findFirst().orElse(null);
    }

    public void removeSale(Sale sale) {
        dataBase.getSalesList().remove(sale);
    }

}
