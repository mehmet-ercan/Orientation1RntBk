package services;

import db.DataBase;
import domain.Book;

public class BookServices{
    private static BookServices bookServices;
    private DataBase dataBase;

    private BookServices() {
    }

    public static BookServices getInstance() {
        if (bookServices == null) {
            bookServices = new BookServices();
        }
        return bookServices;
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
