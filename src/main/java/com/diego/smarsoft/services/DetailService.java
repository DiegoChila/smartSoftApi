package com.diego.smarsoft.services;

import com.diego.smarsoft.models.dto.requests.details.AddDetailsDto;
import com.diego.smarsoft.models.dto.requests.details.NewDetailItemDto;
import com.diego.smarsoft.models.dto.responses.details.DetailDto;
import com.diego.smarsoft.models.dto.responses.details.NewDetailDto;
import com.diego.smarsoft.models.dto.responses.invoices.InvoiceDto;
import com.diego.smarsoft.models.dto.responses.products.ProductDto;
import com.diego.smarsoft.models.entities.Detail;
import com.diego.smarsoft.models.entities.Invoice;
import com.diego.smarsoft.models.entities.Product;
import com.diego.smarsoft.repositories.classes.DetailRepository;
import com.diego.smarsoft.repositories.classes.InvoiceRepository;
import com.diego.smarsoft.repositories.classes.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DetailService {
    @Autowired
    private DetailRepository detailRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private InvoiceRepository invoiceRepository;

    public List<DetailDto> getAll() {
        List<Detail> details = detailRepository.getAll();
        List<DetailDto> detailsDto = new ArrayList<>();
        for (Detail detail: details) {
            Invoice invoice = invoiceRepository.findById(detail.getIdInvoice()).orElse(null);
            Product product = productRepository.findById(detail.getIdProduct()).orElse(null);
            if (invoice != null && product != null) {
                detailsDto.add(new DetailDto(detail.getId(), new InvoiceDto(invoice.getId(), invoice.getDate(), null),
                        new ProductDto(product.getId(), product.getName(), product.getStock(), product.getPrice()), detail.getQuantity(), detail.getPrice()));
            }
        }
        return detailsDto;
    }

    public NewDetailDto save(AddDetailsDto addDetailsDto) {
        List<NewDetailItemDto> details = addDetailsDto.getDetails();
        Long idInvoice = addDetailsDto.getIdInvoice();
        List<String> errors = new ArrayList<>();
        boolean dataComplete = true;
        boolean existsAllProducts = true;
        boolean existsStock = true;
        for (NewDetailItemDto detail: details) {
            if (detail.getIdProduct() == null || detail.getQuantity() == null) dataComplete = false;
            Product product = productRepository.findById(detail.getIdProduct()).orElse(null);
            if (product != null) {
                if (product.getStock() < detail.getQuantity()) existsStock = false;
            } else existsAllProducts = false;
        }
        if (!dataComplete) errors.add("La información esta incompleta");
        if (!existsAllProducts) errors.add("Algunos productos no existen");
        if (!existsStock) errors.add("No existe stock suficiente para algunos productos");
        if (!dataComplete || !existsAllProducts || !existsStock) {
            return new NewDetailDto(false, errors);
        }
        for (NewDetailItemDto detail: details) {
            Detail newDetail = new Detail();
            Product product = productRepository.findById(detail.getIdProduct()).orElse(null);
            newDetail.setIdInvoice(idInvoice);
            newDetail.setIdProduct(detail.getIdProduct());
            newDetail.setQuantity(detail.getQuantity());
            int price = detail.getQuantity() * product.getPrice();
            newDetail.setPrice(price);
            detailRepository.save(newDetail);
            product.setStock(product.getStock() - detail.getQuantity());
            productRepository.save(product);
        }
        return new NewDetailDto(true, null);
    }
}
