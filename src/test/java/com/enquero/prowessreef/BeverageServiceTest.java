package com.enquero.skillmanagement;

import com.enquero.skillmanagement.model.Beverage;
import com.enquero.skillmanagement.repository.BeverageRepository;
import com.enquero.skillmanagement.service.BeverageService;
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
