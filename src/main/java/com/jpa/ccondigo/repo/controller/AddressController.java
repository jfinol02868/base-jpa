package com.jpa.ccondigo.repo.controller;

import com.jpa.ccondigo.repo.entity.Address;
import com.jpa.ccondigo.repo.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/address")
public class AddressController {

    private final AddressService addressService;

    @PostMapping("/create")
    public ResponseEntity<Address> getAllClients(@RequestBody Address address) {
        return new ResponseEntity<>(addressService.createClient(address), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Address>> findAll() {
        return new ResponseEntity<>(addressService.findAll(), HttpStatus.OK);
    }
}
