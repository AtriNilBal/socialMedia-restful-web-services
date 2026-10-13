package org.atrinil.rest.webservices.socialMedia_restful_web_services.authentication;

public class AuthResponseDto {

    private String token;

    public AuthResponseDto(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

}
