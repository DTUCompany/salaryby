package by.salary.agreementservice.exceptions;

import org.springframework.http.HttpStatus;

public class AgreementNotFoundException extends AbstractException {

    private final HttpStatus status;

    public AgreementNotFoundException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    @Override
    public HttpStatus getStatus() {
        return status;
    }
}
