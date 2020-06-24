package com.liao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.transaction.jta.JtaAutoConfiguration;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication(exclude = JtaAutoConfiguration.class)
@MapperScan("com.liao.dao")
public class LiaoNioApplication {

	public static void main(String[] args) {
		SpringApplication.run(LiaoNioApplication.class, args);
	}

}
