package edu.miu.cse.sms.controller;

import edu.miu.cse.sms.dto.request.StudentRequestDTO;
import edu.miu.cse.sms.dto.response.StudentResponseDTO;
import edu.miu.cse.sms.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public String getAllStudents(Model model) {
        List<StudentResponseDTO> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "students"; // Name of the Thymeleaf template
    }

    @GetMapping("/{register_number}")
    public String getStudentByRegisterNumber(@PathVariable(value = "register_number") String registerNumber, Model model) {
        StudentResponseDTO student = studentService.getStudentByRegisterNumber(registerNumber);
        model.addAttribute("student", student);
        return "student-details"; // Name of the Thymeleaf template
    }

    @GetMapping("/new")
    public String showCreateStudentForm(Model model) {
        model.addAttribute("student", new StudentRequestDTO(null, null, null, null));
        return "create-student"; // Name of the Thymeleaf template
    }

    @PostMapping
    public String createStudent(@ModelAttribute StudentRequestDTO studentRequestDTO) {
        studentService.createStudent(studentRequestDTO);
        return "redirect:/api/v1/students";
    }

}
