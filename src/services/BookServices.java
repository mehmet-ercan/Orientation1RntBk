package services;

import db.DataBase;
import domain.Book;

public  class BookServices {

    public BookServices(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    private DataBase dataBase;

    public DataBase getDataBase() {
        return dataBase;
    }

    public Book getBook(String isbn) {

        Book singleBook = null;
        singleBook = getDataBase().getBooksList().stream().filter(b -> b.getIsbn().equals(isbn)).findFirst().orElse(null);
        return singleBook;
    }

    public boolean addBook(Book newBook) {
        try {
            dataBase.getBooksList().add(newBook);
            return true;
        } catch (Exception exception) {
            System.out.println("Hata kodu:" + exception.getMessage() + "\n");
            return false;
        }
    }

}
