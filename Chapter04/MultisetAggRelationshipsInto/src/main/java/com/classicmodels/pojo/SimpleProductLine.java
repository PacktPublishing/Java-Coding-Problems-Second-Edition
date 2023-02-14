package com.classicmodels.pojo;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class SimpleProductLine implements Serializable {

    private static final long serialVersionUID = 1;
    
    private String productLine;
    private String textDescription;   
    private List<SimpleProduct> products;

    // this constructor is a must
    public SimpleProductLine(String productLine, String textDescription, List<SimpleProduct> products) {
        this.productLine = productLine;
        this.textDescription = textDescription;
        this.products = products;
    }        

    public String getProductLine() {
        return productLine;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    public String getTextDescription() {
        return textDescription;
    }

    public void setTextDescription(String textDescription) {
        this.textDescription = textDescription;
    }

    public List<SimpleProduct> getProducts() {
        return products;
    }

    public void setProducts(List<SimpleProduct> products) {
        this.products = products;
    }

    @Override
    public int hashCode() {
        
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.productLine);
        hash = 37 * hash + Objects.hashCode(this.textDescription);
        
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
        
        final SimpleProductLine other = (SimpleProductLine) obj;
        if (!Objects.equals(this.productLine, other.productLine)) {
            return false;
        }
        
        if (!Objects.equals(this.textDescription, other.textDescription)) {
            return false;
        }
        
        return true;
    }

    @Override
    public String toString() {
        return "ProductLine{" + "productLine=" + productLine 
                + ", textDescription=" + textDescription + ", products=" + products + '}';
    }
           
}