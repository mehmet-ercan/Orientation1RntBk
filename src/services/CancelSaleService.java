package services;

import db.DataBase;

public class CancelSaleService {
    DataBase dataBase;
    private static CancelSaleService cancelSaleService;
    private CancelSaleService() {
    }

    public static CancelSaleService getInstance() {
        if (cancelSaleService == null) {
            cancelSaleService = new CancelSaleService();
        }
        return cancelSaleService;
    }

    public void setDataBase(DataBase dataBase) {
        this.dataBase = dataBase;
    }
}
