package dmacc.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dmacc.beans.Course;
import dmacc.beans.Student;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
	List<Course> findByStudentAndIsCompletedFalse(Student student);
}
