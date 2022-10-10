package domain;

import java.util.*;

public class Sale {
    private Map<Book, Integer> bookItemsWithQuantity = new HashMap<Book, Integer>();
    private float total;

    public Map<Book, Integer> getBookItemsWithQuantity() {
        return bookItemsWithQuantity;
    }

    public void setBookItemsWithQuantity(Map<Book, Integer> bookItemsWithPrice) {
        this.bookItemsWithQuantity = bookItemsWithPrice;
    }

    public float getTotal() {
        return total;
    }

    public float calculateTotal(Map<Book, Float> map) {
        float subtotal = 0;

        for (Map.Entry<Book, Float> entry : map.entrySet()) {
            subtotal = entry.getKey().getBookSpecification().getPrice() * entry.getValue();
            this.total += subtotal;
        }

        return total;
    }

}
