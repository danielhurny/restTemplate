package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.Module;

import javaslang.jackson.datatype.JavaslangModule;


@Configuration
@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);

	}
	
	 @Bean
	 public Module jacksonBuilder() {
	  return new JavaslangModule();
	 }
}
