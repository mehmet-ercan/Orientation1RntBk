import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Receipt {
    private String receiptNumber;
    private LocalDateTime operationDate;
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyMMddHHmmss");


    public String getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptNumber(String receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    public LocalDateTime getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(LocalDateTime operationDate) {
        this.operationDate = operationDate;
    }

    public void generateReceiptNumber(String type) { // S051022145509 => Sale 05.10.2022 14:55.09
        operationDate = LocalDateTime.now();
        receiptNumber = type + dateTimeFormatter.format(operationDate);
    }

    public void printSaleReceipt(Sale sale) {
        System.out.println("Satın alınan kitaplar");
        int i = 1;
        for (Book book : sale.getBookItems()) {
            System.out.println(i++ + book.name + " " + book.price + "TL");
        }
        System.out.println("Satın alımış kitapların toplam ücreti: " + sale.getTotal());
    }

    public void printRentReceipt(Rent rent) {
        System.out.println("Kiralık alınan kitaplar");
        int i = 1;
        for (Book book : rent.getBookItems()) {
            System.out.println(i++ + book.name + " " + book.price + "TL");
        }
        System.out.println("Kiralık alımış kitapların toplam ücreti: " + rent.getTotal());
        System.out.println("Kiralama bitiş tarihi: " + rent.getRefundDate());

    }

}
