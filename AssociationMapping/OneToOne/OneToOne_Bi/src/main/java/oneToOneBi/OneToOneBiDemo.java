package oneToOneBi;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import oneToOneBi.entity.Instructor;
import oneToOneBi.entity.InstructorDetail;
import oneToOneBi.repos.InstructorDetailRepo;
import oneToOneBi.repos.InstructorRepo;

@SpringBootApplication
public class OneToOneBiDemo implements CommandLineRunner {

	@Autowired
	InstructorRepo instructorRepo;
	@Autowired
	InstructorDetailRepo instructorDetailRepo;

	public static void main(String[] args) {
		SpringApplication.run(OneToOneBiDemo.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		saveDemo();
		//deleteDemo();
		//fetchInstructorFromInstructorDetail();
		//cascadeDelete();
	}

	public void saveDemo() {
		Instructor tempInstructor = new Instructor("yash", "Patel", "yash@luv2code.com");

		InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com", "Guitar");

		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		instructorRepo.save(tempInstructor);
	}
	
	public void fetchInstructorFromInstructorDetail() {
		Optional<InstructorDetail> instructorDetail = instructorDetailRepo.findById(2);
		
		Optional<String> value = instructorDetail.map(InstructorDetail::getInstructor).map(Instructor::getFirstName);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + value.orElse("no value found"));
		
	}
	
	public void cascadeDelete() {
		if(instructorDetailRepo.existsById(2)) {
			instructorDetailRepo.deleteById(2);
			//this will also delete associated cascadeDelete object
		}
	}
	
	public void deleteJustInstructorDetail() {
		//change cascade type in InstructorDetail class from all to all other than delete
		Optional<InstructorDetail> instructorDetailOpt = instructorDetailRepo.findById(2);
		if(instructorDetailOpt.isPresent()) {
			InstructorDetail  instructorDetail= instructorDetailOpt.get();
			
			//this is important 
			//if not done .. error 
			// this is breaking bi - directional link 
			instructorDetail.getInstructor().setInstructorDetail(null);
			
			instructorRepo.deleteById(instructorDetail.getId());
		}
	}
}
