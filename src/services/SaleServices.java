package services;

import db.DataBase;
import domain.Sale;

import java.time.LocalDateTime;

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

    public void addSale(Sale sale) {
        dataBase.getSalesList().add(sale);
    }

    public void setDataBase(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public String generateReceiptNumber(String type) { // S051022145509 => domain.Sale 05.10.2022 14:55.09
        String receiptNumber = "S" + LocalDateTime.now();
        return receiptNumber;
    }

}
