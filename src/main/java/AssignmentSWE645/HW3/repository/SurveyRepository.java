package AssignmentSWE645.HW3.repository;

import AssignmentSWE645.HW3.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyRepository extends JpaRepository<Student, Long> {

}
