package com.example.demo;

import java.util.List;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consumer.MessageConsumer;

@RestController
@EnableBinding(MessageConsumer.class)
public class MessageController {

	String message;
	
	@StreamListener(target = MessageConsumer.GREETING)
	public void processHelloChannelGreeting(List<String>list) {
		System.out.println(list);
		message = list.toString();
	}
	
	@GetMapping("/data")
	public String findData() {
		return message;
	}
	
	
}
