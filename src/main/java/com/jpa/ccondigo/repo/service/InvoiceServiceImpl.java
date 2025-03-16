package com.jpa.ccondigo.repo.service;

import com.jpa.ccondigo.repo.entity.Client;
import com.jpa.ccondigo.repo.entity.Invoice;
import com.jpa.ccondigo.repo.repository.ClientRepository;
import com.jpa.ccondigo.repo.repository.InvoiceRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService{

    private final ClientRepository clientRepository;
    private final InvoiceRepository invoiceRepository;

    @Override
    @Transactional
    public Invoice createInvoice(Invoice invoice) {
        Client client = clientRepository.findById(invoice.getIdClient())
                .orElseThrow(() -> new RuntimeException("Client not found"));
        invoice.setClient(client);
        return invoiceRepository.save(invoice);
    }

    @Override
    @Transactional
    public List<Invoice> findAll() {
        return invoiceRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteInvoice(Long id) {
        invoiceRepository.deleteById(id);
    }
}
