package com.example.provider.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.provider.models.Client;

@RestController
@RequestMapping("/api/v1/")
public class ClientController {

	@RequestMapping(value="clients", method=RequestMethod.GET)
	public List<Client> list() {
		return ClientStub.list();
	}
	
	@RequestMapping(value = "clients", method = RequestMethod.POST)
	public Client create(@RequestBody Client client) {
		return ClientStub.create(client);
	}

	@RequestMapping(value = "clients/{id}", method = RequestMethod.GET)
	public Client get(@PathVariable Long id) {
		return ClientStub.get(id);
	}

	@RequestMapping(value = "clients/{id}", method = RequestMethod.PUT)
	public Client update(@PathVariable Long id, @RequestBody Client client) {
		return ClientStub.update(id, client);
	}

	@RequestMapping(value = "clients/{id}", method = RequestMethod.DELETE)
	public Client delete(@PathVariable Long id) {
		return ClientStub.delete(id);
	}	
}
