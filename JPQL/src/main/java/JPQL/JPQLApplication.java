package JPQL;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;

import JPQL.Entities.Employee;
import JPQL.Repos.EmployeeDao;

@SpringBootApplication
public class JPQLApplication implements CommandLineRunner{

	@Autowired
	private EmployeeDao employeeDao;
	
	public static void main(String[] args) {
		SpringApplication.run(JPQLApplication.class, args);
	}

	@Transactional
	@Override
	public void run(String... args) throws Exception {
		//saveEmployee();
		//firstJPQL();
		//selectSomeColumns();
		//paramsDemo();
		//deletesomedata();
		nativeDemo();
	}

	private void firstJPQL() {
		System.out.println(employeeDao.findAllemployee().toString());
	}
	
	private void paramsDemo() {
		System.out.println(employeeDao.findEmpByName("Dhoni"));
	}
	
	private void selectSomeColumns() {
		List<Object[]> someEmployeeData = employeeDao.findSomeEmployeeData();
		someEmployeeData.forEach(obj -> {
			System.out.println(obj[0]);
			System.out.println(obj[1]);
			System.out.println(obj[2]);
		});
	}
	//as DML we have to use @Transactional
	@Transactional
	public void deletesomedata() {
		employeeDao.deleteEmployee("Dhoni");
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
	
	private void pagingDemo() {
		System.out.println(employeeDao.findAllemployeePage(new PageRequest(0, 2)));
		
	}
	
	private void nativeDemo() {
		System.out.println(employeeDao.findAllemployeeNative());
	}
}

