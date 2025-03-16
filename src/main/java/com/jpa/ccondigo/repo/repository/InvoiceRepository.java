package com.jpa.ccondigo.repo.repository;

import com.jpa.ccondigo.repo.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
