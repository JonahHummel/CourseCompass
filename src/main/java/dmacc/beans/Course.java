package dmacc.beans;
/**
 * @author Mandy Wiedmier
 * @author Jonah Hummel
 * @author Larry Paucar
 * CIS175 - Spring 2024
 * Final Project - CourseCompass
 * Due Date: Apr 30, 2024
 */
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


/**
 * Course has a Many to One relation with Student entity
 * A List of Course object(s) are stored in each Student created
 */
@Entity
public class Course {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id; 
	private String courseId; 
	private String courseName; 
	private int creditHours;
	private String instructor;
	private double currentGrade;
	private boolean isCompleted;
	@ManyToOne
    private Student student;
	
	public Course() {
		super();
	}

	public Course(String courseId, String courseName, int creditHours, String instructor, double currentGrade) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.creditHours = creditHours;
		this.instructor = instructor;
		this.currentGrade = currentGrade;
	}
	
	public Course(long id, String courseId, String courseName, int creditHours, String instructor, double currentGrade) {
		super();
		this.id = id;
		this.courseId = courseId;
		this.courseName = courseName;
		this.creditHours = creditHours;
		this.instructor = instructor;
		this.currentGrade = currentGrade;
	}
	
	
	//Getters and Setters

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getCreditHours() {
		return creditHours;
	}

	public void setCreditHours(int creditHours) {
		this.creditHours = creditHours;
	}

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	public double getCurrentGrade() {
		return currentGrade;
	}

	public void setCurrentGrade(double currentGrade) {
		this.currentGrade = currentGrade;
	}

	public boolean isCompleted() {
		return isCompleted;
	}

	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
	
	//Helper Methods
	
	@Override
	public String toString() {
		return "Course [id=" + id + ", courseId=" + courseId + ", courseName=" + courseName + ", creditHours="
				+ creditHours + ", instructor=" + instructor + ", currentGrade=" + currentGrade + ", isCompleted="
				+ isCompleted + "]";
	}
	
	
	

}
