package com.cofeeshop;

import com.cofeeshop.model.Order;
import com.cofeeshop.repository.OrderRepository;
import com.cofeeshop.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderService orderService;





    @Test
    public void  testSave(){
        orderService.cancelOrder("tets","stest",new HashSet<>());

    }
}
