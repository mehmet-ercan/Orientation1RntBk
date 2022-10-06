package domain;

public class Store {

    private String name;
    private String adress;
    private Cashier cashier;



    public void workCashier(Cashier cashier) {
        this.cashier = cashier;
    }

}
