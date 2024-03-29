package com.thiagobrito.xbrain.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thiagobrito.xbrain.domain.Cliente;
import com.thiagobrito.xbrain.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;

	public Cliente find(String id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElse(null);
	}
}
