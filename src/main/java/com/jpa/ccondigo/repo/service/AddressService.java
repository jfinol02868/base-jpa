package com.jpa.ccondigo.repo.service;

import com.jpa.ccondigo.repo.entity.Address;

import java.util.List;

public interface AddressService {

    public Address createClient(Address address);

    public List<Address> findAll();
}
