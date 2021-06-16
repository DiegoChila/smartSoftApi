package com.diego.smarsoft.services;

import com.diego.smarsoft.models.dto.responses.clients.NewClientDto;
import com.diego.smarsoft.models.dto.responses.clients.ClientDto;
import com.diego.smarsoft.models.entities.Client;
import com.diego.smarsoft.repositories.classes.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<ClientDto> getAll() {
        List<Client> clients = clientRepository.getAll();
        List<ClientDto> clientsDto = new ArrayList<>();
        for (Client client: clients) {
            clientsDto.add(new ClientDto(client.getId(), client.getName()+" "+client.getLastname(),
                    client.getAddress(), client.getBirthday(), client.getTel(), client.getEmail(), client.getInvoices().size()));
        }
        return clientsDto;
    }

    public NewClientDto save(Client client) {
        Client newClient = clientRepository.save(client);
        return new NewClientDto(true, new ClientDto(newClient.getId(), newClient.getName()+" "+newClient.getLastname(), newClient.getAddress(), newClient.getBirthday(), newClient.getTel(), newClient.getEmail(), newClient.getInvoices() != null ? newClient.getInvoices().size() : 0), null);
    }
}
