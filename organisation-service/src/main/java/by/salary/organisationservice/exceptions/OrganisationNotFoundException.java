package by.salary.organisationservice.exceptions;

import org.springframework.http.HttpStatus;

public class OrganisationNotFoundException extends AbstractException {

    private final HttpStatus status;

    public OrganisationNotFoundException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    @Override
    public HttpStatus getStatus() {
        return status;
    }
}
