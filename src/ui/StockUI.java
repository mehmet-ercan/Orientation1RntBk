package ui;

import domain.Book;
import domain.Stock;
import services.BookServices;
import services.StockServices;

import java.util.Scanner;

public class StockUI {

    BookServices bookServices;
    StockServices stockServices;
    Scanner readScreen = new Scanner(System.in);

    public StockUI(BookServices bookServices, StockServices stockServices) {
        this.bookServices = bookServices;
        this.stockServices = stockServices;
    }

    public void increaseBookStock() {
        Book book = null;
        Stock stock = null;
        String isbn = "";
        int quantity = 0;

        System.out.println("Kitabın ISBN Numrasını Giriniz:");
        isbn = readScreen.nextLine();

        book = bookServices.getBook(isbn);

        if (book == null) {
            System.out.println("Girmek istediğiniz `" + isbn + "` numarasına ait bir kitap bulunamamıştır.");
            System.out.println("Lütfen önce kitap ekleyiniz.");
        } else {
            System.out.println("Kaç adet stok girilecek:");
            quantity = readScreen.nextInt();
            stockServices.increaseStock(isbn, quantity);

            stock = stockServices.getStock(book.getIsbn());

            if (stock != null) {
                System.out.println("Stoktaki Adedi: " + stock.getQauntity());
                System.out.println("Mağazadaki Yeri: " + stock.getShelfNumber() + "\n");
            } else {
                System.out.println("Kitanın stok bilgileri bulunamadı. Tekrar Deneyiniz.");
            }
        }
    }

}
