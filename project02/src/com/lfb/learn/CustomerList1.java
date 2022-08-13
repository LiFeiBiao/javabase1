package com.lfb.learn;
public class CustomerList1 {
    private Customer1[] customers;
    private int total = 0;

    public CustomerList1(int totalCustomer) {
        customers = new Customer1[totalCustomer];
    }

    public boolean addCustomer(Customer1 customer) {
        if (total >= customers.length) return false;

        customers[total++] = customer;
        return true;
    }

    public boolean replaceCustomer(int index, Customer1 cust) {
        if (index < 0 || index >= total) return false;

        customers[index] = cust;
        return true;
    }

    public boolean deleteCustomer(int index) {
        if (index < 0 || index >= total) return false;

        for (int i = index; i < total - 1; i++) {
            customers[i] = customers[i + 1];
        }

        customers[--total] = null;

        return true;
    }

    public Customer1[] getAllCustomers() {
        Customer1[] custs = new Customer1[total];
        for (int i = 0; i < total; i++) {
            custs[i] = customers[i];
        }
        return custs;
    }

    public int getTotal() {
        return total;
    }

    public Customer1 getCustomer(int index) {
        if (index < 0 || index >= total) return null;

        return customers[index];
    }
}
