package com.texoit.testehudson;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.texoit.testehudson.domain.Movie;
import com.texoit.testehudson.dto.AwardResponse;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TestehudsonApplicationTests {

	@LocalServerPort
    private int port;
	
    @Autowired
    private TestRestTemplate restTemplate;
	
	private static final String HOST = "http://localhost:";
	private static final String PRODUCER = "/testehudson-api/producers";
	private static final String MOVIES = "/testehudson-api/movie";
	
	@Test
	public void testAwardsProducer() {
		ResponseEntity<AwardResponse> responseEntity = restTemplate.getForEntity(HOST + port + PRODUCER + "/awards", AwardResponse.class);
        Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
        Assert.assertNotNull(responseEntity.getBody());
        Assert.assertNotNull(responseEntity.getBody().getMax());
        Assert.assertNotNull(responseEntity.getBody().getMin());
	}

	@Test
	public void testFindAllMovie() {
		ResponseEntity<List> responseEntity = restTemplate.getForEntity(HOST + port + MOVIES + "/movies", List.class);
		Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
        Assert.assertNotNull(responseEntity.getBody());
	}
	
	@Test
	public void testFindMovieById() {
		ResponseEntity<Movie> responseEntity = restTemplate.getForEntity(HOST + port + MOVIES + "/find/1", Movie.class);
		Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
        Assert.assertNotNull(responseEntity.getBody());
	}
	
	
}
