package com.enquero.skillmanagement.controller;

import com.enquero.skillmanagement.model.Beverage;
import com.enquero.skillmanagement.service.BeverageService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/beverage/service")
public class BeverageController {

    private final static  Logger LOGGER = LoggerFactory.getLogger(BeverageController.class);
    @Autowired
    private BeverageService beverageService;

    @GetMapping("/get/{name}")
    @ResponseBody
    @ApiOperation(
            value = "Find beverage  name",
            notes = "Find beverage  name",
            response = Beverage.class
    )
    public Beverage getCustomer(@PathParam("name") String name){
        return beverageService.findBeverageByName(name);
    }

    @PostMapping("/save")
    @ApiOperation(
            value = "Find beverage  json string ",
            notes = "Find beverage  input as json",
            response = String.class
    )
    public String createCustomer(@RequestBody Beverage beverage){
        try {
            beverageService.createBeverage(beverage);
        } catch (Exception e) {
            LOGGER.error(" error while creating customer {0}",e);
           return "failed";
        }
        return "success";
    }

    @PutMapping("/update")
    public String updateCustomer(@RequestBody Beverage beverage){
        beverageService.updateBeverage(beverage);
        return "";
    }
    @DeleteMapping("delete/{name}")
    public String remove(@PathParam("name") String name){
        beverageService.removeBeverage(name);
        return "";
    }
}
