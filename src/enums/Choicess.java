package enums;

public enum Choicess {
    EXIT(0), ADD_BOOK(1), ADD_CUSTOMER(2), SELL_BOOK(3), RENT_BOOK(4), CANCEL_SALE(5),
    REFUND_BOOK(6), ADD_BOOK_STOCK(7) , LIST_BOOK(8) , START(101);
    private int value;

    Choicess(int value) {
        this.value = value;
    }
}
