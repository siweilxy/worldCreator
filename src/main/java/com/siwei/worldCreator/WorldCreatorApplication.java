package com.siwei.worldCreator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WorldCreatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorldCreatorApplication.class, args);
		Generator generator = new Generator();
		generator.run();
	}
}
