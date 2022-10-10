package services;

import db.DataBase;

public class SaleServices {

    public SaleServices(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    private DataBase dataBase;

    //TODO > Müşteri sorgulama işlemi, CustomerServices tarafından yapılması gerekiyor.
    public boolean isValidCustomer(int customerId) {
        return dataBase.getCustomersList().stream().anyMatch(c -> c.getId() == customerId);
    }

    //TODO > Kitap sorgulama işlemi, BookServices tarafından yapılması gerekiyor.
    public boolean isValidBook(String isbn) {
        return dataBase.getBooksList().stream().anyMatch(b -> b.getIsbn().equals(isbn));
    }


}
