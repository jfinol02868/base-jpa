package com.jpa.ccondigo.repo.service;

import com.jpa.ccondigo.repo.entity.Address;
import com.jpa.ccondigo.repo.entity.Client;
import com.jpa.ccondigo.repo.repository.AddressRepository;
import com.jpa.ccondigo.repo.repository.ClientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final AddressRepository addressRepository;
    private final ClientRepository clientRepository;

    @Override
    @Transactional
    public Client createClient(Client client) {
        List<Address> addresses = client.getAddressesId().stream().map(
                a -> addressRepository.findById(a).orElseThrow(() -> new RuntimeException("Address not found"))
        ).toList();
        client.setAddresses(addresses);
        return clientRepository.save(client);
    }

    @Override
    public Client updateClient(Client client, Long id) {
        Client client1 = clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Client not found"));
        BeanUtils.copyProperties(client, client1, "id");
        List<Address> addresses = addressRepository.findAllById(client.getAddressesId());
        client1.setAddresses(addresses);
        return clientRepository.save(client1);
    }

    @Override
    @Transactional
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Client updateAddress(Long clientId, Long addressId) {
        Address address = addressRepository.findById(addressId).orElseThrow(() -> new RuntimeException("Address not found"));
        Client client = clientRepository.findById(clientId).orElseThrow(() -> new RuntimeException("Client not found"));
        client.getAddresses().remove(address);
        return clientRepository.save(client);
    }
}
