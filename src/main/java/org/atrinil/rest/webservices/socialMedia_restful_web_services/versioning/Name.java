package org.atrinil.rest.webservices.socialMedia_restful_web_services.versioning;

public class Name {
    private String fName;
    private String mName;
    private String lName;

    public Name(String lName, String mName, String fName) {
        super();
        this.lName = lName;
        this.mName = mName;
        this.fName = fName;
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
        return "Name{" +
                "fName='" + fName + '\'' +
                ", mName='" + mName + '\'' +
                ", lName='" + lName + '\'' +
                '}';
    }
}
