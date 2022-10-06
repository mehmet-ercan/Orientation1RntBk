public class Book {

    //Getters, Setters, Attributes
    private String isbn;
    private String name;
    private String author;
    private String publishYear;
    private int pages;
    private float price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(String publishYear) {
        this.publishYear = publishYear;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }


    public Book(String isbn, String name, String author, String publishYear, int pages, float price) {
        this.isbn = isbn;
        this.name = name;
        this.author = author;
        this.publishYear = publishYear;
        this.pages = pages;
        this.price = price;
    }

    public Book() {

    }


}