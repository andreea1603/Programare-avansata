package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class Compulsory implements CommandLineRunner {


	@Autowired
	private JdbcTemplate jdbcTemplate;
	public static void main(String[] args) {
		SpringApplication.run(Compulsory.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String sql="insert into person values ('testValue')";

		int result=jdbcTemplate.update(sql);
		if(result>0){
			System.out.println("inserare");
		}
	}
}
