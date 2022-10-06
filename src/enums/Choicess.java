package enums;

public enum Choicess {
    EXIT(0), ADD_BOOK(1), ADDCUSTOMER(2), SELLBOOK(3), RENTBOOK(4), SALECANCEL(5),
    REFUNDBOOK(6), START(7);
    private int value;

    Choicess(int value) {
        this.value = value;
    }
}
