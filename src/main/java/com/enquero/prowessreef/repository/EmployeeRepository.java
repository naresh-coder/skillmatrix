package com.enquero.prowessreef.repository;

import com.enquero.prowessreef.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    Employee findByEmployeeId(Integer employeeID);

}
