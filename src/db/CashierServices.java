package db;

import domain.Book;

public class CashierServices {

    DataBase dataBase;
    BookServices bookServices;

    public DataBase getDataBase() {
        return dataBase;
    }

    public void setDataBase(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public boolean addBook(){
        return true;
    }
}
