package com.diego.smarsoft.services;

import com.diego.smarsoft.models.dto.responses.details.DetailDto;
import com.diego.smarsoft.models.dto.responses.invoices.InvoiceDto;
import com.diego.smarsoft.models.dto.responses.invoices.NewInvoiceDto;
import com.diego.smarsoft.models.dto.responses.products.ProductDto;
import com.diego.smarsoft.models.entities.Detail;
import com.diego.smarsoft.models.entities.Invoice;
import com.diego.smarsoft.models.entities.Product;
import com.diego.smarsoft.repositories.classes.ClientRepository;
import com.diego.smarsoft.repositories.classes.InvoiceRepository;
import com.diego.smarsoft.repositories.classes.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InvoiceService {
    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ProductRepository productRepository;

    public List<InvoiceDto> getAll() {
        List<Invoice> invoices = invoiceRepository.getAll();
        List<InvoiceDto> invoicesDto = new ArrayList<>();
        for (Invoice invoice: invoices) {
            List<Detail> details = invoice.getDetails();
            List<DetailDto> detailsDto = new ArrayList<>();
            for (Detail detail: details) {
                Product product = productRepository.findById(detail.getIdProduct()).orElse(null);
                ProductDto productDto;
                if (product != null) productDto = new ProductDto(product.getId(), product.getName(), product.getPrice(), product.getStock());
                else productDto = null;
                detailsDto.add(new DetailDto(detail.getId(), null, productDto ,detail.getQuantity(), detail.getPrice()));
            }
            invoicesDto.add(new InvoiceDto(invoice.getId(), invoice.getDate(), detailsDto));
        }
        return invoicesDto;
    }

    public NewInvoiceDto save(Invoice invoice) {
        if (clientRepository.existsById(invoice.getIdClient())) {
            Invoice newInvoice = invoiceRepository.save(invoice);
            return new NewInvoiceDto(true, new InvoiceDto(newInvoice.getId(), newInvoice.getDate(), null), null);
        } else {
            List<String> errors = new ArrayList<>();
            errors.add("El cliente asociado no existe");
            return new NewInvoiceDto(false, null, errors);
        }
    }

    public List<InvoiceDto> getByClient(Long idClient) {
        List<Invoice> invoices = invoiceRepository.findByIdClient(idClient);
        List<InvoiceDto> invoicesDto = new ArrayList<>();
        for (Invoice invoice: invoices) {
            List<Detail> details = invoice.getDetails();
            List<DetailDto> detailsDto = new ArrayList<>();
            for (Detail detail: details) {
                Product product = productRepository.findById(detail.getIdProduct()).orElse(null);
                ProductDto productDto;
                if (product != null) productDto = new ProductDto(product.getId(), product.getName(), product.getPrice(), product.getStock());
                else productDto = null;
                detailsDto.add(new DetailDto(detail.getId(), null, productDto ,detail.getQuantity(), detail.getPrice()));
            }
            invoicesDto.add(new InvoiceDto(invoice.getId(), invoice.getDate(), detailsDto));
        }
        return invoicesDto;
    }
}
