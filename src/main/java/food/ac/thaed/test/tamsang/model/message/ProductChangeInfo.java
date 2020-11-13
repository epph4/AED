/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food.ac.thaed.test.tamsang.model.message;

import food.ac.thaed.test.tamsang.model.entity.Product;
import java.io.Serializable;

/**
 *
 * @author AF
 */
public class ProductChangeInfo implements Serializable{
    private Product newProduct;
    private Product oldProduct;

    /**
     * @return the newProduct
     */
    public Product getNewProduct() {
        return newProduct;
    }

    /**
     * @param newProduct the newProduct to set
     */
    public void setNewProduct(Product newProduct) {
        this.newProduct = newProduct;
    }

    /**
     * @return the oldProduct
     */
    public Product getOldProduct() {
        return oldProduct;
    }

    /**
     * @param oldProduct the oldProduct to set
     */
    public void setOldProduct(Product oldProduct) {
        this.oldProduct = oldProduct;
    }
    
    
}
