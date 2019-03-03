package oneToManyBi;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import oneToManyBi.entity.Course;
import oneToManyBi.entity.Instructor;
import oneToManyBi.repo.CourseRepo;
import oneToManyBi.repo.InstructorRepo;

@SpringBootApplication
public class OneToManyBiDemo implements CommandLineRunner {

	@Autowired
	CourseRepo courseRepo;
	
	@Autowired
	InstructorRepo instructorRepo;
	
	@Autowired
	EntityManagerFactory entityManager;
	
	private Session openSession() {
		return entityManager.unwrap(SessionFactory.class).openSession();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(OneToManyBiDemo.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//saveData();
		//fetchData();
		fetchData2();
	}

	public void saveData() {
		Course tempCourse1 = new Course("Air Guitar - The Ultimate Guide");
		Course tempCourse2 = new Course("The Pinball Masterclass");
		Instructor tempInstructor = new Instructor("Madhu", "Patel", "madhu@luv2code.com");
		
		//setup bi directional link
		tempCourse1.setInstructor(tempInstructor);
		tempCourse2.setInstructor(tempInstructor);
		
		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);
		
		courseRepo.save(tempCourse1);
		courseRepo.save(tempCourse2);
		
	}

	public void fetchData() {
		// Optional<Instructor> optional = instructorRepo.findById(4);
		// while lazy loading data we have to cloase session after using data
		Session session = openSession();
		Instructor instructor = session.get(Instructor.class, 4);
		System.out.println(instructor.getCourses());
		session.close();
	}

	public void fetchData2() {
		Instructor instructor = instructorRepo.findById(4).get();
		//above dao will close session 
		System.out.println("************************************************************************************");
		Session session = openSession();
		instructor = (Instructor) session.merge(instructor);
		System.out.println(instructor.getCourses());
		session.close();
	}
}
