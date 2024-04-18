package dmacc.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dmacc.beans.Course;
import dmacc.beans.Student;

/**
 * Jonah Hummel - jdhummel2
 * CIS175 - Spring 2024
 * Apr 10, 2024
 */
public interface CourseRepository extends JpaRepository<Course, Long> {
	List<Course> findByStudentAndIsCompletedFalse(Student student);
}
