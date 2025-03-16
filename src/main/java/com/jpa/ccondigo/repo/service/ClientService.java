package com.jpa.ccondigo.repo.service;

import com.jpa.ccondigo.repo.entity.Client;

import java.util.List;

public interface ClientService {

    Client createClient(Client client);

    Client updateClient(Client client, Long id);

    List<Client> findAll();

    void deleteClient(Long id);

    Client updateAddress(Long clientId, Long addressId);
}
