package com.MyPosts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;



@EnableAutoConfiguration
@SpringBootApplication

public class MyPostsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyPostsApplication.class, args);
	}

}
