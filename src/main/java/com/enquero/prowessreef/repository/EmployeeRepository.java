package com.enquero.prowessreef.repository;

import com.enquero.prowessreef.model.Employee;
import com.enquero.prowessreef.model.User;
import io.swagger.models.auth.In;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Integer> {
    Employee findByEmployeeIdOrName(Integer employeeID, String name);
}
