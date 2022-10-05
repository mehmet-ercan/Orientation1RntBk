import java.util.Scanner;

public class Cashier {
    private String name;
    private String Surname;
    private String phoneNumber;
    private String adress;

    private Book newBook;
    private Stock stock;

    public Cashier(String name, String surname, String phoneNumber, String adress) {
        this.name = name;
        Surname = surname;
        this.phoneNumber = phoneNumber;
        this.adress = adress;
    }

    public void go(int menuChoice) {
        if (menuChoice == 1) {
            if (addBook()) {
                System.out.println("Kitap mağazaya eklenmiştir.");
            } else {
                System.out.println("Kitap eklenirken bir hata meydana geldi. Tekrar Deneyiniz...");
            }
        }
    }

    public boolean addBook() {
        Scanner readScreen = new Scanner(System.in);
        newBook = new Book();

        System.out.println("Kitabın ISBN Numrasını Giriniz:");
        newBook.setIsbn(readScreen.nextLine());

        System.out.println("Kitabın İsmini Giriniz:");
        newBook.setName(readScreen.nextLine());

        System.out.println("Kitabın Yazarını Giriniz:");
        newBook.setAuthor(readScreen.nextLine());

        System.out.println("Kitabın Yayın Yılını Giriniz:");
        newBook.setPublishYear(readScreen.nextLine());


        System.out.println("Kitabın Sayfa Sayısını Giriniz:");
        newBook.setPages(readScreen.nextInt());

        System.out.println("Kitabın Ücretini Giriniz:");
        newBook.setPrice(readScreen.nextFloat());


        return true;
    }

}
