package ui;

import domain.Book;
import domain.Stock;
import services.BookService;
import services.StockService;

import java.util.Scanner;

public class StockUI {

    StockService stockService = StockService.getInstance();
    Scanner readScreen = new Scanner(System.in);


    public void increaseBookStock() {
        Book book = null;
        Stock stock = null;
        String isbn = "";
        int quantity = 0;

        System.out.println("Kitabın ISBN Numrasını Giriniz:");
        isbn = readScreen.nextLine();

        book = BookService.getInstance().getBook(isbn);

        if (book == null) {
            System.out.println("Girmek istediğiniz `" + isbn + "` numarasına ait bir kitap bulunamamıştır.");
            System.out.println("Lütfen önce kitap ekleyiniz.");
        } else {
            System.out.println("Kaç adet stok girilecek:");
            quantity = Integer.parseInt(readScreen.nextLine());
            stockService.increaseStock(isbn, quantity);

            stock = stockService.getStock(book.getIsbn());

            if (stock != null) {
                System.out.println("Stoktaki Adedi: " + stock.getQauntity());
                System.out.println("Mağazadaki Yeri: " + stock.getShelfNumber() + "\n");
            } else {
                System.out.println("Kitanın stok bilgileri bulunamadı. Tekrar Deneyiniz.");
            }
        }
    }

}
