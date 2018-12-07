package com.cofeeshop.service;

import com.cofeeshop.model.Beverage;
import com.cofeeshop.model.Customer;
import com.cofeeshop.model.Order;
import com.cofeeshop.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class OrderService  {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private  CustomerService customerService;

    @Autowired
    private  BeverageService beverageService;

    public void placeOrder(String customerName ,String mobile,Set<String> beverageName){
        Customer customer= customerService.findCustomerByFullNameOrMobile(customerName,mobile);
        Set<Beverage> beverages = beverageService.findAllByName(beverageName);
        Order order = null;
        List<Order>  orders  = new ArrayList<>();
        for(Beverage beverage : beverages){
            order =  new Order();
            order.setCustomer(customer);
            order.setBeverage(beverage);

            orders.add(order);

        }

        orderRepository.saveAll(orders);

    }


    public void cancelOrder(String customerName ,String mobile,Set<Integer> orderIds){

        //Set<Integer> ids =orderIds.stream().map(Integer::parseInt).collect(Collectors.toSet());

        List<Order>  orders  = orderRepository.findAllByOrderIdIn(orderIds);
        for(Order order : orders){

            order.setOrder_status("Cancel");

            orders.add(order);

        }

        orderRepository.saveAll(orders);

    }













}
