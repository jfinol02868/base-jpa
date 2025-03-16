package com.jpa.ccondigo.repo.repository;

import com.jpa.ccondigo.repo.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}