package by.salary.useragreementservice.exceptions;

import org.springframework.http.HttpStatus;

public class CustomerNotFoundException extends AbstractException {

    private final HttpStatus status;

    public CustomerNotFoundException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    @Override
    public HttpStatus getStatus() {
        return status;
    }
}
