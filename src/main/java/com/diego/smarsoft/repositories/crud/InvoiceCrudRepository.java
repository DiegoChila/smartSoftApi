package com.diego.smarsoft.repositories.crud;

import com.diego.smarsoft.models.entities.Invoice;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InvoiceCrudRepository extends CrudRepository<Invoice, Long> {
    List<Invoice> findByIdClient(Long idClient);
}
