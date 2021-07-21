package org.santander.test.santander;

import org.apache.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.test.std.models.Price;

@SpringBootApplication
public class SantanderTestAppClient implements CommandLineRunner {

	final static Logger logger = Logger.getLogger(SantanderTestAppClient.class);

	public static void main(String[] args) {
		new SpringApplicationBuilder(SantanderTestAppClient.class).web(WebApplicationType.NONE).run(args);
	}

	@Override
	public void run(String... args) throws Exception {
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<Price[]> responseEntity = restTemplate
				.getForEntity("http://localhost:8080/SantanderTest/price/getStockPrices", Price[].class);
		Price[] priceArray = responseEntity.getBody();

		for (int i = 0; i < priceArray.length; i++) {
			logger.info(priceArray[i]);

		}

	}
}
