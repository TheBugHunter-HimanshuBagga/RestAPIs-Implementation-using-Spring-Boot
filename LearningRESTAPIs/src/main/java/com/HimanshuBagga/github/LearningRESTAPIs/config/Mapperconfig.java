package com.HimanshuBagga.github.LearningRESTAPIs.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // we will create beans of diffrent class inside this config class
public class Mapperconfig {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
