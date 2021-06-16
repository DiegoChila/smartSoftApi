package com.diego.smarsoft.controllers;

import com.diego.smarsoft.models.dto.responses.clients.NewClientDto;
import com.diego.smarsoft.models.dto.responses.clients.ClientDto;
import com.diego.smarsoft.models.entities.Client;
import com.diego.smarsoft.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/clients")
@CrossOrigin(origins = "*")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<ClientDto> getAll() {
        return clientService.getAll();
    }

    @PostMapping
    public NewClientDto save(@RequestBody @Valid Client client, BindingResult result) {
        if (result.hasErrors()) {
            List<ObjectError> objectsErrors = result.getAllErrors();
            List<String> errors = new ArrayList<String>();
            for (ObjectError error: objectsErrors) {
                errors.add(error.getDefaultMessage());
            }
            return new NewClientDto(false, null, errors);
        }
        return clientService.save(client);
    }
}
