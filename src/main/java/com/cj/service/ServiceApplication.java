package com.cj.service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cj.service.mapper")
public class ServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(ServiceApplication.class, args);
	}

}
