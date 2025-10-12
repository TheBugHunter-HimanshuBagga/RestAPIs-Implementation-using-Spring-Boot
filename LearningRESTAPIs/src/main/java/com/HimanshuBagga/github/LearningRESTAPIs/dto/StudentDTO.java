// all request will go to the controller after that it will create its model by using services , services will then use repository and entity to generate model wich is then sent back to controller

// (Client Request) -->{ presentation Layer }--> {Service Layer} --> {Persistance Layer} this connects to the database
//                                          DTO->               Entity->
//                                          <-DTO               <-Entity
//(convertsToJson for results)<---
// DTO - data transfer object consists of only getters and setters and feilds
// Student Management System
package com.HimanshuBagga.github.LearningRESTAPIs.dto;

import lombok.Data;

@Data
public class StudentDTO {
    private Long Id;
    private String name;
    private String Email;

    public StudentDTO(Long Id,String name,String Email){
        this.Id=Id;
        this.name=name;
        this.Email=Email;
    }

    public StudentDTO(Long ID) {
        this.Id = Id;
    }

    public StudentDTO() {
    }

    public Long getID() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return Email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setID(Long ID) {
        this.Id = Id;
    }

    public void setEmail(String email) {
        Email = email;
    }
    // no need to write the above code just write @Data it itself create all this
}
