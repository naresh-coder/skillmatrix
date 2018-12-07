package com.cofeeshop;

import com.cofeeshop.model.Beverage;
import com.cofeeshop.model.Customer;
import com.cofeeshop.repository.BeverageRepository;
import com.cofeeshop.repository.CustomerRepository;
import com.cofeeshop.service.BeverageService;
import com.cofeeshop.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BeverageServiceTest {


    @Mock
    private BeverageRepository beverageRepository;

    @InjectMocks
    private BeverageService beverageService;


    @Test
    public void  testSave(){
        Beverage beverage = new Beverage();
        beverageService.createBeverage(beverage);

    }
}
