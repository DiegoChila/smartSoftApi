package com.diego.smarsoft.repositories.crud;

import com.diego.smarsoft.models.entities.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientCrudRepository extends CrudRepository<Client, Long> {
}
