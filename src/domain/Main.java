package domain;

import db.BookServices;
import db.DataBase;
import enums.Choicess;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        DataBase dataBase = new DataBase();
        BookServices bookServices = new BookServices();

        Store rentABookStore = new Store();
        Cashier cashier = new Cashier("Mehmet E.", "Akcan", "551 010 6464",
                "237V+6F Ümraniye, İstanbul");
        rentABookStore.workCashier(cashier);


        bookServices.setDataBase(dataBase);
        menu(bookServices);
    }

    public static void menu(BookServices bookServices) {
        Scanner readScreen = new Scanner(System.in);
        Choicess choice = Choicess.START;
        System.out.println(" # RentaBook - KİTAP KİRALAMA UYGULAMASI # ");

        while (choice != Choicess.valueOf("EXIT")) {

            //clearScreen();
            System.out.println("\n");
            System.out.println("1.) Kitap Ekle ");
            System.out.println("2.) Müşteri Ekle ");
            System.out.println("3.) Kitap Satışı ");
            System.out.println("4.) Kitap Kirala ");
            System.out.println("5.) Satış İşlemi İptali ");
            System.out.println("6.) Kitap Geri Al ");
            System.out.println("0.) Çıkış\n");
            System.out.print(" Seçiminiz --> ");

            choice = Choicess.values()[readScreen.nextInt()];
            if (choice == Choicess.ADD_BOOK) {
                if (bookServices.addBook()) {
                    System.out.println("Kitap mağazaya ekleniyor:");
                    delayWithComma(3);
                    System.out.println("Kitap mağazaya eklenmiştir.");
                    delay(1);

                } else {
                    System.out.println("Kitap eklenirken bir hata meydana geldi. Tekrar Deneyiniz...");
                    delay(3);
                }
            }
        }

        System.out.println("İyi Günler Dileriz. ");
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

    public static void clearScreen() {
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ALT);
            robot.keyPress(KeyEvent.VK_NUM_LOCK);
            robot.keyRelease(KeyEvent.VK_ALT);
            robot.keyRelease(KeyEvent.VK_NUM_LOCK);
            Thread.sleep(10);

        } catch (AWTException ex) {
            ex.printStackTrace(System.err);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
