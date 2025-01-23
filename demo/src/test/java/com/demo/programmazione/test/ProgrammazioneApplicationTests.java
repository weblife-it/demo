package com.demo.programmazione.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import com.demo.programmazione.ProgrammazioneApplication;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProgrammazioneApplicationTests {

	  @Autowired
	  private TestRestTemplate restTemplate;
	
	@Test
	void contextLoads() {
		
		ResponseEntity<String> response = restTemplate.getForEntity("/demo", String.class);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(ProgrammazioneApplication.INFO, response.getBody());
		
	}

}