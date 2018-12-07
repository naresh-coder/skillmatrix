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

  @GetMapping("{emp_id}/or/{name}")
  @ResponseBody
  public ResponseEntity<Employee> getUserDetails(@PathVariable("emp_id") Integer userId, @PathVariable("name") String name) {
   return new ResponseEntity<>(employeeService.findByEmployeeIdOrName(userId, name),HttpStatus.OK);
  }

  @PutMapping("{emp_id")
  public ResponseEntity<String> updateUser(@PathVariable("emp_id") Integer userId, @RequestBody Employee employee) {
    return new ResponseEntity<String>(employeeService.updateEmployee(userId, employee), HttpStatus.OK);
  }

}
