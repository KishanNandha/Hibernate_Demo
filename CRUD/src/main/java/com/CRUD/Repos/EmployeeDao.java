package com.CRUD.Repos;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.CRUD.Entities.Employee;

@Repository
//public interface EmployeeDao extends CrudRepository<Employee, Long>{
public interface EmployeeDao extends PagingAndSortingRepository<Employee, Long>{
	
	//note: PagingAndSortingRepository repo contains all methods from curd repo
	
	//Finders methods 
	List<Employee> findByName(String name);
	//List<Employee> findByDept(String dept);
	List<Employee> findByNameAndDept(String name,String dept);
	List<Employee> findBySalaryGreaterThan(Long salary);
	List<Employee> findBySalaryBetween(Long salary1,Long salary2);
	List<Employee> findByNameLike(String name);
	List<Employee> findByIdIn(List<Long> ids);
	
	//for pagination and sorting just add pageable parameter 
	List<Employee> findByDept(String name,Pageable pageable);
}
