package dmacc.Repository;
/**
 * @author Mandy Wiedmier
 * @author Jonah Hummel
 * @author Larry Paucar
 * CIS175 - Spring 2024
 * Final Project - CourseCompass
 * Due Date: Apr 30, 2024
 */


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dmacc.beans.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
