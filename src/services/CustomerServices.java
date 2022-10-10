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

    public boolean addCustomer(Customer newCustomer) {
        getDataBase().getCustomersList().add(newCustomer);
        return true;
    }

    public int getNewCustomerId() {
        int lastCustomerId = 0;

        if (getDataBase().getCustomersList().size() > 0) {
            lastCustomerId = getDataBase().getCustomersList().get(getDataBase().getCustomersList().size() - 1).getId();
        }

        lastCustomerId = lastCustomerId + 1;

        return lastCustomerId;
    }


}
