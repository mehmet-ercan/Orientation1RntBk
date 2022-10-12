package services;

import db.DataBase;
import domain.Stock;

import java.util.Scanner;

public class StockServices {

    private DataBase dataBase;
    private static StockServices stockServices;

    private StockServices() {
    }

    public static StockServices getInstance() {
        if (stockServices == null) {
            stockServices = new StockServices();
        }
        return stockServices;
    }

    public DataBase getDataBase() {
        return dataBase;
    }

    public void setDataBase(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    //Kitap henüz eklendikten sonra hemen giriyor,
    //Elimizde hiç stock kaydı/nesnesi yok, yeni kayıt/nesne oluşturuyoruz
    //Yeni eklenen kitaba stok ekleme işlemi
    public boolean addStock(String isbn) {

        try {
            Stock newStock = new Stock();
            Scanner readScreen = new Scanner(System.in);

            if (isbn != null) {
                newStock.setIsbn(isbn);

                System.out.println("Kitabın Raf Numarasını Giriniz:");
                newStock.setShelfNumber(readScreen.nextLine());

                System.out.println("Kitabın Stok Adedini Giriniz:");
                newStock.setQauntity(readScreen.nextInt());
                dataBase.getStocksList().add(newStock);

                return true;
            }
            return false;
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    //Kitap zaten ekli, halihazırda var, daha sonra yeni kitaplar geldi,stok artırma işlemi,
    public boolean increaseStock(String isbn, int quantity) {
        Stock stock = getStock(isbn);
        if (stock == null) {
            return false;
        } else {
            stock.setQauntity(stock.getQauntity() + quantity);
        }

        return true;
    }

    public Stock getStock(String isbn) {
        Stock stock = null;
        stock = dataBase.getStocksList().stream().filter(s -> s.getIsbn().equals(isbn)).findFirst().orElse(null);
        return stock;
    }



}
