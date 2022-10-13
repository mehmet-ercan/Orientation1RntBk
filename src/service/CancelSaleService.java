package service;

import db.DataBase;
import domain.CancaledSale;
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

    public void cancelSale(CancaledSale cancaledSale) {
        dataBase.getCancaledSales().add(cancaledSale);
        float refund = calculateRefund(cancaledSale);
        cancaledSale.setRefund(refund);
    }

    public float calculateRefund(CancaledSale cancaledSale) {
        long diff = Duration.between(cancaledSale.getSale().getOperationDateTime(), cancaledSale.getCanceledDateTime()).toHours();
        float refund;
        if (diff > 24) {
            refund = cancaledSale.getSale().getTotal() * 0.75f;
        } else {
            refund = cancaledSale.getSale().getTotal();
        }
        return refund;
    }
}
