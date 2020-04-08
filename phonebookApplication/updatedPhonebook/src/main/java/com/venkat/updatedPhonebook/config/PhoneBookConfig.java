package com.venkat.updatedPhonebook.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PhoneBookConfig {
	
   @Bean
   public ModelMapper modelMapper(){
	   return new ModelMapper();
   }
}
