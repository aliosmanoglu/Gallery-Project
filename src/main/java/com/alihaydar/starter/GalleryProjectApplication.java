package com.alihaydar.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = {"com.alihaydar"})
@EntityScan(basePackages = {"com.alihaydar"})
@EnableJpaRepositories(basePackages = {"com.alihaydar"} )
@ConfigurationPropertiesScan(basePackages = {"com.alihaydar"})
@SpringBootApplication
public class GalleryProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(GalleryProjectApplication.class, args);
	}

}
