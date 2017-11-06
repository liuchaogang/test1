package com.yonyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class CDRWsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CDRWsApplication.class, args);
	}
}
