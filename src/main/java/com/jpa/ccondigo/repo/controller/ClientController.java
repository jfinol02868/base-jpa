package com.jpa.ccondigo.repo.controller;

import com.jpa.ccondigo.repo.entity.Client;
import com.jpa.ccondigo.repo.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/clients")
public class ClientController {

    private final ClientService clientService;

    @PostMapping("/create")
    public ResponseEntity<Client> getAllClients(@RequestBody Client client) {
        return new ResponseEntity<>(clientService.createClient(client), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Client>> findAll() {
        return new ResponseEntity<>(clientService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clientService.deleteClient(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> update(@PathVariable Long id, @RequestBody Client client ) {
        return new ResponseEntity<>(clientService.updateClient(client, id), HttpStatus.CREATED);
    }

    @DeleteMapping("/{clientId}/address/{addressId}")
    public ResponseEntity<Client> updateAddress(
            @PathVariable(name = "clientId") Long clientId,
            @PathVariable(name = "addressId") Long addressId) {
        return new ResponseEntity<>(clientService.updateAddress(clientId, addressId), HttpStatus.OK);
    }
}
