package com.HimanshuBagga.github.LearningRESTAPIs.Service;

import com.HimanshuBagga.github.LearningRESTAPIs.dto.StudentDTO;
import java.util.List; // ✅ Added import

public interface StudentService {
    List<StudentDTO> getAllStudents();
}
