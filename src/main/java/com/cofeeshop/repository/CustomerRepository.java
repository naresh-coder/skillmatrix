package com.cofeeshop.repository;

import com.cofeeshop.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer,Integer> {
    Customer  findCustomerByFullNameOrMobile(String name, String mobile);
}
