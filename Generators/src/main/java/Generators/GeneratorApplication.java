package Generators;

import java.util.Optional;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import Generators.Entities.Employee;
import Generators.Repos.EmployeeDao;

@SpringBootApplication
public class GeneratorApplication implements CommandLineRunner{

	@Autowired
	private EmployeeDao employeeDao;
	
	public static void main(String[] args) {
		SpringApplication.run(GeneratorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//saveEmployee();
		//retriveEmployee();
		//updateEmployee();
		//deleteEmployee();
		getEmployeeCount();
	}

	private void saveEmployee() {
		Employee dhoni = new Employee("Dhoni", 10000L, "Java");
		Employee rohit = new Employee("Rohit", 9000L, "DotNet");
		Employee raina = new Employee("Raina", 8000L, "JS");
		Employee virat = new Employee("Virat", 10000L, "java");
		employeeDao.save(dhoni);
		employeeDao.save(rohit);
		employeeDao.save(raina);
		employeeDao.save(virat);
	}
	
	private void retriveEmployee() {
		//this method returns optional so that it wont throw NullPointer Exception
		Optional<Employee> employee = employeeDao.findById(10L);
		Optional<String> value = employee.map(Employee::getName);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+value.orElse("no value found"));
	}
	
	private void updateEmployee() {
		Optional<Employee> virat = employeeDao.findById(4L);
		virat.ifPresent(new Consumer<Employee>() {
			@Override
		    public void accept(Employee virat) {
		    	virat.setDept("Java");
		    	employeeDao.save(virat);
		    }
		});
	}
	
	private void deleteEmployee() {
		if(employeeDao.existsById(5L)) {
			employeeDao.deleteById(5L);
		}
	}
	private void getEmployeeCount() {
		System.out.println("Total Records===============>>>>>>>>>>>>>>>" + employeeDao.count());
	}
}

