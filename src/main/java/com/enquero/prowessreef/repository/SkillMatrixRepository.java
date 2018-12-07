package com.enquero.prowessreef.repository;

import com.enquero.prowessreef.model.Employee;
import com.enquero.prowessreef.model.SkillMatrix;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillMatrixRepository extends CrudRepository<SkillMatrix, Integer> {

  List<SkillMatrix> findByEmployeeIn(Integer integer);

  List<SkillMatrix> findByEmployee(Employee employee);

}
