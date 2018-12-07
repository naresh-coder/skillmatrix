package com.cofeeshop.repository;

import com.cofeeshop.model.Beverage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;


@Repository
public interface BeverageRepository extends CrudRepository<Beverage,Integer> {
    Beverage  findByBeverageName(String name);
    Set<Beverage> findByBeverageNameIn(Set<String> stringSet);
}
