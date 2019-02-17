package componentmapping.repos;

import org.springframework.data.repository.CrudRepository;

import componentmapping.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
