package com.diego.smarsoft.models.dto.responses.invoices;

import com.diego.smarsoft.models.dto.responses.details.DetailDto;
import com.diego.smarsoft.models.entities.Detail;

import java.util.Date;
import java.util.List;

public class InvoiceDto {
    private Long id;
    private Date date;
    private List<DetailDto> details;

    public InvoiceDto(Long id, Date date, List<DetailDto> details) {
        this.id = id;
        this.date = date;
        this.details = details;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<DetailDto> getDetails() {
        return details;
    }

    public void setDetails(List<DetailDto> details) {
        this.details = details;
    }
}
