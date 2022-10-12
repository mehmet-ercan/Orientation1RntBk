package db;

import domain.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DataBase {

    public DataBase() {
        initiliazeData();
    }

    private List<Book> books = new ArrayList<>();
    private List<Stock> stocks = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();
    private List<Sale> sales = new ArrayList<>();
    private List<BookSpecification> bookSpecifications = new ArrayList<>();

    public List<Book> getBooksList() {
        return books;
    }

    public List<Stock> getStocksList() {
        return stocks;
    }

    public List<Customer> getCustomersList() {
        return customers;
    }

    public List<Sale> getSalesList() {
        return sales;
    }

    public List<BookSpecification> getBookSpecifications() {
        return bookSpecifications;
    }

    public void initiliazeData() {
        Book book1 = new Book("123-45", "Nerede Onlar?", "Mehmet Ercan", "2020", 128);
        book1.setBookSpecification(new BookSpecification("123-45", 11.1f, LocalDate.now(), LocalDate.parse("9999-12-31")));
        Stock stock1 = new Stock("123-45", 10, "A45-52");

        Book book2 = new Book("678-90", "Nerede Bunlar?", "Mehmet Ercan", "2021", 256);
        book2.setBookSpecification(new BookSpecification("678-90", 12.2f, LocalDate.now(), LocalDate.parse("9999-12-31")));
        Stock stock2 = new Stock("678-90", 10, "A45-52");

        Book book3 = new Book("543-12", "Nerede Şunlar?", "Mehmet Ercan", "2022", 512);
        book3.setBookSpecification(new BookSpecification("543-12", 13.3f, LocalDate.now(), LocalDate.parse("9999-12-31")));
        Stock stock3 = new Stock("543-12", 10, "A45-52");

        Customer customer = new Customer(1, "Ercan", "Akcan", "551");
        getCustomersList().add(customer);

        getBooksList().add(book1);
        getStocksList().add(stock1);
        getBookSpecifications().add(book1.getBookSpecification());

        getBooksList().add(book2);
        getStocksList().add(stock2);
        getBookSpecifications().add(book2.getBookSpecification());

        getBooksList().add(book3);
        getStocksList().add(stock3);
        getBookSpecifications().add(book3.getBookSpecification());
    }

}