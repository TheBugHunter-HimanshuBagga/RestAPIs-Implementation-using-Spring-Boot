package com.HimanshuBagga.github.LearningRESTAPIs.Controller;

import com.HimanshuBagga.github.LearningRESTAPIs.Service.StudentService;
import com.HimanshuBagga.github.LearningRESTAPIs.dto.StudentDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    // Connected controller to Service
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping("/Students")
    public List<StudentDTO> getAllStudent() {
        return studentService.getAllStudents();
    }

    @GetMapping("/Students/{id}/{Name}")
    // {id} path variable
    public String getStudentById(@PathVariable Long id , @PathVariable String Name) {
        // For now, just return dummy data
        return "this is a path Variable "+ id + "The name is: " + Name;
    }
}
