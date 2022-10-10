package db;

import domain.Book;
import domain.Customer;
import domain.Sale;
import domain.Stock;

import java.util.ArrayList;
import java.util.List;

public class DataBase {
    private List<Book> books = new ArrayList<>();
    private List<Stock> stocks = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();

    private List<Sale> sales = new ArrayList<>();

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

    public void initiliazeData() {
        Book book1 = new Book("123-45", "Nerede Onlar?", "Mehmet Ercan", "2020", 128, 49.99f);
        Stock stock1 = new Stock("123-45", 10, "A45-52");

        Book book2 = new Book("678-90", "Nerede Bunlar?", "Mehmet Ercan", "2021", 256, 79.99f);
        Stock stock2 = new Stock("678-90", 10, "A45-52");

        Book book3 = new Book("543-12", "Nerede Şunlar?", "Mehmet Ercan", "2022", 512, 99.99f);
        Stock stock3 = new Stock("543-12", 10, "A45-52");

        getBooksList().add(book1);
        getStocksList().add(stock1);
        getBooksList().add(book2);
        getStocksList().add(stock2);
        getBooksList().add(book3);
        getStocksList().add(stock3);
    }


}
