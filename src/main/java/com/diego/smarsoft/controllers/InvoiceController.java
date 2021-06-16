package com.diego.smarsoft.controllers;

import com.diego.smarsoft.models.dto.responses.clients.NewClientDto;
import com.diego.smarsoft.models.dto.responses.invoices.InvoiceDto;
import com.diego.smarsoft.models.dto.responses.invoices.NewInvoiceDto;
import com.diego.smarsoft.models.entities.Invoice;
import com.diego.smarsoft.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/invoices")
@CrossOrigin(origins = "*")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;

    @GetMapping
    public List<InvoiceDto> getAll() {
        return invoiceService.getAll();
    }

    @PostMapping
    public NewInvoiceDto save(@RequestBody @Valid Invoice invoice, BindingResult result) {
        if (result.hasErrors()) {
            List<ObjectError> objectsErrors = result.getAllErrors();
            List<String> errors = new ArrayList<String>();
            for (ObjectError error: objectsErrors) {
                errors.add(error.getDefaultMessage());
            }
            return new NewInvoiceDto(false, null, errors);
        }
        return invoiceService.save(invoice);
    }

    @GetMapping("/{idClient}")
    public List<InvoiceDto> getByClient(@PathVariable("idClient") Long idClient) {
        return invoiceService.getByClient(idClient);
    }
}
