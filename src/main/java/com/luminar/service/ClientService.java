package com.luminar.service;

import java.util.List;

import com.luminar.entity.Client;

public interface ClientService {

    void addClient(Client client);

    List<Client> getAllClients();
}
