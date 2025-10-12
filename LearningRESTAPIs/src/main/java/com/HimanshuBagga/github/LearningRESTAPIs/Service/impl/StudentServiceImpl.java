package com.HimanshuBagga.github.LearningRESTAPIs.Service.impl;

import com.HimanshuBagga.github.LearningRESTAPIs.Repository.StudentRepository;
import com.HimanshuBagga.github.LearningRESTAPIs.Service.StudentService;
import com.HimanshuBagga.github.LearningRESTAPIs.dto.StudentDTO;
import com.HimanshuBagga.github.LearningRESTAPIs.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream()
                .map(student -> new StudentDTO(student.getId(), student.getName(), student.getEmail()))
                .toList();
    }
}
