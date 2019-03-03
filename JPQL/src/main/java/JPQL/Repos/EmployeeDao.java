package JPQL.Repos;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import JPQL.Entities.Employee;

@Repository
public interface EmployeeDao extends CrudRepository<Employee, Long>{

	//select * from employee007
	@Query("from Employee")
	List<Employee> findAllemployee();
	
	//select name, salary,  department
	@Query("select name, salary, dept from Employee")
	List<Object[]> findSomeEmployeeData();
	
	//param starts with :
	@Query("from Employee where name=:n")
	List<Employee> findEmpByName(@Param("n") String name);
	
	@Modifying //all non select query will require this annotations
	@Query("delete from Employee where name=:n")
	void deleteEmployee(@Param("n") String name);
	
	@Query("from Employee")
	List<Employee> findAllemployeePage(Pageable pageable);
	
	@Query(value="select * from employes007", nativeQuery= true)
	List<Employee> findAllemployeeNative();
	
	//param starts with :
	@Query("select * from employes007 where name=:n")
	List<Employee> findEmpByNameParam(@Param("n") String name);
}
