import java.util.ArrayList;
import java.util.List;

public class Sale {
    private List<Book> bookItems = new ArrayList<>();
    private int quantity;
    private float total;

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<Book> getBookItems() {
        return bookItems;
    }

    public void setBookItems(List<Book> bookItems) {
        this.bookItems = bookItems;
    }

    public float calculateTotal(){
        float subtotal = 0;

        for (Book book : bookItems) {
            subtotal = book.getPrice() * quantity;
            this.total += subtotal;
        }
        return total;
    }

}
