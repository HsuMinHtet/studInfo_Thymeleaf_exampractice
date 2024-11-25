package edu.miu.cse.sms.service;

import edu.miu.cse.sms.dto.request.StudentRequestDTO;
import edu.miu.cse.sms.dto.response.StudentResponseDTO;

import java.util.List;

public interface StudentService {
    List<StudentResponseDTO> getAllStudents();
    StudentResponseDTO getStudentByRegisterNumber(String registerNumber);
    StudentResponseDTO createStudent(StudentRequestDTO studentRequestDTO);
}
