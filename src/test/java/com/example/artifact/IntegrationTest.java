package com.example.artifact;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;

import org.assertj.core.api.Assertions;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class IntegrationTest {
	
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testName() throws Exception{
		//arrange
		
		//act
		ResponseEntity<Car> response = 
				restTemplate.getForEntity("/cars/Subaru", Car.class);
		
		//assert
		Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		Assertions.assertThat(response.getBody().getName()).isEqualTo("Subaru");
		Assertions.assertThat(response.getBody().getType()).isEqualTo("Impreza");
	}

}
