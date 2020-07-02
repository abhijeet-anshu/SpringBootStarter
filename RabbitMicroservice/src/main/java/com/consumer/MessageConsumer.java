package com.consumer;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface MessageConsumer {

	String GREETING = "greetingChannel";

	@Input(GREETING)
	SubscribableChannel greeting();
}
