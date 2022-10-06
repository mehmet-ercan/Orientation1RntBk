package domain;

import db.DataBaseOperations;
import enums.Choicess;

public class Cashier {
    // Getters, Setters, Constructor
    private String name;
    private String Surname;
    private String phoneNumber;
    private String adress;
    private DataBaseOperations dataBaseOperations;

    public Cashier(String name, String surname, String phoneNumber, String adress) {
        this.name = name;
        Surname = surname;
        this.phoneNumber = phoneNumber;
        this.adress = adress;
    }

    public DataBaseOperations getDataBaseOperations() {
        return dataBaseOperations;
    }

    public void setDataBaseOperations(DataBaseOperations dataBaseOperations) {
        this.dataBaseOperations = dataBaseOperations;
    }

    public void work(int choiceIndex) {

        Choicess menuChoice = Choicess.values()[choiceIndex];

        if (menuChoice == Choicess.ADD_BOOK) {
            if (dataBaseOperations.addBook()) {
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

    public void delayWithComma(int commaQuantity) {
        try {
            for (int i = 0; i < commaQuantity; i++) {
                Thread.sleep(1000);
                System.out.println(".");
            }
        } catch (InterruptedException interruptedException) {
            Thread.currentThread().interrupt();
        }
    }

    public void delay(int seconds) {
        try {
            seconds *= 1000;
            Thread.sleep(seconds);
        } catch (InterruptedException interruptedException) {
            Thread.currentThread().interrupt();
        }
    }

}
