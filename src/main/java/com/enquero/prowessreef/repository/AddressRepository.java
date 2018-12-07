package com.enquero.prowessreef.repository;

import com.enquero.prowessreef.model.Address;
import com.enquero.prowessreef.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends CrudRepository<Address, Integer> {
  List<Address> findByEmployee(Employee integer);

  List<Address> findByEmployeeIn(Integer integer);
}
