package oneToManyBi.repo;

import org.springframework.data.repository.CrudRepository;

import oneToManyBi.entity.Instructor;

public interface InstructorRepo extends CrudRepository<Instructor, Integer> {

}
