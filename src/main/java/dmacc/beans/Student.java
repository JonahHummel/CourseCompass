package dmacc.beans;
/**
 * @author Mandy Wiedmier
 * @author Jonah Hummel
 * @author Larry Paucar
 * CIS175 - Spring 2024
 * Final Project - CourseCompass
 * Due Date: Apr 30, 2024
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
/**
 * Student has a One to Many relation with Course Entities
 * A List of Course object(s) are stored in each Student created
 */
@Entity
public class Student {
	@Id
	@GeneratedValue
	private long id; 
	private String name;
	@Autowired
	@OneToMany
	private List<Course> listOfCourses;
	
	public Student() {
		super();
	}

	public Student(String name) {
		super();
		this.name = name;
	}

	public Student(String name, List<Course> listOfCourses) {
		super();
		this.name = name;
		this.listOfCourses = listOfCourses;
	}

	public Student(long id, String name, List<Course> listOfCourses) {
		super();
		this.id = id;
		this.name = name;
		this.listOfCourses = listOfCourses;
	}
	
	
	//getters and setters

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Course> getListOfCourses() {
		return listOfCourses;
	}

	public void setListOfCourses(List<Course> listOfCourses) {
		this.listOfCourses = listOfCourses;
	}
	
	
	//Helper Methods
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", listOfCourses=" + listOfCourses + "]";
	}
}