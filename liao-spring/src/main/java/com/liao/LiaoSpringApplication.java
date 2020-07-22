package com.liao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;


import java.beans.Transient;

@SpringBootApplication
//@EnableAspectJAutoProxy
//@EnableTransactionManagement
public class LiaoSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(LiaoSpringApplication.class, args);
	}



}
