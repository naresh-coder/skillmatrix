package com.enquero.prowessreef.service;

import com.enquero.prowessreef.exception.EmployeeNotFoundException;
import com.enquero.prowessreef.model.Employee;
import com.enquero.prowessreef.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;



    public Employee findByEmployeeIdOrName(int userId){
      Employee byEmployeeId = employeeRepository.findByEmployeeId(userId);
      return byEmployeeId;
      //       return employeeDAO.findById(userId);
    }

    public void createUser(Employee employee){
        employeeRepository.save(employee);
    }

    public String updateEmployee(int userId, Employee employee) throws EmployeeNotFoundException {
        Employee existingEmployee = this.findByEmployeeIdOrName(userId);
        if(existingEmployee == null)
            throw new EmployeeNotFoundException();
        employeeRepository.save(existingEmployee);
        //TODO: temp code
        return "success";
    }

    public void removeUser(int userId, String name){
        Employee byEmployeeIdOrName = findByEmployeeIdOrName(userId);
        employeeRepository.delete(byEmployeeIdOrName);
    }
}
