package com.jpa.ccondigo.repo.repository;

import com.jpa.ccondigo.repo.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
