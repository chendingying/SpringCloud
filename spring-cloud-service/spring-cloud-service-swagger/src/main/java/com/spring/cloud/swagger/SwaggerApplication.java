package com.spring.cloud.swagger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * Hello world!
 *
 */
@EnableCaching
@SpringBootApplication
public class SwaggerApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SwaggerApplication.class, args);
    }
	
}
