package com.jpa.ccondigo.repo.service;

import com.jpa.ccondigo.repo.entity.Address;
import com.jpa.ccondigo.repo.repository.AddressRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository repository;

    @Override
    @Transactional
    public Address createClient(Address address) {
        return repository.save(address);
    }

    @Override
    @Transactional
    public List<Address> findAll() {
        return repository.findAll();
    }
}
