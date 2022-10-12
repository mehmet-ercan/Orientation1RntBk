package services;

import db.DataBase;
import domain.Customer;

public class CustomerServices {
    private DataBase dataBase;
    private static CustomerServices customerServices;

    public void setDataBase(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public CustomerServices() {
    }

    public static CustomerServices getInstance() {
        if (customerServices == null) {
            customerServices = new CustomerServices();
        }
        return customerServices;
    }


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

    public Customer getCustomerInfo(int id) {
        return dataBase.getCustomersList().stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    public boolean isValidCustomer(int customerId) {
        return dataBase.getCustomersList().stream().anyMatch(c -> c.getId() == customerId);
    }


}
