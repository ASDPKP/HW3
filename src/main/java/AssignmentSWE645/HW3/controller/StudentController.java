package AssignmentSWE645.HW3.controller;

import AssignmentSWE645.HW3.dto.StudentDto;
import AssignmentSWE645.HW3.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //This a handler method for listing students
    @GetMapping("/entries")
    public String listStudents(Model model){
        List<StudentDto> students = studentService.getAllStudent();
        model.addAttribute("students", students);
        return "student_survey";
    }

    //handler method for creating a new survey
    @GetMapping("/")
    public String newStudent(Model model){
        StudentDto studentDto = new StudentDto();
        model.addAttribute("student", studentDto);
        return "new_survey";
    }

    //handler method to store the new survey data into the database.
    @PostMapping("/entries")
    public String saveStudent(@ModelAttribute("student") StudentDto studentDto){
        studentService.createStudent(studentDto);
        return "redirect:/entries";
    }

    //handler method to handle editing of existing surveys
    @GetMapping("/entries/edit/{id}")
    public String editStudent(@PathVariable Long id, Model model){
        StudentDto studentDto = studentService.getStudentById(id);
        model.addAttribute("student", studentDto);
        return "update_survey";
    }

    //handler method to submit updated data into the database
    @PostMapping("/entries/{id}")
    public String updateStudent(@PathVariable Long id, @Valid @ModelAttribute("student") StudentDto studentDto) {
        studentDto.setId(id);
        studentService.updateStudent(studentDto);
        return "redirect:/entries";
    }

    //handler method to delete student survey
    @GetMapping("/entries/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id){
        studentService.deleteStudent(id);
        return "redirect:/entries";
    }

    //handler method to handle the view student request
    @GetMapping("/entries/view/{id}")
    public String viewStudent(@PathVariable("id") Long id, Model model){
        StudentDto studentDto = studentService.getStudentById(id);
        model.addAttribute("student", studentDto);
        return "view_student";
    }
}
