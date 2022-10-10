package services;

import db.DataBase;
import domain.Customer;

public class CustomerServices {
    private DataBase dataBase;

    public CustomerServices(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public DataBase getDataBase() {
        return dataBase;
    }

    /**
     *
     * @param newCustomer
     * @return
     */
    public boolean addCustomer(Customer newCustomer) {
        dataBase.getCustomersList().add(newCustomer);
        return true;
    }

    public int getNewCustomerId() {
        int lastCustomerId = 0;

        if (dataBase.getCustomersList().size() > 0) {
            lastCustomerId = dataBase.getCustomersList().get(dataBase.getCustomersList().size() - 1).getId();
        }

        lastCustomerId = lastCustomerId + 1;

        return lastCustomerId;
    }




}
