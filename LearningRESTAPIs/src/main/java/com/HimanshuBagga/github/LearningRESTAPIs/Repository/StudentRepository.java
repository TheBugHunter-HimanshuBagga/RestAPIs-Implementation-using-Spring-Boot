package com.HimanshuBagga.github.LearningRESTAPIs.Repository;

import com.HimanshuBagga.github.LearningRESTAPIs.Service.StudentService;
import com.HimanshuBagga.github.LearningRESTAPIs.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
