package com.diego.smarsoft.repositories.interfaces;

import com.diego.smarsoft.models.entities.Invoice;

import java.util.List;
import java.util.Optional;

public interface InvoiceRepositoryInterface {
    List<Invoice> getAll();
    Invoice save(Invoice invoice);
    List<Invoice> findByIdClient(Long idClient);
    Optional<Invoice> findById(Long id);
}
