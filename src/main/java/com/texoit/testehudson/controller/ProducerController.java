package com.texoit.testehudson.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.texoit.testehudson.dto.AwardResponse;
import com.texoit.testehudson.service.ProducerService;

@RestController
@RequestMapping("/producers")
public class ProducerController {

	@Autowired
	private ProducerService producerService;
	
	@GetMapping("/awards")
	public ResponseEntity<AwardResponse> getProducersAwards(){
		AwardResponse response = new AwardResponse();
		response = producerService.getProducerAwards();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}