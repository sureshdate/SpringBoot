package com.springboot.first.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootWarDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootWarDemoApplication.class, args);
	}

}
//when u creae sprinngboot project in war then we see 3 difference
//1st is added tomcat server in pom file with scope as provided and war packaging added in tomcat
//2nd is its provided servletInitializer.
//after running ap war file is created target folder