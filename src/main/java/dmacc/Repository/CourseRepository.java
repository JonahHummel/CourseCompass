package dmacc.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dmacc.beans.Course;

/**
 * Jonah Hummel - jdhummel2
 * CIS175 - Spring 2024
 * Apr 10, 2024
 */
public interface CourseRepository extends JpaRepository<Course, Long> {

}
