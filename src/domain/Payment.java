package domain;

public class Payment {
    private Sale sale;
    private Rent rent;
    private float totalPayment;

    public Payment(Sale sale, Rent rent) {
        this.sale = sale;
        this.rent = rent;
    }

    public void calculatePaymante() {
        this.totalPayment = sale.getTotal() + rent.getTotal();
    }

}
