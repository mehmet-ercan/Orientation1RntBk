package service;

import db.DataBase;
import domain.Book;
import domain.Sale;

public class BookService {
    private static BookService bookService;
    private  DataBase dataBase;

    private BookService() {
    }

    public static BookService getInstance() {
        if (bookService == null) {
            bookService = new BookService();
        }
        return bookService;
    }

    public void setDataBase(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public DataBase getDataBase() {
        return dataBase;
    }

    public Book getBook(String isbn) {
        Book singleBook = null;
        singleBook = dataBase.getBooksList().stream().filter(b -> b.getIsbn().equals(isbn)).findFirst().orElse(null);
        return singleBook;
    }

    public boolean addBook(Book newBook) {

        try {
            dataBase.getBooksList().add(newBook);
            dataBase.getBookSpecifications().add(newBook.getBookSpecification());
            return true;
        } catch (Exception exception) {
            System.out.println("Hata kodu:" + exception.getMessage() + "\n");
            return false;
        }
    }

    public boolean isValidBook(String isbn) {
        return dataBase.getBooksList().stream().anyMatch(b -> b.getIsbn().equals(isbn));
    }

}
