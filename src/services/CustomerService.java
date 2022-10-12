package services;

import db.DataBase;
import domain.Customer;

public class CustomerService {
    private DataBase dataBase;
    private static CustomerService customerServices;

    public void setDataBase(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public CustomerService() {
    }

    public static CustomerService getInstance() {
        if (customerServices == null) {
            customerServices = new CustomerService();
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
