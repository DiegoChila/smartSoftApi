package com.diego.smarsoft.repositories.classes;

import com.diego.smarsoft.models.entities.Client;
import com.diego.smarsoft.repositories.crud.ClientCrudRepository;
import com.diego.smarsoft.repositories.interfaces.ClientRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientRepository implements ClientRepositoryInterface {
    @Autowired
    private ClientCrudRepository clientCrudRepository;

    @Override
    public List<Client> getAll() {
        return (List<Client>) clientCrudRepository.findAll();
    }

    @Override
    public Client save(Client client) {
        return clientCrudRepository.save(client);
    }

    @Override
    public boolean existsById(Long id) {
        return clientCrudRepository.existsById(id);
    }
}
