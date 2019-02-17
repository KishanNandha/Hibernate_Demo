package componentmapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import componentmapping.entities.Address;
import componentmapping.entities.Employee;
import componentmapping.repos.EmployeeRepository;

@SpringBootApplication
public class ComponentmappingApplication implements CommandLineRunner {

	@Autowired
	EmployeeRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(ComponentmappingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Employee employee = new Employee();
		employee.setId(123);
		employee.setName("Bharath");
		Address address = new Address();
		address.setCity("Austin");
		address.setStreetaddress("Spicewood Springs");
		address.setCountry("USA");
		address.setState("TEXAS");
		address.setZipcode("78750");
		employee.setAddress(address);
		
		repository.save(employee);
		/*
		 * Hibernate: insert into employee (city, country, state, streetaddress,
		 * zipcode, name, id) values (?, ?, ?, ?, ?, ?, ?)
		 */
	}
}
