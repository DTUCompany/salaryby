package by.salary.userservice.exceptions;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends AbstractException {

    private final HttpStatus status;

    public UserNotFoundException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    @Override
    public HttpStatus getStatus() {
        return status;
    }
}
