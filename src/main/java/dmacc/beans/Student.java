/**
 * @author Mandy Wiedmier - mwiedmier2
 * CIS175 - Spring 2024
 * Apr 6, 2024
 */
package dmacc.beans;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import dmacc.beans.Course;

/**
 * 
 */
@Entity
public class Student {
	@Id
	@GeneratedValue
	private int id; 
	private String name;
	@Autowired
	private List<Course> listOfCourses;
	
	//Constructors
	/**
	 * No arg constructor
	 */
	public Student() {
		super();
	}
	/**
	 * @param name
	 */
	public Student(String name) {
		super();
		this.name = name;
	}
	/**
	 * @param name
	 * @param listOfCourses
	 */
	public Student(String name, List<Course> listOfCourses) {
		super();
		this.name = name;
		this.listOfCourses = listOfCourses;
	}
	/**
	 * @param id
	 * @param name
	 * @param listOfCourses
	 */
	public Student(int id, String name, List<Course> listOfCourses) {
		super();
		this.id = id;
		this.name = name;
		this.listOfCourses = listOfCourses;
	}
	
	//Getters and setters
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
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
	 * @return the listOfCourses
	 */
	public List<Course> getListOfCourses() {
		return listOfCourses;
	}
	/**
	 * @param listOfCourses the listOfCourses to set
	 */
	public void setListOfCourses(List<Course> listOfCourses) {
		this.listOfCourses = listOfCourses;
	}
	
	//Helper Methods
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", listOfCourses=" + listOfCourses + "]";
	}
}