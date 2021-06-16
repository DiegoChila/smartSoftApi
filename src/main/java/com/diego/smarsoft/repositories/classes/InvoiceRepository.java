package com.diego.smarsoft.repositories.classes;

import com.diego.smarsoft.models.entities.Invoice;
import com.diego.smarsoft.repositories.crud.InvoiceCrudRepository;
import com.diego.smarsoft.repositories.interfaces.InvoiceRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class InvoiceRepository implements InvoiceRepositoryInterface {
    @Autowired
    private InvoiceCrudRepository invoiceCrudRepository;

    @Override
    public List<Invoice> getAll() {
        return (List<Invoice>) invoiceCrudRepository.findAll();
    }

    @Override
    public Invoice save(Invoice invoice) {
        return invoiceCrudRepository.save(invoice);
    }

    @Override
    public List<Invoice> findByIdClient(Long idClient) {
        return invoiceCrudRepository.findByIdClient(idClient);
    }

    @Override
    public Optional<Invoice> findById(Long id) {
        return invoiceCrudRepository.findById(id);
    }
}
