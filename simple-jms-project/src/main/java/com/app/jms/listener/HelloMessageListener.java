package com.app.jms.listener;

import java.util.UUID;

import javax.jms.JMSException;
import javax.jms.Message;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.app.jms.config.JmsConfig;
import com.app.jms.model.HelloWorldMessage;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class HelloMessageListener {
	private final JmsTemplate jmsTemplate;
	
	
	@JmsListener(destination = JmsConfig.MY_QUEUE)
	public void listen(@Payload HelloWorldMessage helloWorldMessage, MessageHeaders headers, Message message) {
//		System.out.println("I got a message");
//		
//		System.out.println(helloWorldMessage);
	}
	
	@JmsListener(destination = JmsConfig.MY_SEND_RECV_QUEUE)
    public void listenForHello(@Payload HelloWorldMessage helloWorldMessage,
                       @Headers MessageHeaders headers, Message message) throws JMSException {

        HelloWorldMessage payloadMsg = HelloWorldMessage
                .builder()
                .id(UUID.randomUUID())
                .message("World!!")
                .build();

        jmsTemplate.convertAndSend(message.getJMSReplyTo(), payloadMsg);

    }
}
