package com.diego.smarsoft.models.dto.responses.clients;

import com.diego.smarsoft.models.dto.responses.clients.ClientDto;
import com.diego.smarsoft.models.entities.Client;

import java.util.List;

public class NewClientDto {
    private boolean success;
    private ClientDto client;
    private List<String> errors;

    public NewClientDto(boolean success, ClientDto client, List<String> errors) {
        this.success = success;
        this.client = client;
        this.errors = errors;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public ClientDto getClient() {
        return client;
    }

    public void setClient(ClientDto client) {
        this.client = client;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
