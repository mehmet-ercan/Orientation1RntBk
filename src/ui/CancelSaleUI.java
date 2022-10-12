package ui;

import services.CancelSaleService;
import services.CustomerService;
import services.SaleService;

import java.util.Scanner;

public class CancelSaleUI {

    Scanner readScreen = new Scanner(System.in);
    SaleService saleService = SaleService.getInstance();
    CancelSaleService cancelSaleService = CancelSaleService.getInstance();


    public void cancelSale() {
        String saleNumber;
        System.out.println("İptal edilecek olan satış numarasını giriniz:");
        saleNumber = readScreen.nextLine();
    }


}
