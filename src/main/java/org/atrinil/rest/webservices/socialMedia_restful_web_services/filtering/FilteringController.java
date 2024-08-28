package org.atrinil.rest.webservices.socialMedia_restful_web_services.filtering;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public UserLoginCredential filtering() {
        return new UserLoginCredential("value1", "value2", "value3", "value4");
    }

    @GetMapping("/filtering-list")
    public List<UserLoginCredential> filteringList() {
        return Arrays.asList(new UserLoginCredential("value1", "value2", "value3", "value4")
        , new UserLoginCredential("value4", "value5", "value6", "value7"));
    }
}
