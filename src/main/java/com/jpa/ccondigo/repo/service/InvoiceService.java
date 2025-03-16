package com.jpa.ccondigo.repo.service;

import com.jpa.ccondigo.repo.entity.Invoice;

import java.util.List;

public interface InvoiceService {

    public Invoice createInvoice(Invoice invoice);

    public List<Invoice> findAll();

    void deleteInvoice(Long id);
}