package com.kr.vikash.rabbitmqapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kr.vikash.rabbitmqapplication.producer.ProductProducer;

@RestController
@RequestMapping("/api/producer")
public class ProductController {
	
	@Autowired
	private ProductProducer producer;
	
	   @PostMapping
	    public ResponseEntity<String> produceMessage(@RequestBody String message) {
		   producer.produceMessage(message);
		   return ResponseEntity.ok("Message Sent");
	    }
	   
//	   @PostMapping("/{productName}")
//	    public ResponseEntity<String> produceMessage(@RequestBody String message) {
//		   producer.produceMessage(message);
//		   return ResponseEntity.ok("Message Sent");
//	    }
}
