package domain;

import java.time.LocalDateTime;
import java.util.*;

public class Sale {
    private Map<Book, Integer> saleListMap = new HashMap<Book, Integer>();
    private LocalDateTime saleDateTime;
    private int customerId;
    private String saleNumber;
    private float total;

    public Map<Book, Integer> getSaleListMap() {
        return saleListMap;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
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

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}
