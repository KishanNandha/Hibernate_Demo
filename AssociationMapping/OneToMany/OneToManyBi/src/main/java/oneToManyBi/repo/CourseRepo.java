package oneToManyBi.repo;

import org.springframework.data.repository.CrudRepository;

import oneToManyBi.entity.Course;

public interface CourseRepo extends CrudRepository<Course, Integer> {

}
