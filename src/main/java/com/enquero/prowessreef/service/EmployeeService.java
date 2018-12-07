package com.enquero.prowessreef.service;

import com.enquero.prowessreef.exception.EmployeeNotFoundException;
import com.enquero.prowessreef.model.Employee;
import com.enquero.prowessreef.repository.EmployeeRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee findByEmployeeIdOrName(int userId, String name){
        return employeeRepository.findByEmployeeIdOrName(userId, name);
    }

    public void createUser(Employee employee){
        employeeRepository.save(employee);
    }

    public String updateEmployee(int userId, Employee employee) throws EmployeeNotFoundException {
        Employee existingEmployee = this.findByEmployeeIdOrName(userId,  employee.getName());
        if(existingEmployee == null)
            throw new EmployeeNotFoundException();
        employeeRepository.save(existingEmployee);
        //TODO: temp code
        return "success";
    }

    public void removeUser(int userId, String name){
        Employee byEmployeeIdOrName = findByEmployeeIdOrName(userId, name);
        employeeRepository.delete(byEmployeeIdOrName);
    }
}
