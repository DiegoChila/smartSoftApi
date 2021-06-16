package com.diego.smarsoft.models.dto.requests.details;

import javax.validation.constraints.NotNull;
import java.util.List;

public class AddDetailsDto {
    @NotNull(message = "Debe especificar la factura")
    private Long idInvoice;

    @NotNull(message = "Debe especificar los detalles")
    private List<NewDetailItemDto> details;

    public Long getIdInvoice() {
        return idInvoice;
    }

    public void setIdInvoice(Long idInvoice) {
        this.idInvoice = idInvoice;
    }

    public List<NewDetailItemDto> getDetails() {
        return details;
    }

    public void setDetails(List<NewDetailItemDto> details) {
        this.details = details;
    }
}
