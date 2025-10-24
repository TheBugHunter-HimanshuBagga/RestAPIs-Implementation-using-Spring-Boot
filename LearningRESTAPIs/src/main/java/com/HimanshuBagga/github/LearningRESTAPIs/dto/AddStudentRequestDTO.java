package com.HimanshuBagga.github.LearningRESTAPIs.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jdk.jfr.Name;
import lombok.Data;

@Data
public class AddStudentRequestDTO {
    // validation
    @NotBlank(message = "Name is required")
    @Size(min = 6  , max = 25 , message = "Name should be of length 6 to 25 char")
    private String name;
    @Email
    @NotBlank(message = "Email is required")// validation
    private String email;
}
