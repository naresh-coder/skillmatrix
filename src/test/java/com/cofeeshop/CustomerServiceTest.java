package com.cofeeshop;

import com.cofeeshop.model.Customer;
import com.cofeeshop.repository.CustomerRepository;
import com.cofeeshop.repository.OrderRepository;
import com.cofeeshop.service.CustomerService;
import com.cofeeshop.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {


    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;


    @Test
    public void  testSave(){
        Customer customer = new Customer();
        customerService.createCustomer(customer);

    }

}
