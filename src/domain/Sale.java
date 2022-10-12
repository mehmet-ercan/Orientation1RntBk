package domain;

import java.time.LocalDateTime;
import java.util.*;

public class Sale {
    private Map<Book, Integer> bookItemsWithQuantity = new HashMap<Book, Integer>();
    private LocalDateTime saleDateTime;
    private String saleNumber;
    private float total;

    public Map<Book, Integer> getBookItemsWithQuantity() {
        return bookItemsWithQuantity;
    }

    public float getTotal() {
        return total;
    }

    public float setTotal(Map<Book, Integer> map) {
        float subtotal = 0;

        for (Map.Entry<Book, Integer> entry : map.entrySet()) {
            subtotal = entry.getKey().getBookSpecification().getPrice() * entry.getValue();
            this.total += subtotal;
        }

        return total;
    }

    public String getSaleNumber() {
        return saleNumber;
    }


    public void setSaleNumber(String saleNumber) {
        this.saleNumber = saleNumber;
    }

    public LocalDateTime getSaleDateTime() {
        return saleDateTime;
    }

    public void setSaleDateTime(LocalDateTime saleDateTime) {
        this.saleDateTime = saleDateTime;
    }
}
