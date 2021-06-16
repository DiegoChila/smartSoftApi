package com.diego.smarsoft.models.dto.responses.invoices;

import java.util.List;

public class NewInvoiceDto {
    private boolean success;
    private InvoiceDto invoice;
    private List<String> errors;

    public NewInvoiceDto(boolean success, InvoiceDto invoice, List<String> errors) {
        this.success = success;
        this.invoice = invoice;
        this.errors = errors;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public InvoiceDto getInvoice() {
        return invoice;
    }

    public void setInvoice(InvoiceDto invoice) {
        this.invoice = invoice;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
