package com.HimanshuBagga.github.LearningRESTAPIs.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Student {  // ORM - Object Relational Mapping by Hibernate

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // must be lowercase for consistency

    private String name;
    private String email;
}
