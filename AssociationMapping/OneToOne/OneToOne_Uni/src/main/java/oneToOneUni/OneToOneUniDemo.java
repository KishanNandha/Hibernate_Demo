package oneToOneUni;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import oneToOneUni.entity.Instructor;
import oneToOneUni.entity.InstructorDetail;
import oneToOneUni.repos.InstructorRepo;

@SpringBootApplication
public class OneToOneUniDemo implements CommandLineRunner {

	@Autowired
	InstructorRepo instructorRepo;

	public static void main(String[] args) {
		SpringApplication.run(OneToOneUniDemo.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//saveDemo();
		deleteDemo();
	}

	public void saveDemo() {
		Instructor tempInstructor = new Instructor("Madhu", "Patel", "madhu@luv2code.com");

		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com", "Guitar");

		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		instructorRepo.save(tempInstructor);
	}
	
	public void deleteDemo() {
		if(instructorRepo.existsById(1)) {
			instructorRepo.deleteById(1);
		}
	}
}
