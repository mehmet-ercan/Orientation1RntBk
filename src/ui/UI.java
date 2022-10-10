package ui;


import enums.Choicess;
import services.BookServices;
import services.StockServices;
import java.util.Scanner;

public class UI {



    BookUI bookUI;
    CustomerUI customerUI;
    StockUI stockUI;
    SaleUI saleUI;
    Scanner readScreen = new Scanner(System.in);

    public BookUI getBookUI() {
        return bookUI;
    }

    public void setBookUI(BookUI bookUI) {
        this.bookUI = bookUI;
    }

    public CustomerUI getCustomerUI() {
        return customerUI;
    }

    public void setCustomerUI(CustomerUI customerUI) {
        this.customerUI = customerUI;
    }

    public StockUI getStockUI() {
        return stockUI;
    }

    public void setStockUI(StockUI stockUI) {
        this.stockUI = stockUI;
    }

    public SaleUI getSaleUI() {
        return saleUI;
    }

    public void setSaleUI(SaleUI saleUI) {
        this.saleUI = saleUI;
    }

    public Choicess writeMenuItems() {
        //clearScreen();
        System.out.println("\n");
        System.out.println("1.) Kitap Ekle ");
        System.out.println("2.) Müşteri Ekle ");
        System.out.println("3.) Kitap Satışı ");
        System.out.println("4.) Kitap Kirala ");
        System.out.println("5.) Satış İşlemi İptali ");
        System.out.println("6.) Kitap Geri Al ");
        System.out.println("7.) Kitap Stoğu Ekle");
        System.out.println("8.) Kitapları Listele");

        System.out.println("0.) Çıkış\n");
        System.out.print(" Seçiminiz --> ");

        return Choicess.values()[readScreen.nextInt()];
    }

    public static void delayWithComma(int commaQuantity) {
        try {
            for (int i = 0; i < commaQuantity; i++) {
                Thread.sleep(1000);
                System.out.println(".");
            }
        } catch (InterruptedException interruptedException) {
            Thread.currentThread().interrupt();
        }
    }

    public static void delay(int seconds) {
        try {
            seconds *= 1000;
            Thread.sleep(seconds);
        } catch (InterruptedException interruptedException) {
            Thread.currentThread().interrupt();
        }
    }


}
