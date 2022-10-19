package domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Sale {
    Map<Book, Integer> bookAndQuantityMap = new HashMap<Book, Integer>();
    LocalDateTime operationDateTime;
    int customerId;
    String operationNumber;
    float total;

    public Map<Book, Integer> getBookAndQuantityMap() {
        return bookAndQuantityMap;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getOperationNumber() {
        return operationNumber;
    }

    public void setOperationNumber(String operationNumber) {
        this.operationNumber = operationNumber;
    }

    public LocalDateTime getOperationDateTime() {
        return operationDateTime;
    }

    public void setOperationDateTime(LocalDateTime operationDateTime) {
        this.operationDateTime = operationDateTime;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String generateOperationNumber(int customerId) { // S18102214550901 => Sale 18.10.2022 14:55.09 01 idli Müşteri
        String receiptNumber = "S" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("ddMMyyHHmmss")) + customerId;
        return receiptNumber;
    }
}
