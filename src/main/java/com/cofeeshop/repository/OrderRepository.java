package com.cofeeshop.repository;
import com.cofeeshop.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface OrderRepository extends CrudRepository<Order,Integer> {

    List<Order> findAllByOrderIdIn(Set<Integer>  integerSet);


}
