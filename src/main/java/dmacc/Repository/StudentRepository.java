package dmacc.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dmacc.beans.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
