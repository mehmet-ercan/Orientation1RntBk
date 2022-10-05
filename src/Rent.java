import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Rent {

    private List<Book> bookItems = new ArrayList<>();
    private int quantity;
    private float total;
    private int refundDate; // Date olacak, geri getirme tarihi olarak nasıl bilgi verildiyse ona göre geri ödeme yapılcak
    public float refundPercent = 0.75f;


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public int getRefundDate() {
        return refundDate;
    }

    public void setRefundDate(int refundDate) {
        this.refundDate = refundDate;
    }

    public float getRefundPercent() {
        return refundPercent;
    }

    public void setRefundPercent(float refundPercent) {
        this.refundPercent = refundPercent;
    }

    public List<Book> getBookItems() {
        return bookItems;
    }

    public void setBookItems(List<Book> bookItems) {
        this.bookItems = bookItems;
    }

    public float calculateTotal() {
        float subtotal = 0;

        for (Book book : bookItems) {
            subtotal = book.getPrice() * quantity;
            this.total += subtotal;
        }
        return total;
    }

    /* Refund Sınıfında Yapılacak İşlemler */
    /*public void calculatePercent() {
        if (refundDate <= 14) {
            refundPercent = 0.75f;
        } else if (refundDate <= 24) {
            refundPercent = 0.75f - ((refundPercent - 14) * 0.5f);
        } else {
            refundPercent = 0.25f;
        }
    }*/

}
