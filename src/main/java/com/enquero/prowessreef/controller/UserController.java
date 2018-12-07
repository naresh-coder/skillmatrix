package com.enquero.prowessreef.controller;

import com.enquero.prowessreef.model.Employee;
import com.enquero.prowessreef.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/employee/")
public class UserController {
  @Autowired
  private EmployeeService employeeService;

  @GetMapping("{emp_id}")
  @ResponseBody
  public ResponseEntity<Employee> getEmployeeByEmpIdOrName(@PathVariable("emp_id") Integer userId) {
   return new ResponseEntity<>(employeeService.findByEmployeeIdOrName(userId),HttpStatus.OK);
  }

  @PutMapping("{emp_id")
  public ResponseEntity<String> updateEmployeeByEmpId(@PathVariable("emp_id") Integer userId, @RequestBody Employee employee) {
    return new ResponseEntity<>(employeeService.updateEmployee(userId, employee), HttpStatus.OK);
  }

}
