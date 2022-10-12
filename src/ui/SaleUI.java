package ui;

import domain.Book;
import domain.Sale;
import services.BookServices;
import services.CustomerServices;
import services.SaleServices;

import java.time.LocalDateTime;
import java.util.Scanner;

public class SaleUI {

    Scanner readScreen = new Scanner(System.in);

    public void sellBook() {

        try {
            Sale sale = new Sale();
            int customerId = 0;

            System.out.println("Kitap satın alacak olan müşteri numarasını giriniz:");
            System.out.println("Müşteri kayıtlı değilse önce müşteri kaydını yapınız.");
            System.out.println("Müşteri Numarası: ");
            customerId = Integer.parseInt(readScreen.nextLine());

            if (!CustomerServices.getInstance().isValidCustomer(customerId)) {
                System.out.println(customerId + " < numaralı müşteri bulunamamıştır. Lütfen önce müşteri ekleyiniz");
            } else {

                String isbn = "";
                Book book;

                do {
                    System.out.println("Çıkmak için 0 yazınız:");
                    System.out.println("Satın alınan kitabın isbn numarasını giriniz:");

                    isbn = readScreen.nextLine();

                    if (isbn.equals("0")) {
                        break;
                    }

                    book = BookServices.getInstance().getBook(isbn);

                    if (book != null) {
                        System.out.println(book.getName() + " kitabından kaç adet alınacak?:");
                        int quantity = readScreen.nextInt();
                        sale.getBookItemsWithQuantity().put(book, quantity);
                        System.out.println(book.getName() + " kitabı," + quantity + " kadar eklenmiştir.");
                    } else {
                        System.out.println(isbn + " numaralı kitap bulunamamıştır. Tekrar deneyiniz\n\n");
                    }
                } while (!isbn.equals("0"));

                sale.setTotal(sale.getBookItemsWithQuantity());
                sale.setSaleDateTime(LocalDateTime.now());
                sale.setSaleNumber(SaleServices.getInstance().generateReceiptNumber("S"));
                SaleServices.getInstance().addSale(sale);

            }
        } catch (Exception e) {
            System.out.println("Hatalı bir giriş yapılmıştır, > " + e.getMessage());
            //throw new RuntimeException(e);
        }

    }


}
