package services;

import db.DataBase;
import domain.Book;
import domain.Rent;
import domain.Sale;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class RentService {

    private static RentService rentService;
    private DataBase dataBase;
    private float refundPercent = 0.75f;

    private RentService() {
    }

    public static RentService getInstance() {
        if (rentService == null) {
            rentService = new RentService();
        }
        return rentService;
    }

    public void setDataBase(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public void addRent(Rent rent) {
        dataBase.getRents().add(rent);
    }

    public float calculateTotal(Rent rent) {

        Map<Book, Integer> map = rent.getBookAndQuantityMap();

        float subtotal = 0;

        for (Map.Entry<Book, Integer> entry : map.entrySet()) {
            subtotal += entry.getKey().getBookSpecification().getPrice() * entry.getValue();
        }

        return subtotal;
    }

    public String generateRentNumber(int customerId) { // S051022145509 => domain.Sale 05.10.2022 14:55.09
        String receiptNumber = "R" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("ddMMyyyyHHmmss")) + customerId;;
        receiptNumber.replace("-","").replace(".","");
        return receiptNumber;
    }

    public void calculateRefund(Rent rent) {
        rent.setRefund(rent.getTotal() * refundPercent);
    }

}

