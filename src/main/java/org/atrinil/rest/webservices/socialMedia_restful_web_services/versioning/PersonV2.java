package org.atrinil.rest.webservices.socialMedia_restful_web_services.versioning;

public class PersonV2 {
    private Name name;

    public PersonV2(Name name) {
        super();
        this.name = name;
    }

    public Name getName() {
        return name;
    }

    @Override
    public String toString() {
        return name.toString();
    }
}
