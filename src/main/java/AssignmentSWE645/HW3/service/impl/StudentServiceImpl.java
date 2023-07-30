package AssignmentSWE645.HW3.service.impl;

import AssignmentSWE645.HW3.dto.StudentDto;
import AssignmentSWE645.HW3.entity.Student;
import AssignmentSWE645.HW3.mapper.StudentMapper;
import AssignmentSWE645.HW3.repository.SurveyRepository;
import AssignmentSWE645.HW3.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private SurveyRepository surveyRepository;

    public StudentServiceImpl(SurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    }

    @Override
    public List<StudentDto> getAllStudent() {
        List<Student> students = surveyRepository.findAll();
        List<StudentDto> studentDtos = students.stream().map(student -> StudentMapper.mapToStudentDto(student)).collect(Collectors.toList());
        return studentDtos;
    }

    @Override
    public void createStudent(StudentDto studentDto) {
        Student student = StudentMapper.mapToStudent((studentDto));
        surveyRepository.save(student);
    }

    @Override
    public StudentDto getStudentById(Long id) {
        Student student = surveyRepository.findById(id).get();
        StudentDto studentDto = StudentMapper.mapToStudentDto(student);
        return studentDto;
    }

    @Override
    public void updateStudent(StudentDto studentDto) {
        surveyRepository.save(StudentMapper.mapToStudent(studentDto));
    }

    @Override
    public void deleteStudent(Long id) {
        surveyRepository.deleteById(id);
    }


}
