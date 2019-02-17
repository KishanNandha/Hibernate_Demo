/**
 * 
 */
package CriteriaApi.Entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author kishan.nandha
 * @since Feb 7, 2019
 */
@Entity
@Table(name="students")
public class Student {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long studentId;
	
	@Column
	private String name;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="courseId")
	private Course course;

	public Student() {
		super();
	}

	/**
	 * @param studentId
	 * @param name
	 * @param courses
	 */
	public Student(String name, Course course) {
		super();
		this.name = name;
		this.course = course;
	}

	/**
	 * @return the studentId
	 */
	public long getStudentId() {
		return studentId;
	}

	/**
	 * @param studentId the studentId to set
	 */
	public void setStudentId(long studentId) {
		this.studentId = studentId;
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
	 * @return the courses
	 */
	public Course getCourses() {
		return course;
	}

	/**
	 * @param courses the courses to set
	 */
	public void setCourses(Course courses) {
		this.course = courses;
	}

	
	
	
	
}
