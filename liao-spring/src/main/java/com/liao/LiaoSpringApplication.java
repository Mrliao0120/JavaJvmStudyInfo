package com.liao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


import java.beans.Transient;

@SpringBootApplication
@EnableAspectJAutoProxy
public class LiaoSpringApplication {

	public static void main(String[] args) {
		LiaoSpringApplication.class.notify();
		SpringApplication.run(LiaoSpringApplication.class, args);
	}



}
