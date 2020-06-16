package video.rental.demo.domain.repository;

import java.util.List;

import video.rental.demo.domain.customer.Customer;

public interface CustomerRepository {

    public Customer findById(int id);
    public void saveCustomer(Customer customer);
    public List<Customer> findAllCustomers();
}