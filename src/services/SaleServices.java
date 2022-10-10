package services;

import db.DataBase;

public class SaleServices {

    public SaleServices(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    DataBase dataBase;

    public void setDataBase(DataBase dataBase) {
        this.dataBase = dataBase;
    }
}
