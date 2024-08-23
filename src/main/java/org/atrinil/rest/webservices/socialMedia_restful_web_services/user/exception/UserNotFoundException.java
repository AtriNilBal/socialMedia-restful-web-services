package org.atrinil.rest.webservices.socialMedia_restful_web_services.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(String.format("User with %s does not exist", message));
    }
}
