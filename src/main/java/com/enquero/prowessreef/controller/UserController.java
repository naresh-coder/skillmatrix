package com.enquero.prowessreef.controller;

import com.enquero.prowessreef.model.Customer;
import com.enquero.prowessreef.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/customer/service")
public class CustomerController {
  @Autowired
  private CustomerService customerService;

  @GetMapping("v1/{name}/or/{mobile}")
  @ResponseBody
  public Customer getCustomer(@PathParam("name") String name, @PathParam("mobile") String mobile){
      return customerService.findCustomerByFullNameOrMobile(name,mobile);
  }

  @PostMapping("/save")
  public String createCustomer(@RequestBody Customer customer){
      customerService.createCustomer(customer);
      return "";
  }

  @PutMapping("/update")
   public String updateCustomer(@RequestBody Customer customer){
    customerService.updateCustomer(customer);
     return "";
    }
    @DeleteMapping("delete/{name}/or/{mobile}")
    public String remove(@PathParam("name") String name, @PathParam("mobile") String mobile){
        customerService.removeCustomer(name,mobile);
        return "";
    }

}
