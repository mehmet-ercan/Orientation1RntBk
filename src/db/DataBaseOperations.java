package db;
import domain.Book;
import domain.Stock;

import java.util.Scanner;

public class DataBaseOperations {

    private DataBase dataBase;
    public DataBaseOperations(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public boolean addBook() {
        try {
            Book newBook = new Book();
            Stock newStock = new Stock();
            Scanner readScreen = new Scanner(System.in);

            System.out.println("Kitabın ISBN Numrasını Giriniz:");
            newBook.setIsbn(readScreen.nextLine());
            newStock.setIsbn(newBook.getIsbn());

            System.out.println("Kitabın İsmini Giriniz:");
            newBook.setName(readScreen.nextLine());

            System.out.println("Kitabın Yazarını Giriniz:");
            newBook.setAuthor(readScreen.nextLine());

            System.out.println("Kitabın Yayın Yılını Giriniz:");
            newBook.setPublishYear(readScreen.nextLine());

            System.out.println("Kitabın Sayfa Sayısını Giriniz:");
            newBook.setPages(readScreen.nextInt());

            System.out.println("Kitabın Ücretini Giriniz:");
            newBook.setPrice(readScreen.nextFloat());

            System.out.println("Kitabın Stok Adedini Giriniz:");
            newStock.setQauntity(readScreen.nextInt());

            System.out.println("Kitabın Raf Numarasını Giriniz:");
            newStock.setShelfNumber(readScreen.nextLine());

            dataBase.getBooks().add(newBook);
            dataBase.getStock().add(newStock);

            return true;
        } catch (Exception exception) {
            System.out.println("Hata kodu:" + exception.getMessage() + "\n");
            return false;
        }


    }

}
