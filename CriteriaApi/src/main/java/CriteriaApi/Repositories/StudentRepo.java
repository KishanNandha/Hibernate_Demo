/**
 * 
 */
package CriteriaApi.Repositories;

import org.springframework.data.repository.CrudRepository;

import CriteriaApi.Entities.Student;


/**
 * @author kishan.nandha
 * @since Feb 7, 2019
 */
public interface StudentRepo extends CrudRepository<Student, Long>{

}
