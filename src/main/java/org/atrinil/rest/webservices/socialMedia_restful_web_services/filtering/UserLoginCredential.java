package org.atrinil.rest.webservices.socialMedia_restful_web_services.filtering;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"securityQuestion1", "securityAnswer1"})
public class UserLoginCredential {
    private String userName;
    @JsonIgnore
    private String password;
    private String securityQuestion1;
    private String securityAnswer1;

    public UserLoginCredential(String field1, String field2, String field3, String field4) {
        super();
        this.userName = field1;
        this.password = field2;
        this.securityQuestion1 = field3;
        this.securityAnswer1 = field4;
    }

    @Override
    public String toString() {
        return "UserLoginCredential{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", securityQuestion1='" + securityQuestion1 + '\'' +
                ", securityAnswer1='" + securityAnswer1 + '\'' +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSecurityQuestion1() {
        return securityQuestion1;
    }

    public void setSecurityQuestion1(String securityQuestion1) {
        this.securityQuestion1 = securityQuestion1;
    }

    public String getSecurityAnswer1() {
        return securityAnswer1;
    }

    public void setSecurityAnswer1(String securityAnswer1) {
        this.securityAnswer1 = securityAnswer1;
    }
}
