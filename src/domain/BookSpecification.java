package domain;

import java.time.LocalDate;

public class BookSpecification {

    private String isbn;
    private float price;
    private LocalDate firstPriceDate;
    private LocalDate secondPriceDate;

    public String getIsbn() {
        return isbn;
    }

    public BookSpecification(String isbn, float price, LocalDate firstPriceDate, LocalDate secondPriceDate) {
        this.isbn = isbn;
        this.price = price;
        this.firstPriceDate = firstPriceDate;
        this.secondPriceDate = secondPriceDate;
    }

    public BookSpecification() {
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public LocalDate getFirstPriceDate() {
        return firstPriceDate;
    }

    public void setFirstPriceDate(LocalDate firstPriceDate) {
        this.firstPriceDate = firstPriceDate;
    }

    public LocalDate getSecondPriceDate() {
        return secondPriceDate;
    }

    public void setSecondPriceDate(LocalDate secondPriceDate) {
        this.secondPriceDate = secondPriceDate;
    }
}
