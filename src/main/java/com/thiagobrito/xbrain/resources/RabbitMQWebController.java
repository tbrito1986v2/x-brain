package com.thiagobrito.xbrain.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thiagobrito.xbrain.domain.Pedido;
import com.thiagobrito.xbrain.services.RabbitMQSender;

@RestController
@RequestMapping(value = "/javainuse-rabbitmq/")
public class RabbitMQWebController {

	@Autowired
	RabbitMQSender rabbitMQSender;

	@GetMapping(value = "/producer")
	public String producer(@RequestParam("pedido") Pedido pedido){
		
		rabbitMQSender.send(pedido);
		return "Menssagem enviada com sucesso";
	}

}
