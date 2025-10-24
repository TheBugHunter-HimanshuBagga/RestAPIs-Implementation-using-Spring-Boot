package com.HimanshuBagga.github.LearningRESTAPIs.Service;

import com.HimanshuBagga.github.LearningRESTAPIs.dto.AddStudentRequestDTO;
import com.HimanshuBagga.github.LearningRESTAPIs.dto.StudentDTO;
import java.util.List; // ✅ Added import
import java.util.Map;

public interface StudentService {


    List<StudentDTO> getAllStudents();

    StudentDTO getStudentById(Long id);

    StudentDTO createNewStudent(AddStudentRequestDTO addStudentRequestDTO);

    void deleteStudentById(Long id);

    StudentDTO updateStudent(Long id , AddStudentRequestDTO addStudentRequestDTO);


    StudentDTO updatePartialStudent(Long id, Map<String, Object> updates);
}

