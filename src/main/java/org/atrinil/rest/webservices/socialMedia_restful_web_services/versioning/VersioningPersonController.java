package org.atrinil.rest.webservices.socialMedia_restful_web_services.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

    @GetMapping(value = "/v1/person")
    public PersonV1 getFirstVersionOfPerson() {
        return new PersonV1("Krudger Brent");
    }

    @GetMapping(value = "/v2/person")
    public PersonV2 getSecondVersionOfPerson() {
        return new PersonV2("Krudger", "", "Brent");
    }
}
