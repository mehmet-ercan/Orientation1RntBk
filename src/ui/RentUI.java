package ui;

import domain.*;
import service.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Scanner;

public class RentUI {
    BookService bookService = BookService.getInstance();
    CustomerService customerService = CustomerService.getInstance();
    StockService stockService = StockService.getInstance();
    RentService rentService = RentService.getInstance();

    Scanner readScreen = new Scanner(System.in);

    public void rentBook() {
        try {
            Rent rent = new Rent();
            int customerId;

            System.out.println("Kitap kiralayacak olan müşterinin numarasını giriniz:");
            System.out.println("Müşteri kayıtlı değilse önce müşteri kaydını yapınız.");
            System.out.println("Müşteri Numarası: ");
            customerId = Integer.parseInt(readScreen.nextLine());

            if (!customerService.isValidCustomer(customerId)) {
                System.out.println(customerId + " < numaralı müşteri bulunamamıştır. Lütfen önce müşteri ekleyiniz");
            } else {

                String isbn = "0";
                Book book = null;
                Boolean isAddedBook = false;

                do {
                    System.out.println("Toplam ücret veya çıkış için 0 tuşuna basınız.");
                    System.out.println("Kiralanacak kitabın isbn numarasını giriniz:");
                    isbn = readScreen.nextLine();

                    if (isbn.equals("0")) {
                        System.out.println("\n");
                        break;
                    }

                    book = bookService.getBook(isbn);

                    if (book != null) {
                        System.out.println(book.getName() + " kitabından kaç adet kiralanacak?:");
                        int quantity = Integer.parseInt(readScreen.nextLine());

                        Stock stock = stockService.getStock(book.getIsbn());
                        if (stock.getQauntity() < quantity) {
                            System.out.println("Dükkanda istenilen adette kitap mevcut değildir.\n" +
                                    "Sadece " + stock.getQauntity() + " tane kitap kiralayabilirsiniz.");
                        } else {
                            rent.getBookAndQuantityMap().put(book, quantity);
                            System.out.println(book.getName() + " kitabı, " + quantity + " tane eklenmiştir.\n");
                            isAddedBook = true;
                        }

                    } else {
                        System.out.println(isbn + " numaralı kitap bulunamamıştır. Tekrar deneyiniz\n\n");
                    }
                } while (!isbn.equals("0"));

                if (isAddedBook) {
                    rent.setCustomerId(customerId);
                    rent.setTotal(rentService.calculateTotal(rent));
                    rent.setOperationDateTime(LocalDateTime.now());
                    rent.setOperationNumber(rentService.generateRentNumber(rent.getCustomerId()));
                    rent.setRefundDate(LocalDateTime.now().plusDays(14));
                    rentService.calculateRefund(rent);

                    showCart(rent);
                    System.out.println("Kiralanacak kitaplar yukarıdaki gibidir. " +
                            "\nOnaylıyorsanız E tuşuna basınız. İptal için hernagi bir tuşa basabilirsiniz.");

                    String response = readScreen.nextLine();

                    if (response.equals("E") || response.equals("e")) {
                        rentService.addRent(rent);
                        for (Map.Entry<Book, Integer> rentMap : rent.getBookAndQuantityMap().entrySet()) {
                            stockService.increaseStock(rentMap.getKey().getIsbn(), rentMap.getValue() * -1);
                        }

                        System.out.println("Kiralama işlemi gerçekleştirilmiştir.\n");
                        showReceipt(rent);
                    } else {
                        System.out.println("İşlem iptal edilmiştir.");
                    }
                }
            }
            System.out.println("Ana menüye yönlendiriliyorsunuz.");
            UI.delay(1);
        } catch (NumberFormatException e) {
            System.out.println("Hatalı bir giriş yapılmıştır, > " + e.getMessage());
        }

    }

    public void showCart(Rent rent) {
        int i = 1;

        for (Map.Entry<Book, Integer> saleMap : rent.getBookAndQuantityMap().entrySet()) {
            System.out.print(i++ + ". " + saleMap.getKey().getName() + " >> " + saleMap.getValue() + " adet : ");
            System.out.println(saleMap.getKey().getBookSpecification().getPrice() * saleMap.getValue() + " TL");
        }

        System.out.println("Kiralanmış kitapların toplam ücreti: " + rent.getTotal() + "\n\n");

    }

    public void showReceipt(Rent rent) {
        System.out.println("İşlem Özeti => \n");

        System.out.println("Tarih: " + rent.getOperationDateTime().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
        ;
        System.out.println("İşlem Numarası:" + rent.getOperationNumber());

        Customer customer = customerService.getCustomerInfo(rent.getCustomerId());

        System.out.println("Müşteri Adı:" + customer.getName() + " " + customer.getSurName());
        System.out.println("Telefon Numarası: " + customer.getPhoneNumber());
        System.out.println("Kiralamış kitaplar -> \n");

        showCart(rent);

        System.out.println("Teslim tarihi: " + rent.getRefundDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
        System.out.println("Geri ödenecek miktar: " + rent.getRefund());

        UI.delay(2);
    }


}
