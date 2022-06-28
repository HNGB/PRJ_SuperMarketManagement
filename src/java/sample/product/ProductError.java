/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.product;

import java.sql.Date;

/**
 *
 * @author lehad
 */
public class ProductError {
    private String productIDError;
    private String productNameError;
    private String imageError;
    private Float priceError;
    private int quantityError;
    private String categoryIDError;
    private Date importDateError;
    private Date usingDateError;

    public ProductError() {
        this.productIDError = "";
        this.productNameError = "";
        this.imageError = "";
        this.priceError = null;
        this.quantityError = 0;
        this.categoryIDError = "";
        this.importDateError = null;
        this.usingDateError = null;
    }

    public ProductError(String productIDError, String productNameError, String imageError, Float priceError, int quantityError, String categoryIDError, Date importDateError, Date usingDateError) {
        this.productIDError = productIDError;
        this.productNameError = productNameError;
        this.imageError = imageError;
        this.priceError = priceError;
        this.quantityError = quantityError;
        this.categoryIDError = categoryIDError;
        this.importDateError = importDateError;
        this.usingDateError = usingDateError;
    }

    public String getProductIDError() {
        return productIDError;
    }

    public void setProductIDError(String productIDError) {
        this.productIDError = productIDError;
    }

    public String getProductNameError() {
        return productNameError;
    }

    public void setProductNameError(String productNameError) {
        this.productNameError = productNameError;
    }

    public String getImageError() {
        return imageError;
    }

    public void setImageError(String imageError) {
        this.imageError = imageError;
    }

    public Float getPriceError() {
        return priceError;
    }

    public void setPriceError(Float priceError) {
        this.priceError = priceError;
    }

    public int getQuantityError() {
        return quantityError;
    }

    public void setQuantityError(int quantityError) {
        this.quantityError = quantityError;
    }

    public String getCategoryIDError() {
        return categoryIDError;
    }

    public void setCategoryIDError(String categoryIDError) {
        this.categoryIDError = categoryIDError;
    }

    public Date getImportDateError() {
        return importDateError;
    }

    public void setImportDateError(Date importDateError) {
        this.importDateError = importDateError;
    }

    public Date getUsingDateError() {
        return usingDateError;
    }

    public void setUsingDateError(Date usingDateError) {
        this.usingDateError = usingDateError;
    }

    public void setPriceError(String price_must_be__0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setQuantityError(String quantity_must_be__1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
