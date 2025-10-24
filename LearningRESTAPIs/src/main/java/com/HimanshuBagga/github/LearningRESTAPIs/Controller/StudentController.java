package com.HimanshuBagga.github.LearningRESTAPIs.Controller;

import com.HimanshuBagga.github.LearningRESTAPIs.Service.StudentService;
import com.HimanshuBagga.github.LearningRESTAPIs.dto.AddStudentRequestDTO;
import com.HimanshuBagga.github.LearningRESTAPIs.dto.StudentDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class StudentController {

    // Connected controller to Service
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

// Response Entity - returns the status code for the following rest api
    @GetMapping("/Students")
    public ResponseEntity<List<StudentDTO>> getAllStudent() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(studentService.getAllStudents());
    }

//    @GetMapping("/Students/{id}/{Name}")
//    // {id} path variable
//    public String getStudentById(@PathVariable Long id , @PathVariable String Name) {
//        // For now, just return dummy data
//        return "This is a path Variable "+ id + " The name is: " + Name;
//    }
@GetMapping("/Students/{id}")
// {id} path variable
public StudentDTO getStudentById(@PathVariable Long id) {
    // For now, just return dummy data
    return ResponseEntity.ok(studentService.getStudentById(id)).getBody();
}

    @PostMapping
    public ResponseEntity<StudentDTO> createNewStudent(@RequestBody @Valid AddStudentRequestDTO addStudentRequestDTO) {
        StudentDTO createdStudent = studentService.createNewStudent(addStudentRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAStudent(@PathVariable Long id){

        studentService.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }
    // controller -> StudentService.java -> StudentServiceImpl.java -> repository

    // Put Mapping - full change
    // patch Mapping - change a part of code

    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> updateStudent(@PathVariable Long id , @RequestBody @Valid AddStudentRequestDTO addStudentRequestDTO){
        return ResponseEntity.ok(studentService.updateStudent(id, addStudentRequestDTO));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<StudentDTO> updatePartialStudent(@PathVariable Long id , @RequestBody Map<String , Object> updates){
        return ResponseEntity.ok(studentService.updatePartialStudent(id, updates));
    }

}
