package video.rental.demo.infrastructure.customer;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import java.util.List;
import video.rental.demo.domain.customer.Customer;
import video.rental.demo.domain.repository.CustomerRepository;

public class CustomerRepositoryImpl implements CustomerRepository {
    
    private final Map<Integer, Customer> customers;

    public CustomerRepositoryImpl() {
        customers = new TreeMap<>();
    }

    @Override
    public Customer findById(int code) {
        return customers.getOrDefault(code, null);
    }

    @Override
    public void saveCustomer(Customer customer) {
        customers.put(customer.getCustomerId(), customer);
    }

    @Override
    public List<Customer> findAllCustomers() {
        List<Customer> customerList = new ArrayList<>(customers.size());

        for (Customer customer: customers.values()) {
            customerList.add(customer);
        }

        return customerList;
    }
}