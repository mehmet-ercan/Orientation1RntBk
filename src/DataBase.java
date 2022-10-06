import java.util.ArrayList;
import java.util.List;

public class DataBase {
    private List<Book> books = new ArrayList<>();
    private List<Stock> stock = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();

    public List<Book> getBooks() {
        return books;
    }

    public List<Stock> getStock() {
        return stock;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

}
