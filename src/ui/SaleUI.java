package ui;

import domain.Sale;
import services.SaleServices;

import java.util.Scanner;

public class SaleUI {

    SaleServices saleServices;
    Scanner readScreen = new Scanner(System.in);

    public SaleUI(SaleServices saleServices) {
        this.saleServices = saleServices;
    }

    public void sellBook() {

        try {
            Sale sale = new Sale();
            int customerId = 0;

            System.out.println("Kitap satın alacak olan müşteri numarasını giriniz:");
            System.out.println("Müşteri kayıtlı değilse önce müşteri kaydını yapınız.");
            System.out.println("Müşteri Numarası: ");
            customerId = readScreen.nextInt();

            if (!saleServices.isValidCustomer(customerId)) {
                System.out.println(customerId + " < numaralı müşteri bulunamamıştır. Lütfen önce müşteri ekleyiniz");
            } else {

                String isbn = "";
                do {
                    System.out.println("Satın alınan kitabın isbn numarasını giriniz:");
                    isbn = readScreen.nextLine();

                    if (saleServices.isValidBook(isbn)) {
                        //sale.getBookItemsWithQuantity().put(new Book(), 1);
                    }

                } while (isbn.equals("0"));


            }


        } catch (Exception e) {
            System.out.println("Hatalı bir giriş yapılmıştır, > " + e.getMessage());
            //throw new RuntimeException(e);
        }

    }
}
