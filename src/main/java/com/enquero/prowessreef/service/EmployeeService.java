package com.enquero.prowessreef.service;

import com.enquero.prowessreef.exception.EmployeeNotFoundException;
import com.enquero.prowessreef.model.Address;
import com.enquero.prowessreef.model.Employee;
import com.enquero.prowessreef.model.SkillMatrix;
import com.enquero.prowessreef.repository.AddressRepository;
import com.enquero.prowessreef.repository.EmployeeRepository;
import com.enquero.prowessreef.repository.SkillMatrixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EmployeeService {

  @Autowired
  private EmployeeRepository employeeRepository;

  @Autowired
  private SkillMatrixRepository skillMatrixRepository;

  @Autowired
  private AddressRepository addressRepository;


  public Employee findByEmployeeIdOrName(int userId) {

    Employee byEmployeeId = employeeRepository.findByEmployeeId(userId);
    return byEmployeeId;
  }

  public void createUser(Employee employee) {
    employeeRepository.save(employee);
  }

  public String updateEmployee(int userId, Employee employee) throws EmployeeNotFoundException {
    Employee existingEmployee = this.findByEmployeeIdOrName(userId);
    if (existingEmployee == null) {
      throw new EmployeeNotFoundException();
    }
    employeeRepository.save(existingEmployee);
    //TODO: temp code
    return "success";
  }

  public void removeUser(int userId, String name) {
    Employee byEmployeeIdOrName = findByEmployeeIdOrName(userId);
    employeeRepository.delete(byEmployeeIdOrName);
  }

  public SkillMatrix getEmplOverview(Integer userId) {
    Employee byEmployeeId = employeeRepository.findByEmployeeId(userId);
//        Iterable skillMatrixList = skillMatrixRepository.findAll();
//        Iterator iterator = skillMatrixList.iterator();
//        List<SkillMatrix> skillList = new LinkedList<>();
//        while(iterator.hasNext()){
//            SkillMatrix next = (SkillMatrix) iterator.next();
//            next.toString().contains(userId.toString());
//            skillList.add(next);
//        }
    List<SkillMatrix> byEmployeeIn1 = skillMatrixRepository.findByEmployee(byEmployeeId);
    List<Address> byEmployee = addressRepository.findByEmployee(byEmployeeId);
    //  List<Address> byEmployeeIn = addressRepository.findByEmployeeIn(userId);
    return byEmployeeIn1.get(0);
  }
}
