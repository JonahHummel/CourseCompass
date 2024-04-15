package dmacc.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dmacc.beans.Course;
import dmacc.beans.Student;

@Configuration
public class BeanConfig {
	
	@Bean
	public Course course() {
		Course beanCourse = new Course("CIS175","Java II",3,"Louie Schanus",90.5,false);
		return beanCourse;
	}
	
	@Bean
	public Student student() {
		Student beanStudent = new Student("John Smith");
		return beanStudent;
	}
	
}
