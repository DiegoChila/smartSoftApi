package com.diego.smarsoft.controllers;

import com.diego.smarsoft.models.dto.requests.details.AddDetailsDto;
import com.diego.smarsoft.models.dto.responses.details.DetailDto;
import com.diego.smarsoft.models.dto.responses.details.NewDetailDto;
import com.diego.smarsoft.models.dto.responses.invoices.NewInvoiceDto;
import com.diego.smarsoft.models.entities.Detail;
import com.diego.smarsoft.services.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/details")
@CrossOrigin(origins = "*")
public class DetailController {
    @Autowired
    private DetailService detailService;

    @GetMapping
    public List<DetailDto> getAll() {
        return detailService.getAll();
    }

    @PostMapping
    public NewDetailDto save(@RequestBody @Valid AddDetailsDto details, BindingResult result) {
        if (result.hasErrors()) {
            List<ObjectError> objectsErrors = result.getAllErrors();
            List<String> errors = new ArrayList<String>();
            for (ObjectError error: objectsErrors) {
                errors.add(error.getDefaultMessage());
            }
            return new NewDetailDto(false, errors);
        }
        return detailService.save(details);
    }
}
