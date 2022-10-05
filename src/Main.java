import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Store rentaBookStore = new Store();
        Cashier cashier1 = new Cashier("Mehmet E.", "Akcan", "551 010 6464", "237V+6F Ümraniye, İstanbul");
        rentaBookStore.workCashier(cashier1);
        printMenu(cashier1);
    }


    public static void printMenu(Cashier cashier) {
        Scanner readScreen = new Scanner(System.in);
        int menuChoice = 0;
        System.out.println("RentaBook - Kitap Kiralama Uygulaması !");

        do {
            System.out.println("\n1.) Kitap Ekle ");
            System.out.println("2.) Müşteri Ekle ");
            System.out.println("0.) Çıkış\n");
            System.out.print(" Seçiminiz: ");

            menuChoice = readScreen.nextInt();
            cashier.go(menuChoice);

        } while (menuChoice != 0);

        System.out.println("İyi Günler Dileriz. ");
    }


}