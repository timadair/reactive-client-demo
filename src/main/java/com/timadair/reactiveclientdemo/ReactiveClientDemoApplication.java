package com.timadair.reactiveclientdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReactiveClientDemoApplication {

	public static void main(String[] args) {
		System.getProperties().put("server.port", 8081);
		SpringApplication.run(ReactiveClientDemoApplication.class, args);
	}
}
