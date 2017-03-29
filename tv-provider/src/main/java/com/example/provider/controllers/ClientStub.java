package com.example.provider.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.provider.models.Client;

public class ClientStub {
	
	private static Map<Long, Client> clients = new HashMap<Long, Client>();
	private static Long idIndex = 3L;

	//populate initial clients
	static {
		Client a = new Client(1L, "Adam Smith", "smith@example.com");
		clients.put(1L, a);
		Client b = new Client(2L, "Mary Linn", "linn@example.com");
		clients.put(2L, b);
		Client c = new Client(3L, "David Brown", "brown@example.com");
		clients.put(3L, c);
	}

	public static List<Client> list() {
		return new ArrayList<Client>(clients.values());
	}
	
	public static Client create(Client client) {
		idIndex += idIndex;
		client.setId(idIndex);
		clients.put(idIndex, client);
		return client;
	}
	
	public static Client get(Long id) {
		return clients.get(id);
	}

	public static Client update(Long id, Client client) {
		clients.put(id, client);
		return client;
	}

	public static Client delete(Long id) {
		return clients.remove(id);
	}
}
