package com.backup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.backup")
public class AuthorBackupApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthorBackupApplication.class, args);
	}

}
