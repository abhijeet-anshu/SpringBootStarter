package com.publisher;

import org.springframework.cloud.stream.annotation.Output;

import org.springframework.messaging.MessageChannel;

public interface UserPublisher {

	  @Output("messages")
	    MessageChannel publishMessage();
	
}
