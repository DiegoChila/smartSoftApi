package com.diego.smarsoft.models.dto.responses.details;

import java.util.List;

public class NewDetailDto {
    private boolean success;
    private List<String> errors;

    public NewDetailDto(boolean success, List<String> errors) {
        this.success = success;
        this.errors = errors;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
