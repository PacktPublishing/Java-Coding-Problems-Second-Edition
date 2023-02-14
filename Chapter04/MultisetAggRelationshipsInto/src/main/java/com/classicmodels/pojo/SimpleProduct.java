package com.classicmodels.pojo;

import java.io.Serializable;
import java.util.Objects;

public class SimpleProduct implements Serializable {

    private static final long serialVersionUID = 1;
    
    private String productName;
    private String productVendor;
    private Integer quantityInStock;

    // this constructor is a must
    public SimpleProduct(String productName, String productVendor, Integer quantityInStock) {
        this.productName = productName;
        this.productVendor = productVendor;
        this.quantityInStock = quantityInStock;
    }        

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductVendor() {
        return productVendor;
    }

    public void setProductVendor(String productVendor) {
        this.productVendor = productVendor;
    }

    public Integer getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(Integer quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    @Override
    public int hashCode() {
        
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.productName);
        hash = 23 * hash + Objects.hashCode(this.productVendor);
        hash = 23 * hash + Objects.hashCode(this.quantityInStock);
        
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
        
        final SimpleProduct other = (SimpleProduct) obj;
        if (!Objects.equals(this.productName, other.productName)) {
            return false;
        }
        
        if (!Objects.equals(this.productVendor, other.productVendor)) {
            return false;
        }
        
        if (!Objects.equals(this.quantityInStock, other.quantityInStock)) {
            return false;
        }
        
        return true;
    }

    @Override
    public String toString() {
        return "Product{" + "productName=" + productName 
                + ", productVendor=" + productVendor 
                + ", quantityInStock=" + quantityInStock + '}';
    }
       
}