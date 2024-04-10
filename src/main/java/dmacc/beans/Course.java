/**
 * @author Mandy Wiedmier - mwiedmier2
 * CIS175 - Spring 2024
 * Apr 6, 2024
 */
package dmacc.beans;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

/**
 * 
 */
@Entity
public class Course {
	@Id 
	@GeneratedValue
	//Changed to long
	private long id; 
	private String courseId; 
	private String courseName; 
	private int creditHours;
	private String instructor;
	private double currentGrade;
	private boolean isCompleted;
	
	//Constructors
	/**
	 * No arg constructor
	 */
	public Course() {
		super();
	}
	/**
	 * @param courseId
	 * @param courseName
	 * @param creditHours
	 * @param instructor
	 * @param currentGrade
	 * @param isCompleted
	 */
	public Course(String courseId, String courseName, int creditHours, String instructor, double currentGrade,
			boolean isCompleted) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.creditHours = creditHours;
		this.instructor = instructor;
		this.currentGrade = currentGrade;
		this.isCompleted = isCompleted;
	}
	/**
	 * @param id
	 * @param courseId
	 * @param courseName
	 * @param creditHours
	 * @param instructor
	 * @param currentGrade
	 * @param isCompleted
	 */
	public Course(long id, String courseId, String courseName, int creditHours, String instructor, double currentGrade,
			boolean isCompleted) {
		super();
		this.id = id;
		this.courseId = courseId;
		this.courseName = courseName;
		this.creditHours = creditHours;
		this.instructor = instructor;
		this.currentGrade = currentGrade;
		this.isCompleted = isCompleted;
	}
	//Getters and Setters
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the courseId
	 */
	public String getCourseId() {
		return courseId;
	}
	/**
	 * @param courseId the courseId to set
	 */
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	/**
	 * @return the courseName
	 */
	public String getCourseName() {
		return courseName;
	}
	/**
	 * @param courseName the courseName to set
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	/**
	 * @return the creditHours
	 */
	public int getCreditHours() {
		return creditHours;
	}
	/**
	 * @param creditHours the creditHours to set
	 */
	public void setCreditHours(int creditHours) {
		this.creditHours = creditHours;
	}
	/**
	 * @return the instructor
	 */
	public String getInstructor() {
		return instructor;
	}
	/**
	 * @param instructor the instructor to set
	 */
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	/**
	 * @return the currentGrade
	 */
	public double getCurrentGrade() {
		return currentGrade;
	}
	/**
	 * @param currentGrade the currentGrade to set
	 */
	public void setCurrentGrade(double currentGrade) {
		this.currentGrade = currentGrade;
	}
	/**
	 * @return the isCompleted
	 */
	public boolean isCompleted() {
		return isCompleted;
	}
	/**
	 * @param isCompleted the isCompleted to set
	 */
	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}
	
	//Helper Methods
	@Override
	public String toString() {
		return "Course [id=" + id + ", courseId=" + courseId + ", courseName=" + courseName + ", creditHours="
				+ creditHours + ", instructor=" + instructor + ", currentGrade=" + currentGrade + ", isCompleted="
				+ isCompleted + "]";
	}
	

}
