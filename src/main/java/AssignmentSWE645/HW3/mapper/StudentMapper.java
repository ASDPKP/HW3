package AssignmentSWE645.HW3.mapper;

import AssignmentSWE645.HW3.dto.StudentDto;
import AssignmentSWE645.HW3.entity.Student;

public class StudentMapper {
    public static StudentDto mapToStudentDto(Student student){
        StudentDto studentDto = new StudentDto(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getEmail(),
                student.getStreetAddress(),
                student.getCity(),
                student.getState(),
                student.getPostalCode(),
                student.getTelephoneNumber(),
                student.getSurveyDate(),
                student.getInterestCause(),
                student.getMostLiked(),
                student.getRecommendation()
        );

        return studentDto;
    }

    public static Student mapToStudent(StudentDto studentDto){
        Student student = new Student(
                studentDto.getId(),
                studentDto.getFirstName(),
                studentDto.getLastName(),
                studentDto.getEmail(),
                studentDto.getStreetAddress(),
                studentDto.getCity(),
                studentDto.getState(),
                studentDto.getPostalCode(),
                studentDto.getTelephoneNumber(),
                studentDto.getSurveyDate(),
                studentDto.getInterestCause(),
                studentDto.getMostLiked(),
                studentDto.getRecommendation()
        );

        return student;
    }
}
