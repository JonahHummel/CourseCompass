package dmacc.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dmacc.beans.Student;

/**
 * Larry Paucar - Lpaucar
 * CIS175 -Spring 2024
 * Apr 10, 2024
 */
public interface StudentRepository extends JpaRepository<Student, Long> {

}
