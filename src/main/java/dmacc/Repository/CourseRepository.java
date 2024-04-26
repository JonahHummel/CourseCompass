package dmacc.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dmacc.beans.Course;
import dmacc.beans.Student;

/**
 * Jonah Hummel - jdhummel2
 * CIS175 - Spring 2024
 * Apr 10, 2024
 */
@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
	List<Course> findByStudentAndIsCompletedFalse(Student student);
}
