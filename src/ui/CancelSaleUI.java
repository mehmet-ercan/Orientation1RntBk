package ui;

import domain.Book;
import domain.CancelSale;
import domain.Sale;
import service.CancelSaleService;
import service.SaleService;
import service.StockService;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Scanner;

public class CancelSaleUI {

    Scanner readScreen = new Scanner(System.in);
    SaleService saleService = SaleService.getInstance();
    CancelSaleService cancelSaleService = CancelSaleService.getInstance();
    StockService stockService = StockService.getInstance();

    public void cancelSale() {
        String saleNumber;
        System.out.println("İptal edilecek olan satış numarasını giriniz:");
        saleNumber = readScreen.nextLine();

        Sale sale = saleService.getSale(saleNumber);
        CancelSale cancaledSale = new CancelSale();

        if (sale != null) {
            cancaledSale.setSale(sale);
            cancaledSale.setCanceledDateTime(LocalDateTime.parse("2022-10-13T19:11:52.965611"));
            //cancaledSale.setCanceledDateTime(LocalDateTime.now());
            System.out.println("Bu satış için geri ödeme miktarı: " + cancelSaleService.calculateRefund(cancaledSale));
            System.out.println("Kabul ediyorsanız E yazınız:");

            String answer = readScreen.nextLine();
            if (answer.equals("E") || answer.equals("e")) {

                cancelSaleService.cancelSale(cancaledSale);

                for (Map.Entry<Book, Integer> map : sale.getBookAndQuantityMap().entrySet()) {
                    stockService.increaseStock(map.getKey().getIsbn(), map.getValue());
                }

                saleService.removeSale(sale);

                System.out.println(cancaledSale.getSale().getOperationNumber() + " nolu sipariş iptal edilmiştir.");
            }


        } else {
            System.out.println(saleNumber + " işlemine ait satış bulunamamıştır.");
        }

        System.out.println("Ana menüye yönlendiriliyorsunuz.");
        UI.delay(1);

    }
}