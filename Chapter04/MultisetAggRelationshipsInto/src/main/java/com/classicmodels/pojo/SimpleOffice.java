package com.classicmodels.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class SimpleOffice implements Serializable {

    private static final long serialVersionUID = 1;
    
    private String officeCode;    
    private String state;
    private String city;
    
    @JsonInclude(Include.NON_EMPTY)
    private List<SimpleManager> managers;

    // this constructor is a must
    public SimpleOffice(String officeCode, String state, String city) {
        this.officeCode = officeCode;
        this.state = state;
        this.city = city;
    }        

    public String getOfficeCode() {
        return officeCode;
    }

    public void setOfficeCode(String officeCode) {
        this.officeCode = officeCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<SimpleManager> getManagers() {
        return managers;
    }

    public void setManagers(List<SimpleManager> managers) {
        this.managers = managers;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.officeCode);
        hash = 73 * hash + Objects.hashCode(this.state);
        hash = 73 * hash + Objects.hashCode(this.city);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SimpleOffice other = (SimpleOffice) obj;
        if (!Objects.equals(this.officeCode, other.officeCode)) {
            return false;
        }
        if (!Objects.equals(this.state, other.state)) {
            return false;
        }
        if (!Objects.equals(this.city, other.city)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Office{" + "officeCode=" + officeCode
                + ", state=" + state + ", city=" + city + '}';
    }
}
