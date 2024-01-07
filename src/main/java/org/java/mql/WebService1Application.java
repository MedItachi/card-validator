package org.java.mql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "org.java.mql" })
public class WebService1Application {

	public static void main(String[] args) {
		SpringApplication.run(WebService1Application.class, args);
	}

}
