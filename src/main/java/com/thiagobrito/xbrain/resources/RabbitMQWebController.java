package com.thiagobrito.xbrain.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.thiagobrito.xbrain.domain.Cliente;
import com.thiagobrito.xbrain.services.RabbitMQSender;

@RestController
@RequestMapping(value = "/javainuse-rabbitmq/")
public class RabbitMQWebController {

	@Autowired
	RabbitMQSender rabbitMQSender;


	/*
	 * @GetMapping(value = "/producer") public String
	 * producer(@RequestParam("empName") String empName, @RequestParam("empId")
	 * String empId) {
	 * 
	 * Employee emp = new Employee(); emp.setEmpId(empId); emp.setEmpName(empName);
	 * rabbitMQSender.send(emp);
	 * 
	 * return "Message sent to the RabbitMQ JavaInUse Successfully"; }
	 */
	
	@RequestMapping(value = "/{id}",method=RequestMethod.GET)
	public ResponseEntity<?>  find(@PathVariable String id) {
		Cliente obj = rabbitMQSender.find(id); 
		return ResponseEntity.ok().body(obj);
	}

	/*
	 * @GetMapping(value = "/producer") public String producer(@RequestParam("id")
	 * String id,
	 * 
	 * @RequestParam("nome") String nome,
	 * 
	 * @RequestParam("email") String email,
	 * 
	 * @RequestParam("cpfOuCnpj") String cpfOuCnpj) {
	 * 
	 * Cliente cliente = new Cliente(); cliente.setId(id); ; cliente.setNome(nome);
	 * cliente.setEmail(email); cliente.setCpfOuCnpj(cpfOuCnpj);
	 * rabbitMQSender.send(cliente);
	 * 
	 * return "Message sent to the RabbitMQ JavaInUse Successfully"; }
	 */

}
