package AssignmentSWE645.HW3.service;

import AssignmentSWE645.HW3.dto.StudentDto;

import java.util.List;

public interface StudentService {

    List<StudentDto> getAllStudent();

    void createStudent(StudentDto student);

    StudentDto getStudentById(Long id);

    void updateStudent(StudentDto studentDto);

    void deleteStudent(Long id);
}
