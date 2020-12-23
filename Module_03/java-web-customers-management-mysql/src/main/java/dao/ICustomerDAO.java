package dao;

import model.Customer;

import java.util.List;

public interface ICustomerDAO {
    List<Customer> findAll();

    Customer selectCustomer(int id);

    void save(Customer customer);

    Customer findById(int id);

    void update(int id, Customer customer);

    boolean remove(int id);
}
