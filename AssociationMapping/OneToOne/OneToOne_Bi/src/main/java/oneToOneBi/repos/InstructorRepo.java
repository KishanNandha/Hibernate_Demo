package oneToOneBi.repos;

import org.springframework.data.repository.CrudRepository;

import oneToOneBi.entity.Instructor;

public interface InstructorRepo extends CrudRepository<Instructor, Integer> {

}
