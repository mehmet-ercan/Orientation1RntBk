package service;

import db.DataBase;
import domain.CancelSale;
import java.time.Duration;


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

    public void cancelSale(CancelSale cancelSale) {
        dataBase.getCancaledSales().add(cancelSale);
        float refund = calculateRefund(cancelSale);
        cancelSale.setRefund(refund);
    }

    public float calculateRefund(CancelSale cancelSale) {
        long diff = Duration.between(cancelSale.getSale().getOperationDateTime(), cancelSale.getCanceledDateTime()).toHours();
        float refund;
        if (diff > 24) {
            refund = cancelSale.getSale().getTotal() * 0.75f;
        } else {
            refund = cancelSale.getSale().getTotal();
        }
        return refund;
    }
}
