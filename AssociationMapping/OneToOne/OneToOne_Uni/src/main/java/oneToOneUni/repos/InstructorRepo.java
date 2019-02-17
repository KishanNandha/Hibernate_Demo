package oneToOneUni.repos;

import org.springframework.data.repository.CrudRepository;

import oneToOneUni.entity.Instructor;

public interface InstructorRepo extends CrudRepository<Instructor, Integer> {

}
