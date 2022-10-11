package domain;

import db.DataBase;
import services.BookServices;
import services.CustomerServices;
import services.SaleServices;
import services.StockServices;
import enums.Choicess;
import ui.*;

public class Main {
    public static void main(String[] args) {
        Store rentABookStore = new Store();
        Cashier cashier = new Cashier("Mehmet E.", "Akcan", "551 010 6464", "237V+6F Ümraniye, İstanbul");
        rentABookStore.workCashier(cashier);

        UI userInterface = initializeUI();

        System.out.println(" # RentaBook - KİTAP KİRALAMA UYGULAMASI # ");
        startProgram(userInterface);
        System.out.println("İyi Günler Dileriz.");
    }

    public static UI initializeUI() {

        DataBase dataBase = new DataBase();
        dataBase.initiliazeData();

        BookServices bookServices = new BookServices(dataBase);
        StockServices stockServices = new StockServices(dataBase);
        CustomerServices customerServices = new CustomerServices(dataBase);
        SaleServices saleServices = new SaleServices(dataBase);

        CustomerUI customerUI = new CustomerUI(customerServices);
        BookUI bookUI = new BookUI(bookServices, stockServices);
        StockUI stockUI = new StockUI(bookServices, stockServices);
        SaleUI saleUI = new SaleUI(saleServices);

        return new UI(bookUI, customerUI, stockUI, saleUI);

    }

    public static void startProgram(UI userInterface) {
        Choicess choice;

        do {
            choice = userInterface.writeMenuItems();

            if (choice == Choicess.ADD_BOOK) {
                userInterface.getBookUI().addBook();
            } else if (choice == Choicess.ADD_CUSTOMER) {
                userInterface.getCustomerUI().addCustomer();
            } else if (choice == Choicess.SELL_BOOK) {
                userInterface.getSaleUI().sellBook();
            } else if (choice == Choicess.ADD_BOOK_STOCK) {
                userInterface.getStockUI().increaseBookStock();
            } else if (choice == Choicess.LIST_BOOK) {
                userInterface.getBookUI().showBooksInStock();
            }
        } while (choice != Choicess.valueOf("EXIT"));
    }


}
