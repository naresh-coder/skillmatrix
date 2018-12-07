package com.enquero.prowessreef;

import com.enquero.prowessreef.model.Customer;
import com.enquero.prowessreef.repository.CustomerRepository;
import com.enquero.prowessreef.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
