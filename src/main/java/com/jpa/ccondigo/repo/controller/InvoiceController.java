package com.jpa.ccondigo.repo.controller;

import com.jpa.ccondigo.repo.entity.Client;
import com.jpa.ccondigo.repo.entity.Invoice;
import com.jpa.ccondigo.repo.service.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/invoices")
public class InvoiceController {

    private final InvoiceService clientService;

    @PostMapping("/create")
    public ResponseEntity<Invoice> getAllClients(@RequestBody Invoice invoice) {
        return new ResponseEntity<>(clientService.createInvoice(invoice), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Invoice>> findAll() {
        return new ResponseEntity<>(clientService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> findAll(@PathVariable Long id) {
        clientService.deleteInvoice(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
