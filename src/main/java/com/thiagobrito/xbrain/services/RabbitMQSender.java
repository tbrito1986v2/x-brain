package com.thiagobrito.xbrain.services;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.thiagobrito.xbrain.domain.Pedido;

@Service
public class RabbitMQSender {

	@Autowired
	private AmqpTemplate amqpTemplate;

	@Value("${javainuse.rabbitmq.exchange}")
	private String exchange;

	@Value("${javainuse.rabbitmq.routingkey}")
	private String routingkey;
	String kafkaTopic = "java_in_use_topic";
		
	  public void send(Pedido pedido) { amqpTemplate.convertAndSend(exchange,
	  routingkey, pedido); System.out.println("Send msg = " + pedido);
	  
	  }
	 

}