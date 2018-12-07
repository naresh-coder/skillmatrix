package com.enquero.prowessreef.service;

import com.enquero.prowessreef.model.Customer;
import com.enquero.prowessreef.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer findCustomerByFullNameOrMobile(String name, String mobile){
        return customerRepository.findCustomerByFullNameOrMobile(name,mobile);
    }

    public void createCustomer(Customer customer){
        customerRepository.save(customer);
    }

    public void updateCustomer(Customer customer){
        Customer customer1 = this.findCustomerByFullNameOrMobile(customer.getFullName(),customer.getMobile());
        customer1.setFirstName(customer.getFirstName());
        customer1.setLastName(customer.getLastName());
        customer1.setMobile(customer.getMobile());
        customer1.setEmail(customer.getEmail());
        customerRepository.save(customer1);
    }

    public void removeCustomer(String name, String mobile){
        Customer customer1 = this.findCustomerByFullNameOrMobile(name,mobile);
        customerRepository.delete(customer1);
    }

}
