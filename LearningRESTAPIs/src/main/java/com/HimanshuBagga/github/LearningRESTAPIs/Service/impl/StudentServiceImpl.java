    package com.HimanshuBagga.github.LearningRESTAPIs.Service.impl;

    import com.HimanshuBagga.github.LearningRESTAPIs.Repository.StudentRepository;
    import com.HimanshuBagga.github.LearningRESTAPIs.Service.StudentService;
    import com.HimanshuBagga.github.LearningRESTAPIs.dto.AddStudentRequestDTO;
    import com.HimanshuBagga.github.LearningRESTAPIs.dto.StudentDTO;
    import com.HimanshuBagga.github.LearningRESTAPIs.entity.Student;
    import lombok.RequiredArgsConstructor;
    import org.modelmapper.ModelMapper;
    import org.springframework.stereotype.Service;

    import java.util.List;
    import java.util.Map;

    @Service
    @RequiredArgsConstructor
    public class StudentServiceImpl implements StudentService {

        private final StudentRepository studentRepository;
        private final ModelMapper modelMapper;
    //    public StudentServiceImpl(StudentRepository studentRepository) {
    //        this.studentRepository = studentRepository;
    //    }



        @Override
        public StudentDTO getStudentById(Long id) {
            Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not found with in the ID: " + id));
            // since i need to return the StudentDTO by its returing the Student so instead of creating writing studentDTO code i will use {modelmapper}
           return  modelMapper.map(student, StudentDTO.class);
        }

        @Override
        public List<StudentDTO> getAllStudents() {
            List<Student> students = studentRepository.findAll();
            return students.stream()
                    .map(student -> new StudentDTO(student.getId(), student.getName(), student.getEmail()))
                    .toList();
        }

        @Override
        public StudentDTO createNewStudent(AddStudentRequestDTO addStudentRequestDTO) {
            Student newStudent = modelMapper.map(addStudentRequestDTO,Student.class);
            Student student = studentRepository.save(newStudent); // to save in database

            return modelMapper.map(student,StudentDTO.class);
        }

        @Override
        public void deleteStudentById(Long id) {
            if(!studentRepository.existsById(id)){
                throw new IllegalArgumentException("Student Does Not Exists via ID: " + id);
            }
            studentRepository.deleteById(id);
        }

        @Override
        public StudentDTO updateStudent(Long id, AddStudentRequestDTO addStudentRequestDTO) {
            Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not found with in the ID: " + id));
            modelMapper.map(addStudentRequestDTO, student);

            student = studentRepository.save(student);
            return modelMapper.map(student , StudentDTO.class);
        }

        @Override
        public StudentDTO updatePartialStudent(Long id, Map<String, Object> updates) {
            Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not found with in the ID: " + id));
            updates.forEach( (field, value) -> {
                switch(field){
                    case "name" : student.setName((String) value); break;
                    case "email" : student.setEmail((String) value); break;
                    default : throw new IllegalArgumentException("Feild is not Supported");
                }
            });
            Student savedStudent= studentRepository.save(student);
            return modelMapper.map(savedStudent, StudentDTO.class);
        }

        // what if inside the email if a person inputs wrong pattern of an email like xyz.com instead of xyz@gmail.com to resolve this we will use a (validation) dependency in pom.xml
    }
