package org.atrinil.rest.webservices.socialMedia_restful_web_services.versioning;

public class PersonV2 {
    private final String fName;
    private final String mName;
    private final String lName;

    public PersonV2(String fName, String mName, String lName) {
        this.fName = fName;
        this.mName = mName;
        this.lName = lName;
    }

    public String getfName() {
        return fName;
    }

    public String getmName() {
        return mName;
    }

    public String getlName() {
        return lName;
    }

    @Override
    public String toString() {
        return "PersonV2{" +
                "fName='" + fName + '\'' +
                ", mName='" + mName + '\'' +
                ", lName='" + lName + '\'' +
                '}';
    }
}
