package org.test.std;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class SantanderTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SantanderTestApplication.class, args);
	}

}
