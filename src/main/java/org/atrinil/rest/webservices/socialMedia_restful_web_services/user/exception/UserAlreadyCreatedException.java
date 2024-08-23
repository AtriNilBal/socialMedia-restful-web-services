package org.atrinil.rest.webservices.socialMedia_restful_web_services.user.exception;

import org.atrinil.rest.webservices.socialMedia_restful_web_services.user.User;

public class UserAlreadyCreatedException extends RuntimeException {
    public UserAlreadyCreatedException(String message) {
        super(String.format("Following user already created. Cannot create duplicate entry:\n %s", message));
    }
}
