package edu.miu.cse.sms.service.impl;

import edu.miu.cse.sms.dto.request.StudentRequestDTO;
import edu.miu.cse.sms.dto.response.StudentResponseDTO;
import edu.miu.cse.sms.model.Student;
import edu.miu.cse.sms.repository.StudentRepository;
import edu.miu.cse.sms.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    @Override
    public List<StudentResponseDTO> getAllStudents() {
        //Write your code here
        List<Student> students = studentRepository.findAll();
        List<StudentResponseDTO> studentResponseDTOS = new ArrayList<>();
        for (Student student : students) {
            studentResponseDTOS.add(convertToResponseDTO(student));
        }
        return studentResponseDTOS;
    }

    @Override
    public StudentResponseDTO getStudentByRegisterNumber(String registerNumber) {
        //Write your code here
        Optional<Student> student = studentRepository.findByRegisterNumber(registerNumber);
        if (student.isPresent()) {
            Student foundStudent = student.get();
            return convertToResponseDTO(foundStudent);
        }
        return null;
    }

    @Override
    public StudentResponseDTO createStudent(StudentRequestDTO studentRequestDTO) {
        //Write your code here
        Student student = new Student(studentRequestDTO.name(),studentRequestDTO.registerNumber(),studentRequestDTO.email(),studentRequestDTO.phone());
        Student saveStudent=studentRepository.save(student);
        return convertToResponseDTO(saveStudent);
    }

    private StudentResponseDTO convertToResponseDTO(Student student) {
        //Write your code here
        return  new StudentResponseDTO(
                student.getName(),
                student.getRegisterNumber(),
                student.getEmail(),
                student.getPhone());
    }
}
