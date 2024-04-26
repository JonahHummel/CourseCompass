package dmacc.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dmacc.beans.Student;

/**
 * Larry Paucar - Lpaucar
 * CIS175 -Spring 2024
 * Apr 10, 2024
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
