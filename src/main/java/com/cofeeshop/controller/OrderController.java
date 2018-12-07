package com.cofeeshop.controller;

import com.cofeeshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/order")
public class OrderController {


    @Autowired
    OrderService orderService;


    @PostMapping("create/{custName}/or/{mobile}/{beverages}")
    public String placeOrder(@PathVariable("custName") String custName,@PathVariable("mobile") String mobile,@PathVariable("beverages") String names){
        //TODO: can do with error code
        try {
            Set<String> stringSet = Stream.of(names.split(","))
                    .map (elem -> new String(elem))
                    .collect(Collectors.toSet());

            orderService.placeOrder(custName,mobile,stringSet);
        } catch (Exception e) {
            return  "failed";
        }

        return  "success";
    }

    @PutMapping("cancel/{custName}/or/{mobile}/{orders}")
    public String cancelOrder(@PathVariable("custName") String custName,@PathVariable("mobile") String mobile,@PathVariable("orders") String names){
      //TODO: can do with error code

        try {
            Set<Integer> stringSet = Stream.of(names.split(","))
                    .map (Integer::parseInt)
                    .collect(Collectors.toSet());

            orderService.cancelOrder(custName,mobile,stringSet);
        } catch (Exception e) {
            return  "failed";
        }


        return  "success";
    }


}
