package ui;

import domain.Book;
import domain.Stock;
import services.BookServices;
import services.StockServices;

import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;

public class BookUI {
    Scanner readScreen = new Scanner(System.in);


    public void addBook() {
        try {

            Book newBook = new Book();

            System.out.println("Kitabın ISBN Numrasını Giriniz:");
            newBook.setIsbn(readScreen.nextLine());

            System.out.println("Kitabın İsmini Giriniz:");
            newBook.setName(readScreen.nextLine());

            System.out.println("Kitabın Yazarını Giriniz:");
            newBook.setAuthor(readScreen.nextLine());

            System.out.println("Kitabın Yayın Yılını Giriniz:");
            newBook.setPublishYear(readScreen.nextLine());

            System.out.println("Kitabın Sayfa Sayısını Giriniz:");
            newBook.setPages(readScreen.nextInt());

            System.out.println("Kitabın Ücretini Giriniz:");
            newBook.getBookSpecification().setPrice(readScreen.nextFloat());

            newBook.getBookSpecification().setIsbn(newBook.getIsbn());
            newBook.getBookSpecification().setStartDate(LocalDate.now());
            newBook.getBookSpecification().setEndDate(LocalDate.of(9999, Month.DECEMBER, 31));

            if (BookServices.getInstance().addBook(newBook)) {
                if (StockServices.getInstance().addStock(newBook.getIsbn())) {
                    System.out.println("Kitap stok bilgisiyle beraber mağazaya ekleniyor: ");
                    UI.delayWithComma(3);
                    System.out.println("Kitap mağazaya eklenmiştir.");
                    UI.delay(1);
                } else {
                    throw new Exception("Stok bilgisi eklenemedi.");
                }
            } else {
                throw new Exception("Kitap bilgisi eklenemedi.");
            }


        } catch (Exception exception) {
            System.out.println("Hata kodu:" + exception.getMessage() + "\n");
            System.out.println("Kitap eklenirken bir hata meydana geldi. Tekrar Deneyiniz...");
            UI.delay(3);
        }
    }

    public void showBooksInStock() {
        int bookNumber = 1;

        for (Book book : BookServices.getInstance().getDataBase().getBooksList()) {
            System.out.print(bookNumber + ". ");
            printBookInformation(book);
            bookNumber++;
        }
    }

    public void printBookInformation(Book book) {
        Stock stock = StockServices.getInstance().getStock(book.getIsbn());

        System.out.println("ISBN Numarası: " + book.getIsbn());
        System.out.println("Adı: " + book.getName());
        System.out.println("Yazarı: " + book.getAuthor());
        System.out.println("Sayfa Sayısı: " + book.getPages());
        System.out.println("Yayın Yılı: " + book.getPublishYear());
        System.out.println("Fiyatı: " + book.getBookSpecification().getPrice());

        if (stock != null) {
            System.out.println("Stoktaki Adedi: " + stock.getQauntity());
            System.out.println("Mağazadaki Yeri: " + stock.getShelfNumber() + "\n");
        } else {
            System.out.println("Kitanın stok bilgileri bulunamadı. Tekrar Deneyiniz.");
        }
    }

}
