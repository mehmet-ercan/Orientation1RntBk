package ui;

import enums.Choicess;

import java.util.Scanner;

public class UI {

    BookUI bookUI;
    CustomerUI customerUI;
    StockUI stockUI;
    SaleUI saleUI;
    RentUI rentUI;
    Scanner readScreen = new Scanner(System.in);

    public UI() {
        this.rentUI = new RentUI();
        this.bookUI = new BookUI();
        this.customerUI = new CustomerUI();
        this.stockUI = new StockUI();
        this.saleUI = new SaleUI();
    }

    public BookUI getBookUI() {
        return bookUI;
    }

    public CustomerUI getCustomerUI() {
        return customerUI;
    }

    public StockUI getStockUI() {
        return stockUI;
    }

    public SaleUI getSaleUI() {
        return saleUI;
    }

    public RentUI getRentUI() {
        return rentUI;
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

        return Choicess.values()[Integer.parseInt(readScreen.nextLine())];
    }

    public static void delay(int seconds) {
        try {
            seconds *= 1250;
            Thread.sleep(seconds);
        } catch (InterruptedException interruptedException) {
            Thread.currentThread().interrupt();
        }
    }


}
