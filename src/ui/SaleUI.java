package ui;

import domain.Book;
import domain.Customer;
import domain.Sale;
import domain.Stock;
import service.BookService;
import service.CustomerService;
import service.SaleService;
import service.StockService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Scanner;

public class SaleUI {

    BookService bookService = BookService.getInstance();
    SaleService saleService = SaleService.getInstance();
    CustomerService customerService = CustomerService.getInstance();
    StockService stockService = StockService.getInstance();

    Scanner readScreen = new Scanner(System.in);

    /**
     *
     */
    public void sellBook() {
        try {
            Sale sale = new Sale();
            int customerId = 0;

            System.out.println("Kitap satın alacak olan müşteri numarasını giriniz:");
            System.out.println("Müşteri kayıtlı değilse önce müşteri kaydını yapınız.");
            System.out.println("Müşteri Numarası: ");
            customerId = Integer.parseInt(readScreen.nextLine());

            if (!customerService.isValidCustomer(customerId)) {
                System.out.println(customerId + " < numaralı müşteri bulunamamıştır. Lütfen önce müşteri ekleyiniz");
            } else {

                String isbn = "";
                Book book;
                Boolean isAdded = false;

                do {
                    System.out.println("Toplam ücret veya çıkış için 0 tuşuna basınız.");
                    System.out.println("Satın alınan kitabın isbn numarasını giriniz:");
                    isbn = readScreen.nextLine();

                    if (isbn.equals("0")) {
                        break;
                    }

                    book = bookService.getBook(isbn);

                    if (book != null) {
                        System.out.println(book.getName() + " kitabından kaç adet alınacak?:");
                        int quantity = Integer.parseInt(readScreen.nextLine());

                        Stock stock = stockService.getStock(book.getIsbn());
                        if (stock.getQauntity() < quantity) {
                            System.out.println("Dükkanda istenilen adette kitap mevcut değildir.\n" +
                                    "Sadece " + stock.getQauntity() + " tane kitap alabilirsiniz.");
                        } else {
                            sale.getBookAndQuantityMap().put(book, quantity);
                            System.out.println(book.getName() + " kitabı," + quantity + " kadar eklenmiştir.\n");
                            isAdded = true;
                        }

                    } else {
                        System.out.println(isbn + " numaralı kitap bulunamamıştır. Tekrar deneyiniz\n\n");
                    }
                } while (!isbn.equals("0"));

                if (isAdded) {
                    sale.setCustomerId(customerId);
                    sale.setTotal(saleService.calculateTotal(sale));

                    sale.setOperationDateTime(LocalDateTime.now());
                    //.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
                    sale.setOperationNumber(saleService.generateSaleNumber(sale.getCustomerId()));

                    showCart(sale);
                    System.out.println("Satın alınacak kitaplar yukarıdaki gibidir. " +
                            "\nOnaylıyorsanız E tuşuna basınız. İptal için hernagi bir tuşa basabilirsiniz.");

                    String response = readScreen.nextLine();

                    if (response.equals("E") || response.equals("e")) {
                        saleService.addSale(sale);
                        for (Map.Entry<Book, Integer> saleMap : sale.getBookAndQuantityMap().entrySet()) {
                            stockService.increaseStock(saleMap.getKey().getIsbn(), saleMap.getValue() * -1);
                        }
                        System.out.println("Satın alma işlemi gerçekleştirilmiştir.\n");
                        showReceipt(sale);

                    } else {
                        System.out.println("İşlem iptal edilmiştir.");

                    }
                }
            }

            System.out.println("Ana menüye yönlendiriliyorsunuz.");
            UI.delay(1);

        } catch (Exception e) {
            System.out.println("Hatalı bir giriş yapılmıştır, > " + e.getMessage());
        }
    }

    public void showCart(Sale sale) {
        int i = 1;

        for (Map.Entry<Book, Integer> saleMap : sale.getBookAndQuantityMap().entrySet()) {
            System.out.print(i++ + ". " + saleMap.getKey().getName() + " >> " + saleMap.getValue() + " adet : ");
            System.out.println(saleMap.getKey().getBookSpecification().getPrice() * saleMap.getValue() + " TL");
        }

        System.out.println("Satın alımış kitapların toplam ücreti: " + sale.getTotal() + "\n\n");

    }

    public void showReceipt(Sale sale) {
        System.out.println("İşlem Özeti => \n");
        System.out.println("Tarih: " + sale.getOperationDateTime().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
        System.out.println("İşlem Numarası:" + sale.getOperationNumber());
        Customer customer = customerService.getCustomerInfo(sale.getCustomerId());

        System.out.println("Müşteri Adı:" + customer.getName() + " " + customer.getSurName());
        System.out.println("Telefon Numarası: " + customer.getPhoneNumber());
        System.out.println("Satın alınan kitaplar -> \n");

        showCart(sale);
        UI.delay(2);
    }

}
