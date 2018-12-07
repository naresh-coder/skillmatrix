package com.enquero.skillmanagement.service;

import com.enquero.skillmanagement.model.Beverage;
import com.enquero.skillmanagement.repository.BeverageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;

@Service
@Transactional
public class BeverageService {

    @Autowired
    private BeverageRepository beverageRepository;

    public Beverage findBeverageByName(String name){
        return beverageRepository.findByBeverageName(name);
    }

    public void createBeverage(Beverage beverage){
        beverageRepository.save(beverage);
    }

    public void updateBeverage(Beverage beverage){
        Beverage beverage1 = this.findBeverageByName(beverage.getBeverageName());
        beverage1.setBeverageType(beverage.getBeverageType());
        beverageRepository.save(beverage1);
    }

    public void removeBeverage(String name){
        Beverage beverage = this.findBeverageByName(name);
        beverageRepository.delete(beverage);
    }

    public Set<Beverage> findAllByName(Set<String> beverageName){

       return beverageRepository.findByBeverageNameIn(beverageName);
    }
}
