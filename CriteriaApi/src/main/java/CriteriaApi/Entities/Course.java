/**
 * 
 */
package CriteriaApi.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author kishan.nandha 
 * @since Feb 7, 2019
 */
@Entity
@Table(name="courses")
public class Course {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long courseId;
	
	@Column
	private String name;
	
	@OneToOne(mappedBy="course")
	private Student student;

	/**
	 * 
	 */
	public Course() {
		super();
	}

	/**
	 * @param courseId
	 * @param name
	 * @param students
	 */
	public Course(String name) {
		super();
		this.name = name;
	}

	/**
	 * @return the courseId
	 */
	public long getCourseId() {
		return courseId;
	}

	/**
	 * @param courseId the courseId to set
	 */
	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the students
	 */
	public Student getStudents() {
		return student;
	}

	/**
	 * @param students the students to set
	 */
	public void setStudents(Student students) {
		this.student = students;
	}

	
	
}
