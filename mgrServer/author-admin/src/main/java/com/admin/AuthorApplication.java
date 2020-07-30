package com.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.admin"})
@MapperScan(basePackages = "com.admin.dao")
public class AuthorApplication {

	public static void main(String[] args) {
		SpringApplication.run( AuthorApplication.class, args);
	}

}

