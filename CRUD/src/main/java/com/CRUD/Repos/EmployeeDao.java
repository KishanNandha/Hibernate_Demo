package com.CRUD.Repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.CRUD.Entities.Employee;

@Repository
public interface EmployeeDao extends CrudRepository<Employee, Long>{

}
