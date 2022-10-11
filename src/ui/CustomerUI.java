package ui;

import domain.Customer;
import services.CustomerServices;

import java.util.Scanner;

public class CustomerUI {

    CustomerServices customerServices;
    Scanner readScreen = new Scanner(System.in);

    public CustomerUI(CustomerServices customerServices) {
        this.customerServices = customerServices;
    }

    public void addCustomer() {
        try {
            Customer newCustomer = new Customer();
            readScreen = new Scanner(System.in);

            int customerId = customerServices.getNewCustomerId();
            newCustomer.setId(customerId);

            System.out.println("Müşterinin Adını Giriniz:");
            newCustomer.setName(readScreen.nextLine());

            System.out.println("Müşterinin Soyadını Giriniz:");
            newCustomer.setSurName(readScreen.nextLine());

            System.out.println("Müşterinin Telefon Numarasını Giriniz:");
            newCustomer.setSurName(readScreen.nextLine());

            if (customerServices.addCustomer(newCustomer)) {
                System.out.println("Müşteri kayıt ediliyor.");
                UI.delayWithComma(3);
                System.out.println("Müşteri kayıt edilmiştir.");
                UI.delay(1);
            } else {
                throw new Exception();
            }

        } catch (Exception exception) {
            System.out.println("Hata kodu:" + exception.getMessage() + "\n");
            System.out.println("Müşteri kaydedilirken bir hata meydana geldi. Tekrar Deneyiniz...");
            UI.delay(3);
            throw new RuntimeException(exception);

        }

    }



}
