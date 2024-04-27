package dmacc.controller;
/**
 * @author Mandy Wiedmier
 * @author Jonah Hummel
 * @author Larry Paucar
 * CIS175 - Spring 2024
 * Final Project - CourseCompass
 * Due Date: Apr 30, 2024
 */
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dmacc.beans.Course;
import dmacc.beans.Student;

@Configuration
public class BeanConfig {
	
	
	// Example Beans
	@Bean
	public Course course() {
		Course beanCourse = new Course("CIS175","Java II",3,"Bob Duncan",90.5);
		return beanCourse;
	}
	
	@Bean
	public Student student() {
		Student beanStudent = new Student("John Smith");
		return beanStudent;
	}
	
}
