package domain;

public class Receipt {
    private String receiptNumber;

    public void printSaleReceipt(Sale sale) {
        System.out.println("Satın alınan kitaplar ->");
        int i = 1;
        for (Book book : sale.getSaleListMap().keySet()) {
            System.out.println(i++ + ". " + book.getName() + " " + book.getBookSpecification().getPrice() + " TL");
        }
        System.out.println("Satın alımış kitapların toplam ücreti: " + sale.getTotal());
    }

    public void printRentReceipt(Rent rent) {
        System.out.println("Kiralık alınan kitaplar");
        int i = 1;
        for (Book book : rent.getBookItems()) {
            System.out.println(i++ + book.getName() + " " + book.getBookSpecification().getPrice() + "TL");
        }
        System.out.println("Kiralık alımış kitapların toplam ücreti: " + rent.getTotal());
        System.out.println("Kiralama bitiş tarihi: " + rent.getRefundDate());

    }

}
