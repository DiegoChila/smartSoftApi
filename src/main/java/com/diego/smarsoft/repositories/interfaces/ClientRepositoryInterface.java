package com.diego.smarsoft.repositories.interfaces;

import com.diego.smarsoft.models.entities.Client;

import java.util.List;

public interface ClientRepositoryInterface {
    List<Client> getAll();
    Client save(Client client);
    boolean existsById(Long id);
}
