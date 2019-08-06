package com.thiagobrito.xbrain.services;

import java.util.Optional;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.thiagobrito.xbrain.domain.Cliente;
import com.thiagobrito.xbrain.repositories.ClienteRepository;

@Service
public class RabbitMQSender {

	@Autowired
	private AmqpTemplate amqpTemplate;

	@Value("${javainuse.rabbitmq.exchange}")
	private String exchange;

	@Value("${javainuse.rabbitmq.routingkey}")
	private String routingkey;
	String kafkaTopic = "java_in_use_topic";
	
	@Autowired
	private ClienteRepository repo;

	/*
	 * public void send(Employee company) { amqpTemplate.convertAndSend(exchange,
	 * routingkey, company); System.out.println("Send msg = " + company);
	 * 
	 * }
	 */
	
	public Cliente find(String id) {
		Optional<Cliente> obj = repo.findById(id);
		amqpTemplate.convertAndSend(exchange, routingkey, id);
		System.out.println("Send msg = " + id);
		return obj.orElse(null);
	}

	/*
	 * public void send(Cliente cliente) { amqpTemplate.convertAndSend(exchange,
	 * routingkey, cliente); System.out.println("Send msg = " + cliente);
	 * 
	 * }
	 */

}