package com.example.demo;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.publisher.UserPublisher;

@RestController
@EnableBinding(UserPublisher.class)
public class MyMessagePublisher {
	@Autowired
	UserPublisher publisher;
	
	
	@GetMapping("/publish")
	public String sendMessage() {
		List<String>list=Arrays.asList("one","two","three");
		publisher.publishMessage().send(MessageBuilder.withPayload(list).build());
		return "done";
	}

}


