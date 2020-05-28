package com.liao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;

@SpringBootApplication

public class LiaoSpringApplication {

	public static void main(String[] args) {
		LiaoSpringApplication.class.notify();
		SpringApplication.run(LiaoSpringApplication.class, args);
	}

}
