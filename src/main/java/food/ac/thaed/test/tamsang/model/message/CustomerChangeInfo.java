/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food.ac.thaed.test.tamsang.model.message;

import food.ac.thaed.test.tamsang.model.entity.Customer;
import java.io.Serializable;

/**
 *
 * @author AF
 */
public class CustomerChangeInfo implements Serializable{
    
    private Customer newCustomer;
    private Customer oldCustomer;

    /**
     * @return the newCustomer
     */
    public Customer getNewCustomer() {
        return newCustomer;
    }

    /**
     * @param newCustomer the newCustomer to set
     */
    public void setNewCustomer(Customer newCustomer) {
        this.newCustomer = newCustomer;
    }

    /**
     * @return the oldCustomer
     */
    public Customer getOldCustomer() {
        return oldCustomer;
    }

    /**
     * @param oldCustomer the oldCustomer to set
     */
    public void setOldCustomer(Customer oldCustomer) {
        this.oldCustomer = oldCustomer;
    }
    
    
}
