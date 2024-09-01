package org.atrinil.rest.webservices.socialMedia_restful_web_services.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public MappingJacksonValue filtering() {
        //MappingJacksonValue to enable dynamic filtering to add specific serialization instruction to pass to jackson converter
        UserLoginCredential userLoginCredential = new UserLoginCredential("value1", "value2", "value3", "value4");
        List<UserLoginCredential> userLoginCredentialList = new ArrayList<>();
        userLoginCredentialList.add(userLoginCredential);

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("userName", "securityQuestion1");
        MappingJacksonValue mappingJacksonValue = getMappingJacksonValue(userLoginCredentialList, filter);

        return mappingJacksonValue;
    }

    @GetMapping("/filtering-list")
    public MappingJacksonValue filteringList() {

        List<UserLoginCredential> userLoginCredentialList = Arrays.asList(new UserLoginCredential("value1", "value2", "value3", "value4")
                , new UserLoginCredential("value4", "value5", "value6", "value7"));

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("userName");

        MappingJacksonValue mappingJacksonValue = getMappingJacksonValue(userLoginCredentialList, filter);
        
        return mappingJacksonValue;
    }

    private static MappingJacksonValue getMappingJacksonValue(List<UserLoginCredential> userLoginCredentialList, SimpleBeanPropertyFilter filter) {
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(userLoginCredentialList);

        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
        mappingJacksonValue.setFilters(filters);
        
        return mappingJacksonValue;
    }
}
