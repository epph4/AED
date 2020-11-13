/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food.ac.thaed.test.tamsang.model.message;

import food.ac.thaed.test.tamsang.model.entity.ProductOrder;
import java.io.Serializable;

/**
 *
 * @author AF
 */
public class ProductOrderChangeInfo implements Serializable{
    
    private ProductOrder newProductOrder;
    private ProductOrder oldProductOrder;

    /**
     * @return the newProductOrder
     */
    public ProductOrder getNewProductOrder() {
        return newProductOrder;
    }

    /**
     * @param newProductOrder the newProductOrder to set
     */
    public void setNewProductOrder(ProductOrder newProductOrder) {
        this.newProductOrder = newProductOrder;
    }

    /**
     * @return the oldProductOrder
     */
    public ProductOrder getOldProductOrder() {
        return oldProductOrder;
    }

    /**
     * @param oldProductOrder the oldProductOrder to set
     */
    public void setOldProductOrder(ProductOrder oldProductOrder) {
        this.oldProductOrder = oldProductOrder;
    }
    
}
